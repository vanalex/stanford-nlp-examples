package util;

import weka.core.Drawable;
import weka.gui.treevisualizer.PlaceNode2;

import javax.swing.*;

public class TreePrinter {

    public static void visualize(Drawable tree) throws Exception {
        weka.gui.treevisualizer.TreeVisualizer tv = new weka.gui.treevisualizer.TreeVisualizer(null, tree.graph(), new
                PlaceNode2());
        JFrameFactory.build(tv);
        tv.fitToScreen();
    }
}
