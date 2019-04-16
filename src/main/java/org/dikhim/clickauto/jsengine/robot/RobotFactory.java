package org.dikhim.clickauto.jsengine.robot;


import org.dikhim.clickauto.util.logger.Log;

import java.awt.*;

public class RobotFactory {
    private static Robot robot;
    private static boolean emptyInstance = false;


    public static Robot get() throws AWTException {
        if(robot!=null) return robot;

        Robot robotTemp;
        try {
            java.awt.Robot awtRobot = new java.awt.Robot();
            robotTemp = new DefaultRobot(awtRobot);
        } catch (AWTException e) {
            Log.error("Cannot create 'Robot' object. Cause:" + e.getMessage());
            Log.error("Keyboard and mouse control will be unavailable");
            if (emptyInstance) {
                robotTemp = new EmptyRobot();
            } else {
                throw e;
            }
        }
        robot = robotTemp;
        return robot;
    }

    public static void createEmptyInstanceOnFail(boolean isEmpty) {
        emptyInstance = isEmpty;
    }

}
