package org.dikhim.clickauto;

import org.dikhim.clickauto.jsengine.ClickAutoScriptEngine;
import org.dikhim.clickauto.jsengine.robot.Robot;
import org.dikhim.clickauto.jsengine.robot.RobotFactory;

import java.awt.*;
import java.util.Map;

public class ClickAuto {
    private ClickAutoScriptEngine engine;

    public ClickAuto() throws AWTException {
        engine = new ClickAutoScriptEngine(RobotFactory.get());
    }

    /**
     * Starts script engine. Any scripts that was putScript will be evaluated in new thread
     */
    public void start() {
        engine.start();
    }

    /**
     * Stops script engine. Sends interrupt request to all threads that life in engine.<br>
     * Status of thread may be checked by thread.interrupted() method<br>
     * The interrupt request should be proceed by script to do all necessary operations to complete the script.<br>
     * If after interrupt request thread is still alive, than it will be destroyed<br>
     * Destroying thread may cause crash for the script engine. Especially when it called right after the start() method. Better wait at least 500ms after start() method to call stop()
     */
    public void stop() {
        engine.stop();
    }
    
    /**
     * Put script into script engine. Script will be evaluated after start() method call
     *
     * @param script script to be evaluated
     */
    public void putScript(String script) {
        engine.putScript(script);
    }


    /**
     * Puts an object to the engine<br>
     * All public methods in object will be accessible via script "objectName.methodName()"<br>
     * To override default object put a new one with the same name
     *
     * @param name   of object
     * @param object instance
     */
    public void putObject(String name, Object object) {
        engine.putObject(name, object);
    }

    /**
     * Returns the specified object by name
     * @param name of object
     * @return script object
     */
    public Object getObject(String name) {
        return engine.getObjects().get(name);
    }

    /**
     * Returns a map of script objects where keys - are name of objects
     * @return map of script objects
     */
    public Map<String, Object> geObjects() {
        return engine.getObjects();
    }

    /**
     * Resets the script engine to default configuration<br>
     * Performs sequential calls for
     * <ul>
     * <li>stop the engine</li>
     * <li>reset script objects to default realizations (mouse, keyboard, system, clipboard, combined, thread, create)</li>
     * <li>remove all inserted scripts</li>
     * <li>reset time to wait interruption to 1000 ms</li>
     * </ul>
     */
    public void reset() {
        engine.reset();
    }

    /**
     * When stop method is called it sends an interruption request to threads and waits specified amount of time. After that time threads will be destroyed
     *
     * @param ms time to wait interruption in milliseconds
     */
    public void setTimeToWaitInterruption(int ms) {
        engine.setTimeToWaitInterruption(ms);
    }

    /**
     * When stop method is called it sends an interruption request to threads and waits specified amount of time. After that time threads will be destroyed
     *
     * @return time to wait interruption in milliseconds
     */
    public int getTimeToWaitInterruption() {
        return engine.getTimeToWaitInterruption();
    }

    /**
     * Returns an instance of the Robot object<br>
     * Use it for your own script objects
     *
     * @return robot object
     */
    public Robot getRobot() {
        return engine.getRobot();
    }

    /**
     * Returns an instance of the ClickAutoScriptEngine object<br>
     * Ii's needed for creation some specific objects like system object
     *
     * @return engine object
     */
    public ClickAutoScriptEngine getEngine() {
        return engine;
    }
}
