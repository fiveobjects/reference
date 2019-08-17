package org.openapex.samples.misc.swing;

import com.toedter.calendar.IDateEvaluator;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class CustomizedDateChooser57537818 {
    public static void main(String[] args) {
        JFrame f = new JFrame("ComboBox Example");

        JDateChooser date = new JDateChooser(new Date());
        date.getJCalendar().getDayChooser().addDateEvaluator(new MyDateEvaluator());
        date.setBounds(200,200,200,50);
        JPanel p = new JPanel();
        p.add(new JLabel("Choose a Date:"));
        p.add(date);
        f.add(p);
        f.setLayout(new FlowLayout());
        f.setSize(400, 500);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    private static class MyDateEvaluator implements IDateEvaluator {

        @Override
        public boolean isSpecial(Date date) {
            return false;
        }

        @Override
        public Color getSpecialForegroundColor() {
            return null;
        }

        @Override
        public Color getSpecialBackroundColor() {
            return null;
        }

        @Override
        public String getSpecialTooltip() {
            return null;
        }

        @Override
        public boolean isInvalid(Date date) {
            return date.getDay() == 0;

        }

        @Override
        public Color getInvalidForegroundColor() {
            return null;
        }

        @Override
        public Color getInvalidBackroundColor() {
            return null;
        }

        @Override
        public String getInvalidTooltip() {
            return null;
        }
    }

}
