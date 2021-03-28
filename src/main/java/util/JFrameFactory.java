package util;

import weka.gui.visualize.PrintablePanel;

import javax.swing.*;

public class JFrameFactory {

    public static JFrame build(PrintablePanel printablePanel){
        JFrame frame = new javax.swing.JFrame("Tree Visualizer");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(printablePanel);
        frame.setVisible(true);
        return frame;
    }
}
