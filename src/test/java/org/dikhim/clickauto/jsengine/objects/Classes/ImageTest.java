package org.dikhim.clickauto.jsengine.objects.Classes;

import org.junit.BeforeClass;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ImageTest {
    private static Image parent;
    private static Image waldo;
    private static Image greenDot;

    @BeforeClass
    public static void init() throws Exception {
        parent = new Image(ImageIO.read(new File(ImageTest.class.getResource("/images/parent.png").toURI())));
        waldo = new Image(ImageIO.read(new File(ImageTest.class.getResource("/images/waldo.png").toURI())));
        greenDot = new Image(ImageIO.read(new File(ImageTest.class.getResource("/images/greenDot.png").toURI())));
    }

    @org.junit.Test
    public void compile() {
        long timeStamp;
        long time1;
        long time2;
        timeStamp = System.currentTimeMillis();
        parent.findFirst(waldo);
        time1 = System.currentTimeMillis() - timeStamp;

        parent.compile();
        assertTrue(parent.isCompiled());
        waldo.compile();
        assertTrue(waldo.isCompiled());

        timeStamp = System.currentTimeMillis();
        parent.findFirst(waldo);
        time2 = System.currentTimeMillis() - timeStamp;
        
        assertTrue(time2 < time1);
    }

    @org.junit.Test
    public void isCompiled() {
        parent.compile();
        assertTrue(parent.isCompiled());
    }

    @org.junit.Test
    public void findAll() {
        List<Point> list = parent.findAll(waldo);
        assertEquals(2, list.size());
        assertEquals(783, list.get(0).x);
        assertEquals(151, list.get(0).y);
        assertEquals(1261, list.get(1).x);
        assertEquals(78, list.get(1).y);
    }

    @org.junit.Test
    public void findAllCenter() {
        List<Point> list = parent.findAllCenter(waldo);
        assertEquals(2, list.size());
        assertEquals(801, list.get(0).x);
        assertEquals(169, list.get(0).y);
        assertEquals(1279, list.get(1).x);
        assertEquals(96, list.get(1).y);
    }

    @org.junit.Test
    public void findFirst() {
        Point point = parent.findFirst(waldo);
        assertEquals(783, point.x);
        assertEquals(151, point.y);
    }

    @org.junit.Test
    public void findFirstCenter() {
        Point point = parent.findFirstCenter(waldo);
        assertEquals(801, point.x);
        assertEquals(169, point.y);
    }

    @org.junit.Test
    public void findLimit() {
        List<Point> list = parent.findLimit(waldo, 2);
        assertEquals(783, list.get(0).x);
        assertEquals(151, list.get(0).y);
        assertEquals(1261, list.get(1).x);
        assertEquals(78, list.get(1).y);

        list = parent.findLimit(waldo, 1);
        assertEquals(783, list.get(0).x);
        assertEquals(151, list.get(0).y);
    }

    @org.junit.Test
    public void findLimitCenter() {
        List<Point> list = parent.findLimitCenter(waldo, 2);
        assertEquals(801, list.get(0).x);
        assertEquals(169, list.get(0).y);
        assertEquals(1279, list.get(1).x);
        assertEquals(96, list.get(1).y);
    }

    @org.junit.Test
    public void matchBestWholeImage() {
        Point point = parent.matchBest(waldo);
        assertEquals(783, point.x);
        assertEquals(151, point.y);
    }

    @org.junit.Test
    public void matchBestInArea() {
        Point point = parent.matchBest(waldo, new Rectangle(1220, 50, 100, 100));
        assertEquals(1261, point.x);
        assertEquals(78, point.y);
    }

    @org.junit.Test
    public void matchThresholdLimit() {
        List<Point> points = parent.matchThresholdLimit(greenDot, 0.01, 3);
        assertEquals(3, points.size());
        assertEquals(1058, points.get(0).x);
        assertEquals(913, points.get(0).y);
    }

    //[java.awt.Point[x=1058,y=913], java.awt.Point[x=1045,y=946], java.awt.Point[x=929,y=916]]
    @org.junit.Test
    public void matchQuickThresholdLimit() {
        List<Point> points = parent.matchQuickThresholdLimit(greenDot, 0.01, 3);
        assertEquals(3, points.size());
        assertEquals(1058, points.get(0).x);
        assertEquals(913, points.get(0).y);
    }

    @org.junit.Test
    public void matchQuickThresholdLimitWithFactor() {
        List<Point> points = parent.matchQuickThresholdLimit(greenDot, 0.01, 3, 2);
        assertEquals(3, points.size());
        assertEquals(1058, points.get(0).x);
        assertEquals(913, points.get(0).y);
    }
}
