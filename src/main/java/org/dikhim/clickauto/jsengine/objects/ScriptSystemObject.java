package org.dikhim.clickauto.jsengine.objects;

import javafx.application.Platform;
import org.dikhim.clickauto.jsengine.ClickAutoScriptEngine;
import org.dikhim.clickauto.jsengine.objects.Classes.Image;
import org.dikhim.clickauto.util.MathUtil;
import org.dikhim.clickauto.util.Out;
import org.dikhim.clickauto.jsengine.robot.Robot;

@SuppressWarnings("unused")
public class ScriptSystemObject implements SystemObject {
    private ClickAutoScriptEngine engine;
    private Robot robot;
    private final Object monitor;

    private final double MULTIPLIER = 1;

    private double multiplier = MULTIPLIER;

    public ScriptSystemObject(ClickAutoScriptEngine engine) {
        this.engine = engine;
        this.robot = engine.getRobot();
        this.monitor = robot.getMonitor();
    }

    public ScriptSystemObject(Robot robot) {
        this.robot = robot;
        this.monitor = robot.getMonitor();
    }

    @Override
    public void exit() {
        Platform.exit();
    }

    @Override
    public int getMultipliedDelay(int ms) {
        synchronized (monitor) {
            int result = ((int) (ms * multiplier));
            if (result <= 0) {
                return 0;
            } else {
                return result;
            }
        }
    }

    @Override
    public double getMultiplier() {
        synchronized (monitor) {
            return multiplier;
        }
    }

    @Override
    public double getSpeed() {
        synchronized (monitor) {
            if(multiplier==0) return 999999999;
            return MathUtil.roundTo1(1.0 / multiplier);
        }
    }



    @Override
    public void print(String s) {
        synchronized (monitor) {
            Out.print(s);
        }
    }

    @Override
    public void println() {
        synchronized (monitor) {
            Out.println("");
        }
    }

    @Override
    public void println(String s) {
        synchronized (monitor) {
            Out.println(s);
        }
    }

    @Override
    public void setMaxThreads(String name, int maxThreads) {
        engine.registerInvocableMethod(name, maxThreads);
    }

    @Override
    public void resetMultiplier() {
        synchronized (monitor) {
            this.multiplier = MULTIPLIER;
        }
    }

    @Override
    public void resetSpeed() {
        synchronized (monitor) {
            this.multiplier = MULTIPLIER;
        }
    }

    @Override
    public void setMultiplier(double multiplier) {
        synchronized (monitor) {
            if (multiplier < 0) {
                this.multiplier = 0;
            } else {
                this.multiplier = multiplier;
            }
        }
    }

    @Override
    public void sleep(int ms) {
        if (ms <= 0) return;
        try {
            Thread.sleep(getMultipliedDelay(ms));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void sleepNonMultiplied(int ms) {
        if (ms <= 0) return;
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void setSpeed(double speed) {
        synchronized (monitor) {
            if (speed < 0.1) {
                speed = 0.1;
            }
            speed = MathUtil.roundTo1(speed);
            setMultiplier(1f / speed);
        }
    }

    @Override
    public void showImage(Image image) {
        synchronized (monitor) {
            // TODO
        }
    }
}
