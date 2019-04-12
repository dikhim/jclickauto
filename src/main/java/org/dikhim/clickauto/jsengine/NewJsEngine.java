package org.dikhim.clickauto.jsengine;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import org.dikhim.clickauto.jsengine.objects.*;
import org.dikhim.clickauto.jsengine.robot.Robot;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewJsEngine {
    private BooleanProperty running = new SimpleBooleanProperty(false);

    private final Robot robot;
    private ScriptEngine engine;
    private MethodInvoker methodInvoker;
    private Thread thread;

    public NewJsEngine(Robot robot) {
        this.robot = robot;
        engine = new ScriptEngineManager().getEngineByName("nashorn");
        methodInvoker = new MethodInvoker(engine);
        initScriptObjects();
    }

    // On start run all scripts in new thread
    public void start() {
        runInNewThread(() ->
        {
            engine = new ScriptEngineManager().getEngineByName("nashorn");
            methodInvoker = new MethodInvoker(engine);
            loadScriptObjects();
            try {
                for (String s : scripts) {
                    engine.eval(s);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Stops the engine
     */
    @SuppressWarnings("deprecation")
    public void stop() {
        if (thread != null) {
            try {
                thread.stop();
            } catch (ThreadDeath ignored) {

            }
            thread = null;
        }
        if (methodInvoker != null) {
            methodInvoker.stop();
            methodInvoker = null;
        }
        running.setValue(false);
    }

    private List<String> scripts = new ArrayList<>();

    public void putScript(String script) {
        scripts.add(script);
    }

    private Map<String, Object> objects = new HashMap<>();
    public void putObject(String name, Object object) {
        objects.put(name, object);
    }


    private Map<String, Object> defaultObjects = new HashMap<>();
    private boolean interrupted = false;
    private void initScriptObjects() {
        KeyboardObject keyboardObject = new JsKeyboardObject(robot);
        MouseObject mouseObject = new JsMouseObject(robot);
        SystemObject systemObject = new JsSystemObject(robot);
        CombinedObject combinedObject = new JsCombinedObject(mouseObject, keyboardObject, systemObject);
        ClipboardObject clipboardObject = new JsClipboardObject(robot);
        CreateObject createObject = new JsCreateObject();
        defaultObjects.clear();
        defaultObjects.put("key", keyboardObject);
        defaultObjects.put("mouse", mouseObject);
        defaultObjects.put("system", systemObject);
        defaultObjects.put("combined", combinedObject);
        defaultObjects.put("clipboard", clipboardObject);
        defaultObjects.put("create", createObject);
        defaultObjects.put("iterrupted", interrupted);
        objects.putAll(defaultObjects);
    }
    
    private void resetObjects() {
        objects.clear();
        objects.putAll(defaultObjects);
    }
    
    private void loadScriptObjects() {
        objects.forEach((name, object) -> engine.put(name,object));
    }

    public boolean isRunning() {
        return false;
    }

    private void runInNewThread(Runnable runnable) {
        thread = new Thread(runnable);
        thread.start();
    }


    public void invokeFunction(String name, Object... args) {
        methodInvoker.invokeMethod(name, args);
    }

    public void registerInvocableMethod(String name, int maxNumberOfThreads) {
        methodInvoker.registerMethod(name, maxNumberOfThreads);
    }
    
    public void removeScripts() {
        scripts.clear();
    }
    
    public void removeObjects() {
        objects.clear();
        objects.putAll(defaultObjects);
    }
        
    
    public void reset() {
        stop();
        removeObjects();
        removeScripts();
    }

}
