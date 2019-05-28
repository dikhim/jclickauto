package org.dikhim.clickauto.jsengine.utils.image;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pixels {
    private List<ColorInfo> pixels = new ArrayList<>();

    public void add(int rgb, Point point) {
        Optional<ColorInfo> colorInfoOpt = pixels.stream()
                .filter(colorInfo -> colorInfo.getRgb() == rgb)
                .findFirst();
        if (colorInfoOpt.isPresent()) {
            colorInfoOpt.get().addPoint(point);
        } else {
            pixels.add(new ColorInfo(rgb, point));
        }
    }

    public List<Point> getForColor(int rgb) {
        return pixels.stream()
                .filter(colorInfo -> colorInfo.getRgb() == rgb)
                .findFirst()
                .map(ColorInfo::getColorBlocks)
                .orElse(null);
    }

    public List<ColorInfo> getPixels() {
        return pixels;
    }
}
