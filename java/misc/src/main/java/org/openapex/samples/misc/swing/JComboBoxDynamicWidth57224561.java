package org.openapex.samples.misc.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.util.Arrays;

public class JComboBoxDynamicWidth57224561 {
    private JFrame f;

    public JComboBoxDynamicWidth57224561() {
        f = new JFrame("ComboBox Example");
        String country[] = {"Long Item                       5", "Long Item 2", "Long Item                                           1", "Long Item 8", "Long Item 4"};
        String longest = Arrays.stream(country).max((e1, e2) -> e1.length() - e2.length()).get();
        System.out.println(longest);
        MyDropdown cb = new MyDropdown(country);
        int width = findTextWidth(longest);
        //cb.setBounds(50, 50, 90, 20);
        cb.setBounds(50, 50, findTextWidth(longest), 20);
        f.add(cb);
        //f.setLayout(null);
        f.setLayout(new BorderLayout());
        f.setSize(400, 500);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //f.pack();
        System.out.println(f.getGraphics());
        f.setVisible(true);
    }

    public static int findTextWidth(String text) {
        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
        Font font = new Font("Lucida Grande", Font.PLAIN, 13);
        return (int) (font.getStringBounds(text, frc).getWidth());
    }

    public static void main(String[] args) {
        new JComboBoxDynamicWidth57224561();
    }

    private static class MyDropdown extends JComboBox {
        private boolean layoutInProgress = false;

        public MyDropdown(Object[] items) {
            super(items);
        }

        public void doLayout() {
            layoutInProgress = true;
            try {
                super.doLayout();
            } finally {
                layoutInProgress = false;
            }
        }

        public Dimension getSize() {
            Dimension dimension = getSize();
            if (!layoutInProgress) {
                dimension.width = Math.max(dimension.width, super.getPreferredSize().width);
            }
            return dimension;
        }
    }
}
