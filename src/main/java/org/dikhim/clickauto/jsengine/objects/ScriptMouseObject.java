package org.dikhim.clickauto.jsengine.objects;


import org.dikhim.clickauto.jsengine.robot.Robot;
import org.dikhim.clickauto.jsengine.utils.MouseCodes;
import org.dikhim.clickauto.util.MathUtil;
import org.dikhim.clickauto.util.logger.Log;

import java.awt.*;

public class ScriptMouseObject implements MouseObject {

    // Constants
    private final int PRESS_DELAY = 10;
    private final int RELEASE_DELAY = 10;
    private final int MOVE_DELAY = 10;
    private final int WHEEL_DELAY = 10;
    private final float MULTIPLIER = 1;
    private final int MIN_DELAY = 5;

    private int pressDelay = PRESS_DELAY;
    private int releaseDelay = RELEASE_DELAY;
    private int moveDelay = MOVE_DELAY;
    private int wheelDelay = WHEEL_DELAY;
    private double multiplier = MULTIPLIER;
    private int minDelay = MIN_DELAY;


    private final Robot robot;

    public ScriptMouseObject(Robot robot) {
        this.robot = robot;
    }

    @Override
    public int getX() {
        synchronized (robot) {
            return MouseInfo.getPointerInfo().getLocation().x;
        }
    }

    @Override
    public int getY() {
        synchronized (robot) {
            return MouseInfo.getPointerInfo().getLocation().y;
        }
    }
    
    // basics
    @Override
    public void button(String button, String action) {
        synchronized (robot) {
            switch (action) {
                case "PRESS":
                    press(button);
                    break;
                case "RELEASE":
                    release(button);
                    break;
                case "CLICK":
                    click(button);
                    break;
                default:
                    Log.error("Undefined mouse actions '%s' in button method", action);
            }
        }
    }

    @Override
    public void buttonAt(String button, String action, int x, int y) {
        synchronized (robot) {
            moveTo(x, y);
            button(button, action);
        }
    }

    // movement
    @Override
    public void move(int dx, int dy) {
        synchronized (robot) {
            robot.mouseMove(getX() + dx, getY() + dy);
            delay(getMultipliedMoveDelay());
        }
    }

    @Override
    public void moveAndButton(String button, String action, int dx, int dy) {
        synchronized (robot) {
            move(dx, dy);
            button(button, action);
        }
    }

    @Override
    public void moveTo(int x, int y) {
        synchronized (robot) {
            if (x < 0 || y < 0) {
                Log.error("Negative coordinates '%s,%s' at moveTo method\n", x, y);
                return;
            }
            robot.mouseMove(x, y);
            delay(getMultipliedMoveDelay());
        }
    }

    @Override
    public void setX(int x) {
        synchronized (robot) {
            if (x < 0) {
                Log.error("Negative coordinate '%s' at setX method\n", x);
                return;
            }
            robot.mouseMove(x, getY());
            delay(getMultipliedMoveDelay());
        }
    }

    @Override
    public void setY(int y) {
        synchronized (robot) {
            if (y < 0) {
                Log.error("Negative coordinate '%s' at setY method\n", y);
                return;
            }
            robot.mouseMove(getX(), y);
            delay(getMultipliedMoveDelay());
        }
    }

    // click

    /**
     * Clicks mouse button
     *
     * @param buttons - name of the mouse button that should be clicked
     */
    @Override
    public void click(String buttons) {
        synchronized (robot) {
            String[] buttonList = buttons.split(" ");
            for (String btn : buttonList) {
                int buttonEventCode = MouseCodes.getEventCodeByName(btn);
                if (buttonEventCode == -1) {
                    Log.error("Undefined mouse button '%s' in click method\n", btn);
                    return;
                }
                robot.mousePress(buttonEventCode);
                delay(getMultipliedPressDelay());
                robot.mouseRelease(buttonEventCode);
                delay(getMultipliedReleaseDelay());
            }
        }
    }

    @Override
    public void clickAt(String button, int x, int y) {
        synchronized (robot) {
            moveTo(x, y);
            click(button);
        }
    }

    @Override
    public void moveAndClick(String button, int dx, int dy) {
        synchronized (robot) {
            move(dx, dy);
            click(button);
        }
    }

    // press

    /**
     * Presses mouse button
     *
     * @param button - name of the mouse button that should be pressed
     */
    @Override
    public void press(String button) {
        synchronized (robot) {
            int buttonEventCode = MouseCodes.getEventCodeByName(button);
            if (buttonEventCode == -1) {
                Log.error("Undefined mouse button '%s' in press method\n", button);
                return;
            }
            robot.mousePress(buttonEventCode);
            delay(getMultipliedPressDelay());
        }
    }

    @Override
    public void pressAt(String button, int x, int y) {
        synchronized (robot) {
            moveTo(x, y);
            press(button);
        }
    }

    @Override
    public void moveAndPress(String button, int dx, int dy) {
        synchronized (robot) {
            move(dx, dy);
            press(button);
        }
    }

    // release

    /**
     * Releases mouse button
     *
     * @param button - name of the button that should be released
     */
    @Override
    public void release(String button) {
        synchronized (robot) {
            int buttonEventCode = MouseCodes.getEventCodeByName(button);
            if (buttonEventCode == -1) {
                Log.error("Undefined mouse button '%s' in release method\n", button);
                return;
            }
            robot.mouseRelease(buttonEventCode);
            delay(getMultipliedReleaseDelay());
        }
    }

    @Override
    public void releaseAt(String button, int x, int y) {
        synchronized (robot) {
            moveTo(x, y);
            release(button);
        }
    }

