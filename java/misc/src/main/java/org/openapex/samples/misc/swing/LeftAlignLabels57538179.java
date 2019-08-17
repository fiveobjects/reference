package org.openapex.samples.misc.swing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class LeftAlignLabels57538179 {
    public static void main(String[] args) {
        JPanel p0=new JPanel();
        p0.setLayout(new BoxLayout(p0,BoxLayout.Y_AXIS));
        p0.setBorder(new EmptyBorder(10,10,10,10));
        p0.setAlignmentX(0);

        JPanel p0a=new JPanel();
        p0a.setLayout(new BoxLayout(p0a,BoxLayout.X_AXIS));
        JLabel l=new JLabel("Label 1");
        p0a.add(l);
        p0a.setAlignmentX(0);
        l.setAlignmentX(0);
        l.setHorizontalAlignment(0);

        //p0.add(p0a);
        addAndLeftAlign(p0, p0a);

        JPanel p0b=new JPanel();
        p0b.setLayout(new BoxLayout(p0b,BoxLayout.Y_AXIS));
        p0b.add(new JLabel("Label 1"));
        //p0.add(p0b);
        //p0b.setAlignmentX(Component.LEFT_ALIGNMENT);
        addAndLeftAlign(p0, p0b);

        JPanel p0c=new JPanel();
        p0c.setLayout(new BoxLayout(p0c,BoxLayout.Y_AXIS));
        p0c.add(new JLabel("Label 1"));
        //p0.add(p0c);
        addAndLeftAlign(p0, p0c);

        //"create labels"


        JPanel p1=new JPanel();
        p1.setLayout(new BoxLayout(p1,BoxLayout.X_AXIS));
        p1.add(new JLabel("Label 4a"));
        p1.add(new JLabel("Label 4b"));
        p1.add(new JLabel("Label 4c"));
        p1.add(new JLabel("Label 4d"));
        p1.setAlignmentX(Component.LEFT_ALIGNMENT);
        //p0.add(p1);
        addAndLeftAlign(p0, p1);

        addAndLeftAlign(p0, new JLabel("Label 5"));
        addAndLeftAlign(p0, new JLabel("Label 6"));
        addAndLeftAlign(p0, new JLabel("Label 7"));

        JDialog jd=new JDialog();
        jd.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent _e){jd.setVisible(false);}});
        jd.setLayout(new BoxLayout(jd.getContentPane(),BoxLayout.Y_AXIS));
        Container c=jd.getContentPane();
        jd.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
        c.add(p0);
        jd.pack();
        jd.setVisible(true);
    }

    private static void addAndLeftAlign(JComponent parent, JComponent child) {
        //child.setAlignmentX(Component.LEFT_ALIGNMENT);
        parent.add(child);
    }
}
