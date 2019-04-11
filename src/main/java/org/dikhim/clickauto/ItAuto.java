package org.dikhim.clickauto;

import org.dikhim.clickauto.jsengine.JSEngine;
import org.dikhim.clickauto.jsengine.robot.RobotStatic;

public class ItAuto {
    private JSEngine jsEngine = new JSEngine(RobotStatic.get());

    public void run(String code) {
        jsEngine.putCode(code);
        jsEngine.start();
    }
}
