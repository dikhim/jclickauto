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
    }

    public void start() {
        scripts.forEach(s-> {
            try {
                engine.eval(s);
            } catch (ScriptException e) {
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

    public void eval(String script) {
        if (isRunning()) {
            try {
                engine.eval(script);
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        } else {
            scripts.add(script);
        } 
    }
    
    private Map<String, Object> scriptObjects = new HashMap<>();
    public void putObject(String name, Object object) {
        scriptObjects.put(name, object);
    }
    
    
    
    private void loadDefaultScriptObjects() {
        KeyboardObject keyboardObject = new JsKeyboardObject(robot);
        MouseObject mouseObject = new JsMouseObject(robot);
        SystemObject systemObject = new JsSystemObject(robot);
        CombinedObject combinedObject = new JsCombinedObject(mouseObject, keyboardObject, systemObject);
        ClipboardObject clipboardObject = new JsClipboardObject(robot);
        CreateObject createObject = new JsCreateObject();
        scriptObjects.clear();
        scriptObjects.put("key", keyboardObject);
        scriptObjects.put("mouse", mouseObject);
        scriptObjects.put("system", systemObject);
        scriptObjects.put("combined", combinedObject);
        scriptObjects.put("clipboard", clipboardObject);
        scriptObjects.put("create", createObject);
    }
    
    
    public boolean isRunning() {
        return false;
    }
}