    @Override
    public void moveAndRelease(String button, int dx, int dy) {
        synchronized (robot) {
            move(dx, dy);
            release(button);
        }
    }

    @Override
    public void moveAndWheel(String direction, int amount, int dx, int dy) {
        synchronized (robot) {
            move(dx, dy);
            wheel(direction, amount);
        }
    }

    // Getters\setters

    /**
     * @return the pressDelay
     */
    @Override
    public int getPressDelay() {
        synchronized (robot) {
            return pressDelay;
        }
    }

    /**
     * @param pressDelay the pressDelay to set
     */
    @Override
    public void setPressDelay(int pressDelay) {
        synchronized (robot) {
            if (pressDelay < 0) {
                this.pressDelay = 0;
            } else {
                this.pressDelay = pressDelay;
            }
        }
    }

    /**
     * @return the releaseDelay
     */
    @Override
    public int getReleaseDelay() {
        synchronized (robot) {
            return releaseDelay;
        }
    }

    /**
     * @param releaseDelay the releaseDelay to set
     */
    @Override
    public void setReleaseDelay(int releaseDelay) {
        synchronized (robot) {
            if (releaseDelay < 0) {
                this.releaseDelay = 0;
            } else {
                this.releaseDelay = releaseDelay;
            }
        }
    }


    /**
     * @return the moveDelay
     */
    @Override
    public int getMoveDelay() {
        synchronized (robot) {
            return moveDelay;
        }
    }

    /**
     * @param moveDelay the moveDelay to set
     */
    @Override
    public void setMoveDelay(int moveDelay) {
        synchronized (robot) {
            if (moveDelay < 0) {
                this.moveDelay = 0;
            } else {
                this.moveDelay = moveDelay;
            }
        }
    }

    @Override
    public int getWheelDelay() {
        synchronized (robot) {
            return wheelDelay;
        }
    }

    @Override
    public void setWheelDelay(int wheelDelay) {
        synchronized (robot) {
            if (wheelDelay < 0) {
                this.wheelDelay = 0;
            } else {
                this.wheelDelay = wheelDelay;
            }
        }
    }

    @Override
    public double getMultiplier() {
        synchronized (robot) {
            return multiplier;
        }
    }

    @Override
    public void setMultiplier(double multiplier) {
        synchronized (robot) {
            if (multiplier < 0) {
                this.multiplier = 0;
            } else {
                this.multiplier = multiplier;
            }
        }
    }

    @Override
    public void resetMultiplier() {
        synchronized (robot) {
            multiplier = MULTIPLIER;
        }
    }

    @Override
    public double getSpeed() {
        synchronized (robot) {
            if (multiplier == 0) return 999999999;
            return MathUtil.roundTo1(1.0 / multiplier);
        }
    }

    @Override
    public void setSpeed(double speed) {
        synchronized (robot) {
            if (speed < 0.1) {
                speed = 0.1;
            }
            speed = MathUtil.roundTo1(speed);
            setMultiplier(1f / speed);
        }
    }

    @Override
    public void resetSpeed() {
        synchronized (robot) {
            resetMultiplier();
        }
    }

    @Override
    public void setDelays(int delay) {
        synchronized (robot) {
            setPressDelay(delay);
            setReleaseDelay(delay);
            setMoveDelay(delay);
            setWheelDelay(delay);
        }
    }

    @Override
    public void resetDelays() {
        synchronized (robot) {
            this.moveDelay = MOVE_DELAY;
            this.pressDelay = PRESS_DELAY;
            this.releaseDelay = RELEASE_DELAY;
            this.wheelDelay = WHEEL_DELAY;
            this.minDelay = MIN_DELAY;
        }
    }

    @Override
    public int getMinDelay() {
        synchronized (robot) {
            return minDelay;
        }
    }

    @Override
    public void setMinDelay(int minDelay) {
        synchronized (robot) {
            this.minDelay = minDelay;
        }
    }
    
    /**
     * Rotates mouse wheel
     *
     * @param direction - 'UP' or 'DOWN'
     * @param amount    - any non negative number
     */
    @Override
    public void wheel(String direction, int amount) {
        synchronized (robot) {
            if (amount < 0) {
                Log.error("Wheel amount '%s' can't be less then 0\n", amount);
                return;
            }

            switch (direction) {
                case "DOWN":
                    robot.mouseWheel(amount);
                    robot.delay(getMultipliedWheelDelay());
                    break;
                case "UP":
                    robot.mouseWheel(amount * -1);
                    robot.delay(getMultipliedWheelDelay());
                    break;
                default:
                    Log.error("Wrong wheel direction '%s'\n", direction);
                    break;
            }
        }
    }
    
    @Override
    public void wheelAt(String direction, int amount, int x, int y) {
        synchronized (robot) {
            moveTo(x, y);
            wheel(direction, amount);
        }
    }

    @Override
    public int getMultipliedPressDelay() {
        synchronized (robot) {
            return checkDelay((int) (pressDelay * multiplier));
        }
    }

    @Override
    public int getMultipliedReleaseDelay() {
        synchronized (robot) {
            return checkDelay((int) (releaseDelay * multiplier));
        }
    }

    @Override
    public int getMultipliedMoveDelay() {
        synchronized (robot) {
            return checkDelay((int) (moveDelay * multiplier));
        }
    }

    @Override
    public int getMultipliedWheelDelay() {
        synchronized (robot) {
            return checkDelay((int) (wheelDelay * multiplier));
        }
    }
    
    // private
    private int checkDelay(int delay) {
        synchronized (robot) {
            if (delay < minDelay) return minDelay;
            return delay;
        }
    }

    private void delay(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
