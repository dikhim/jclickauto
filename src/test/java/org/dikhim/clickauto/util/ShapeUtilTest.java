package org.dikhim.clickauto.util;


import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class ShapeUtilTest {

    @Test
    public void createRectangleWithTwoPoints() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        Rectangle rectangle = ShapeUtil.createRectangle(p1, p2);
        assertEquals(0, rectangle.x);
        assertEquals(0, rectangle.y);
        assertEquals(1, rectangle.width);
        assertEquals(1, rectangle.height);

        rectangle = ShapeUtil.createRectangle(p2, p1);
        assertEquals(0, rectangle.x);
        assertEquals(0, rectangle.y);
        assertEquals(1, rectangle.width);
        assertEquals(1, rectangle.height);

        p1 = new Point(1, 0);
        p2 = new Point(0, 1);
        rectangle = ShapeUtil.createRectangle(p1, p2);
        assertEquals(0, rectangle.x);
        assertEquals(0, rectangle.y);
        assertEquals(1, rectangle.width);
        assertEquals(1, rectangle.height);

        rectangle = ShapeUtil.createRectangle(p2, p1);
        assertEquals(0, rectangle.x);
        assertEquals(0, rectangle.y);
        assertEquals(1, rectangle.width);
        assertEquals(1, rectangle.height);
    }

    @Test
    public void twoEqualPoints_RectangleSize1() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        Rectangle rectangle = ShapeUtil.createRectangleIncludesBorder(p1, p2);
        System.out.println(rectangle);
        assertEquals(0, rectangle.x);
        assertEquals(0, rectangle.y);
        assertEquals(1, rectangle.width);
        assertEquals(1, rectangle.height);
    }

    @Test
    public void pointMashUp_Rectangle() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        Rectangle rectangle = ShapeUtil.createRectangleIncludesBorder(p1, p2);
        assertEquals(0, rectangle.x);
        assertEquals(0, rectangle.y);
        assertEquals(2, rectangle.width);
        assertEquals(2, rectangle.height);

        rectangle = ShapeUtil.createRectangleIncludesBorder(p2, p1);
        assertEquals(0, rectangle.x);
        assertEquals(0, rectangle.y);
        assertEquals(2, rectangle.width);
        assertEquals(2, rectangle.height);

        p1 = new Point(1, 0);
        p2 = new Point(0, 1);
        rectangle = ShapeUtil.createRectangleIncludesBorder(p1, p2);
        assertEquals(0, rectangle.x);
        assertEquals(0, rectangle.y);
        assertEquals(2, rectangle.width);
        assertEquals(2, rectangle.height);

        rectangle = ShapeUtil.createRectangleIncludesBorder(p2, p1);
        assertEquals(0, rectangle.x);
        assertEquals(0, rectangle.y);
        assertEquals(2, rectangle.width);
        assertEquals(2, rectangle.height);
    }

    @Test
    public void createFittedRectangle() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(100, 100);
        
        Rectangle parent = ShapeUtil.createRectangle(p1, p2);
        Rectangle child = new Rectangle(-1, -1, 100, 100);
        Rectangle fittedRect = ShapeUtil.createMinimalRectangleFitIntoParent(parent, child);
        assertEquals(0, fittedRect.x);
        assertEquals(0, fittedRect.y);
        assertEquals(99, fittedRect.width);
        assertEquals(99, fittedRect.height);

        child = new Rectangle(1, 1, 100, 100);
        fittedRect = ShapeUtil.createMinimalRectangleFitIntoParent(parent, child);
        assertEquals(1, fittedRect.x);
        assertEquals(1, fittedRect.y);
        assertEquals(99, fittedRect.width);
        assertEquals(99, fittedRect.height);
        
        child = new Rectangle(100, 100, 100, 100);
        fittedRect = ShapeUtil.createMinimalRectangleFitIntoParent(parent, child);
        assertEquals(99, fittedRect.x);
        assertEquals(99, fittedRect.y);
        assertEquals(1, fittedRect.width);
        assertEquals(1, fittedRect.height);
        
        
        child = new Rectangle(-100, -100, 100, 100);
        fittedRect = ShapeUtil.createMinimalRectangleFitIntoParent(parent, child);
        assertEquals(0, fittedRect.x);
        assertEquals(0, fittedRect.y);
        assertEquals(1, fittedRect.width);
        assertEquals(1, fittedRect.height);


        child = new Rectangle(-200, 20, 100, 100);
        fittedRect = ShapeUtil.createMinimalRectangleFitIntoParent(parent, child);
        assertEquals(0, fittedRect.x);
        assertEquals(20, fittedRect.y);
        assertEquals(1, fittedRect.width);
        assertEquals(80, fittedRect.height);
    }


}
