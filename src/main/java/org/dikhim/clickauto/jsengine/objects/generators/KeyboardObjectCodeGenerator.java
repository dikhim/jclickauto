package org.dikhim.clickauto.jsengine.objects.generators;


import org.dikhim.clickauto.jsengine.objects.KeyboardObject;

public class KeyboardObjectCodeGenerator extends SimpleCodeGenerator implements KeyboardObject {


    public KeyboardObjectCodeGenerator(int lineSize) {
        super("key", lineSize, KeyboardObject.class);
    }

    public KeyboardObjectCodeGenerator() {
        super("key", KeyboardObject.class);
    }

    @Override
    public int getMinDelay() {
        buildStringForCurrentMethod();
        return 0;
    }

    @Override
    public int getMultipliedPressDelay() {
        buildStringForCurrentMethod();
        return 0;
    }

    @Override
    public int getMultipliedReleaseDelay() {
        buildStringForCurrentMethod();
        return 0;
    }

    @Override
    public double getMultiplier() {
        buildStringForCurrentMethod();
        return 0;
    }

    @Override
    public int getPressDelay() {
        buildStringForCurrentMethod();
        return 0;
    }

    @Override
    public int getReleaseDelay() {
        buildStringForCurrentMethod();
        return 0;
    }

    @Override
    public double getSpeed() {
        buildStringForCurrentMethod();
        return 0;
    }

    @Override
    public void perform(String keys, String action) {
        buildStringForCurrentMethod(keys, action);
    }

    @Override
    public void press(String keys) {
        buildStringForCurrentMethod(keys);
    }

    @Override
    public void release(String keys) {
        buildStringForCurrentMethod(keys);
    }

    @Override
    public void resetDelays() {
        buildStringForCurrentMethod();
    }

    @Override
    public void resetMultiplier() {
        buildStringForCurrentMethod();
    }

    @Override
    public void resetSpeed() {
        buildStringForCurrentMethod();
    }

    @Override
    public void setDelays(int delay) {
        buildStringForCurrentMethod(delay);
    }

    @Override
    public void setMinDelay(int delay) {
        buildStringForCurrentMethod(delay);
    }

    @Override
    public void setMultiplier(double multiplier) {
        buildStringForCurrentMethod(multiplier);
    }

    @Override
    public void setPressDelay(int pressDelay) {
        buildStringForCurrentMethod(pressDelay);
    }

    @Override
    public void setReleaseDelay(int releaseDelay) {
        buildStringForCurrentMethod(releaseDelay);
    }

    @Override
    public void setSpeed(double multiplier) {
        buildStringForCurrentMethod(multiplier);
    }

    @Override
    public void type(String keys) {
        buildStringForCurrentMethod(keys);
    }

    @Override
    public void typeText(String layout, String text) {
        buildStringForCurrentMethod(layout, text);
    }
}
