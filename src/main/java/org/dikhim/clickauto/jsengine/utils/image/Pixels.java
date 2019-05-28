package org.dikhim.clickauto.jsengine.utils.image;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Pixels {
    private Map<Integer, ColorInfo> pixelMap = new HashMap<>();

    private List<ColorInfo> sortedList = new ArrayList<>();
    

    public void add(int rgb, Point point) {
        ColorInfo colorInfoOpt1 = pixelMap.get(rgb);
        if (colorInfoOpt1 == null) {
            pixelMap.put(rgb,new ColorInfo(rgb, point));
        }else {
            colorInfoOpt1.addPoint(point);
        }
    }

    public List<Point> getForColor(int rgb) {
        return pixelMap.get(rgb).getColorBlocks();
    }

    public List<ColorInfo> getPixels() {
        return pixelMap.values().stream().collect(Collectors.toList());
    }
}
