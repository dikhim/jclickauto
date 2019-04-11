package org.dikhim.clickauto.jsengine.objects.generators;


import org.dikhim.clickauto.jsengine.objects.Classes.Image;
import org.dikhim.clickauto.jsengine.objects.SystemObject;

public class SystemObjectCodeGenerator extends SimpleCodeGenerator implements SystemObject {

    public SystemObjectCodeGenerator(int lineSize) {
        super("system", lineSize, SystemObject.class);
    }

    public SystemObjectCodeGenerator() {
        super("system", SystemObject.class);
    }
    
    @Override
    public void exit() {
        buildStringForCurrentMethod();
    }

    @Override
    public int getMultipliedDelay(int delay) {
        buildStringForCurrentMethod(delay);
        return 0;
    }

    @Override
    public double getMultiplier() {
        buildStringForCurrentMethod();
        return 0;
    }

    @Override
    public double getSpeed() {
        buildStringForCurrentMethod();
        return 0;
    }

    @Override
    public void print(String s) {
        buildStringForCurrentMethod(s);
    }

    @Override
    public void println() {
        buildStringForCurrentMethod();
    }

    @Override
    public void println(String s) {
        buildStringForCurrentMethod(s);
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
    public void setMaxThreads(String name, int maxThreads) {
        buildStringForCurrentMethod(name, maxThreads);
    }

    @Override
    public void setMultiplier(double multiplier) {
        buildStringForCurrentMethod(multiplier);
    }

    @Override
    public void setSpeed(double multiplier) {
        buildStringForCurrentMethod(multiplier);
    }

    @Override
    public void showImage(Image image) {
        buildStringForCurrentMethod();
    }

    @Override
    public void sleep(int ms) {
        buildStringForCurrentMethod(ms);
    }

    @Override
    public void sleepNonMultiplied(int ms) {
        buildStringForCurrentMethod(ms);
    }
}
