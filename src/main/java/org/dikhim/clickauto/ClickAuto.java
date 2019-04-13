package org.dikhim.clickauto;

import org.dikhim.clickauto.jsengine.ClickAutoScriptEngine;
import org.dikhim.clickauto.jsengine.robot.RobotStatic;

public class ClickAuto {
    private ClickAutoScriptEngine clickAutoScriptEngine = new ClickAutoScriptEngine(RobotStatic.get());

    /**
     * Starts script engine. Any scripts that was put will be evaluated in new thread
     */
    public void start() {
        clickAutoScriptEngine.start();
    }

    /**
     * Stops script engine. Sends interrupt request to all threads that life in engine.<br>
     * Status of thread may be checked by thread.interrupted() method<br>
     * The interrupt request should be proceed by script to do all necessary operations to complete the script.<br>
     * If after interrupt request thread is still alive, than it will be destroyed<br>
     * Destroying thread may cause crash for the script engine. Especially when it called right after the start() method. Better wait at least 500ms after start() method to call stop()
     */
    public void stop() {
        clickAutoScriptEngine.stop();
    }


    /**
     * Put script into script engine. Script will be evaluated after start() method call
     * @param script script to be evaluated
     */
    public void put(String script) {
        clickAutoScriptEngine.putScript(script);
    }

    /**
     * Resets the script engine to default configuration<br>
     * Performs sequential calls for
     * <ul>
     *     <li>stop the engine</li>
     *     <li>reset script objects to default realizations (mouse, keyboard, system, clipboard, combined, thread, create)</li>
     *     <li>remove all inserted scripts</li>
     *     <li>reset time to wait interruption to 1000 ms</li>
     * </ul> 
     */
    public void reset() {
        clickAutoScriptEngine.reset();
    }

    /**
     * When stop method is called it sends an interruption request to threads and waits specified amount of time. After that time threads will be destroyed
     *
     * @param ms time to wait interruption in milliseconds
     */
    public void setTimeToWaitInterruption(int ms) {
        clickAutoScriptEngine.setTimeToWaitInterruption(ms);
    }

    /**
     * When stop method is called it sends an interruption request to threads and waits specified amount of time. After that time threads will be destroyed
     *
     * @return time to wait interruption in milliseconds
     */
    public int getTimeToWaitInterruption() {
        return clickAutoScriptEngine.getTimeToWaitInterruption();
    }

}
