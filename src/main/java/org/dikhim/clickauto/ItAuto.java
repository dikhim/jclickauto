package org.dikhim.clickauto;

import org.dikhim.clickauto.jsengine.NewJsEngine;
import org.dikhim.clickauto.jsengine.robot.RobotStatic;

public class ItAuto {
    private NewJsEngine newJsEngine = new NewJsEngine(RobotStatic.get());

    public void start() {
        newJsEngine.start();
    }

    public void stop() {
        newJsEngine.stop();
    }
    
    public void put(String script) {
        newJsEngine.putScript(script);
    }
    
    public void reset() {
        newJsEngine.reset();
    }
    
}
