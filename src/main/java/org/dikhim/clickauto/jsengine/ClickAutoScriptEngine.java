package org.dikhim.clickauto.jsengine;

import org.dikhim.clickauto.jsengine.objects.*;
import org.dikhim.clickauto.jsengine.robot.Robot;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClickAutoScriptEngine {

    private final Robot robot;
    private ScriptEngine engine;
    private MethodInvoker methodInvoker;
    private Thread thread;
    private final static int TIME_TO_WAIT_INTERRUPTION =1000;
    private int timeToWaitInterruption = TIME_TO_WAIT_INTERRUPTION;

    public ClickAutoScriptEngine(Robot robot) {
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
        try {
            if (thread != null) {
                thread.interrupt();
                System.out.println("interrupt" + thread.getName());
                thread.join(timeToWaitInterruption);
                System.out.println("waitComplete");
                if (thread.isAlive()) {
                    try {
                        thread.stop();
                    } catch (ThreadDeath ignored) {
                    }
                }
                thread = null;
            }
            if (methodInvoker != null) {
                methodInvoker.stop();
                methodInvoker = null;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
        KeyboardObject keyboardObject = new ScriptKeyboardObject(robot);
        MouseObject mouseObject = new ScriptMouseObject(robot);
        SystemObject systemObject = new ScriptSystemObject(this);
        CombinedObject combinedObject = new ScriptCombinedObject(mouseObject, keyboardObject, systemObject);
        ClipboardObject clipboardObject = new ScriptClipboardObject(robot);
        CreateObject createObject = new ScriptCreateObject();
        ThreadObject threadObject = new ScriptThreadObject();
        defaultObjects.clear();
        defaultObjects.put("key", keyboardObject);
        defaultObjects.put("mouse", mouseObject);
        defaultObjects.put("system", systemObject);
        defaultObjects.put("combined", combinedObject);
        defaultObjects.put("clipboard", clipboardObject);
        defaultObjects.put("create", createObject);
        defaultObjects.put("thread", threadObject);
        objects.putAll(defaultObjects);
    }

    private void loadScriptObjects() {
        objects.forEach((name, object) -> engine.put(name, object));
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
        timeToWaitInterruption = TIME_TO_WAIT_INTERRUPTION;
    }

    public int getTimeToWaitInterruption() {
        return timeToWaitInterruption;
    }

    public void setTimeToWaitInterruption(int timeToWaitInterruption) {
        this.timeToWaitInterruption = timeToWaitInterruption;
    }

    public Robot getRobot() {
        return this.robot;
    }

    public Map<String, Object> getObjects() {
        return objects;
    }
}
