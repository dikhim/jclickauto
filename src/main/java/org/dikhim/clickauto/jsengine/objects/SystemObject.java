package org.dikhim.clickauto.jsengine.objects;


import org.dikhim.clickauto.jsengine.objects.Classes.Image;

@SuppressWarnings("unused")
public interface SystemObject {
    void exit();
    
    int getMultipliedDelay(int delay);

    double getMultiplier();

    double getSpeed();
    
    void print(String s);

    void println();
    
    void println(String s);

    void setMaxThreads(String name, int maxThreads);
    
    void resetMultiplier();

    void resetSpeed();

    void setMultiplier(double multiplier);

    void setSpeed(double multiplier);

    void showImage(Image image);

    void sleep(int ms);

    void sleepNonMultiplied(int ms);
}
