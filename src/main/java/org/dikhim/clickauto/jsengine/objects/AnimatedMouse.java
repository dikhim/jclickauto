package org.dikhim.clickauto.jsengine.objects;

import org.dikhim.clickauto.jsengine.robot.Robot;

public class AnimatedMouse {
    private final ScriptMouseObject mouse;
    private final Robot robot;
    private AnimationMethod method = new LinearMethod();


    public AnimatedMouse(ScriptMouseObject mouseObject, Robot robot) {
        this.mouse = mouseObject;
        this.robot = robot;
    }

    public void moveAnimated(int dx, int dy, int delay) {
        synchronized (robot) {
            long startTime = System.currentTimeMillis();
            double animationTime = mouse.getMultiplier() * delay;
            int currentDx = 0;
            int currentDy = 0;

            double currentTime = System.currentTimeMillis();
            animationTime += currentTime;
            while (currentTime + mouse.getMultipliedMoveDelay() * 2 < animationTime) {
                double position = method.transform((delay - (animationTime - currentTime)) / delay);


                int diffDx = (int) (position * dx - currentDx);
                int diffDy = (int) (position * dy - currentDy);
                mouse.move(diffDx, diffDy);
                currentDx += diffDx;
                currentDy += diffDy;
                currentTime = System.currentTimeMillis();
            }
            mouse.move(dx - currentDx, dy - currentDy);
            mouse.delay((int) (delay - (System.currentTimeMillis() - startTime)));
        }
    }


    public void moveToAnimated(int x, int y, int delay) {
        synchronized (robot) {
            long startTime = System.currentTimeMillis();
            double animationTime = mouse.getMultiplier() * delay;
            int initX = mouse.getX();
            int initY = mouse.getY();
            int dx = x - initX;
            int dy = y - initY;

            double currentTime = System.currentTimeMillis();
            animationTime += currentTime;
            while (currentTime + mouse.getMultipliedMoveDelay() * 2 < animationTime) {
                double position = method.transform((delay - (animationTime - currentTime)) / delay);
                mouse.moveTo((int) (initX + dx * position), (int) (initY + dy * position));
                currentTime = System.currentTimeMillis();
            }
            mouse.moveTo(x, y);
            mouse.delay((int) (delay - (System.currentTimeMillis() - startTime)));
        }
    }

    public void setLinearMethod() {
        method = new LinearMethod();
    }

    public void setExponentialMethod() {
        method = new ExponentialMethod();
    }

    public void setAcceleratingMethod() {
        method = new AcceleratingMethod();
    }
    
    public void setDeceleratingMethod() {
        method = new DeceleratingMethod();
    }
}
