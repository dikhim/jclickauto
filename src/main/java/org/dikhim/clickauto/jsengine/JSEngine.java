package org.dikhim.clickauto.jsengine;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import org.dikhim.clickauto.jsengine.robot.Robot;
import org.dikhim.clickauto.util.Out;
import org.dikhim.clickauto.jsengine.objects.*;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class JSEngine {
    private BooleanProperty running = new SimpleBooleanProperty(false);

    private final Robot robot;
    private ScriptEngine engine;
    private Thread thread;
    private String code;

    private MethodInvoker methodInvoker;


    public JSEngine(Robot robot) {
        this.robot = robot;
    }

    public Robot getRobot() {
        return robot;
    }

    public void start() {
        stop();
        thread = new Thread(() -> {
            engine = new ScriptEngineManager().getEngineByName("nashorn");
            methodInvoker = new MethodInvoker(engine);
            KeyboardObject keyboardObject = new ScriptKeyboardObject(robot);
            MouseObject mouseObject = new ScriptMouseObject(robot);
            SystemObject systemObject = new ScriptSystemObject(this);
            CombinedObject combinedObject = new ScriptCombinedObject(mouseObject, keyboardObject, systemObject);
            ClipboardObject clipboardObject = new ScriptClipboardObject(robot);
            CreateObject createObject = new ScriptCreateObject();

            engine.put("mouse", mouseObject);
            engine.put("key", keyboardObject);
            engine.put("system", systemObject);
            engine.put("combined", combinedObject);
            engine.put("clipboard", clipboardObject);
            engine.put("create", createObject);
            try {
                engine.eval(code);
                
            } catch (ScriptException e) {
                Out.println(e.getMessage());
                stop();
            }
        });
        thread.start();
        running.setValue(true);
    }

    public void putCode(String code) {
        this.code = code;
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

    public void invokeFunction(String name, Object... args) {
        methodInvoker.invokeMethod(name, args);
    }

    public void registerInvocableMethod(String name, int maxNumberOfThreads) {
        methodInvoker.registerMethod(name, maxNumberOfThreads);
    }

    public boolean isRunning() {
        return running.get();
    }

    public BooleanProperty runningProperty() {
        return running;
    }

    public void eval(String script) throws ScriptException {
        if (isRunning()) {
            engine.eval(code);
        }
    }
    
}
