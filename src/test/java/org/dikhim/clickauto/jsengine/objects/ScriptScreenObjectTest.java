package org.dikhim.clickauto.jsengine.objects;

import org.dikhim.clickauto.ClickAuto;
import org.dikhim.clickauto.jsengine.objects.Classes.Image;
import org.dikhim.clickauto.jsengine.robot.Robot;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class ScriptScreenObjectTest {

    @Test
    public void getImage_givenTwoPoints() throws AWTException {
        ClickAuto clickAuto = new ClickAuto();
        Robot robot = clickAuto.robot();
        ScriptScreenObject screenObject = new ScriptScreenObject(robot);

        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        Image image = screenObject.getImage(p1, p2);
        assertEquals(1,image.getWidth());
        assertEquals(1,image.getHeight());      
    }
    
    
    @Test
    public void getImage_givenNegativePoint_expectCropped() throws AWTException {
        ClickAuto clickAuto = new ClickAuto();
        Robot robot = clickAuto.robot();
        ScriptScreenObject screenObject = new ScriptScreenObject(robot);

        Point p1 = new Point(-1, -1);
        Point p2 = new Point(1, 1);
        Image image = screenObject.getImage(p1, p2);
        assertEquals(1,image.getWidth());
        assertEquals(1,image.getHeight());      
    }
    
    
    
    @Test
    public void getImageFilled_givenNegativePoint_expectFilledImage() throws AWTException {
        ClickAuto clickAuto = new ClickAuto();
        Robot robot = clickAuto.robot();
        ScriptScreenObject screenObject = new ScriptScreenObject(robot);

        Point p1 = new Point(-1, -1);
        Point p2 = new Point(1, 1);
        Image image = screenObject.getFilledImage(p1, p2);
        assertEquals(2,image.getWidth());
        assertEquals(2,image.getHeight());      
    }
}