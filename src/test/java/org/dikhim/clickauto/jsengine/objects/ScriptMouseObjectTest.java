package org.dikhim.clickauto.jsengine.objects;

import org.dikhim.clickauto.ClickAuto;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class ScriptMouseObjectTest {

    @Test
    public void moveToAnimated() throws AWTException {
        ClickAuto clickAuto = new ClickAuto();
        MouseObject mouse = (MouseObject) clickAuto.objectContainer().get("mouse");
        mouse.moveTo(0, 0);
        mouse.animated().moveTo(1000, 500, 500);
        assertEquals(1000, mouse.getX());
        assertEquals(500, mouse.getY());

        mouse.moveTo(0, 0);
        mouse.animated().moveTo(1000, 500, 1000);
        assertEquals(1000, mouse.getX());
        assertEquals(500, mouse.getY());
        
        mouse.moveTo(0, 0);
        mouse.animated().moveTo(1000, 500, 2000);
        assertEquals(1000, mouse.getX());
        assertEquals(500, mouse.getY());

        clickAuto.waitEvaluationComplete();
    }

    @Test
    public void moveAnimated() throws AWTException {
        ClickAuto clickAuto = new ClickAuto();
        MouseObject mouse = (MouseObject) clickAuto.objectContainer().get("mouse");
        mouse.moveTo(0, 0);
        mouse.animated().move(200, 100, 500);
        assertEquals(200, mouse.getX());
        assertEquals(100, mouse.getY());

        mouse.moveTo(0, 0);
        mouse.animated().move(200, 100, 1000);
        assertEquals(200, mouse.getX());
        assertEquals(100, mouse.getY());

        mouse.moveTo(0, 0);
        mouse.animated().move(200, 100, 2000);
        assertEquals(200, mouse.getX());
        assertEquals(100, mouse.getY());

        clickAuto.waitEvaluationComplete();
    }
    
    @Test
    public void testAnimationMethods() throws AWTException {
        ClickAuto clickAuto = new ClickAuto();
        MouseObject mouse = (MouseObject) clickAuto.objectContainer().get("mouse");
        mouse.animated().setLinearMethod();
        mouse.moveTo(0, 0);
        mouse.animated().moveTo(1000, 500, 2000);

        mouse.animated().setExponentialMethod();
        mouse.moveTo(0, 0);
        mouse.animated().moveTo(1000, 500, 2000);

        mouse.animated().setAcceleratingMethod();
        mouse.moveTo(0, 0);
        mouse.animated().moveTo(1000, 500, 2000);

        mouse.animated().setDeceleratingMethod();
        mouse.moveTo(0, 0);
        mouse.animated().moveTo(1000, 500, 2000);
    }
}