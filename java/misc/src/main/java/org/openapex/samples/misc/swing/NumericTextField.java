package org.openapex.samples.misc.swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 * NumericTextField allows only numbers in the text field and not even decimal
 * points. Also, it restricts the length of input.
 * 
 * @version 1.0
 * @since Apex 1.2
 */
public class NumericTextField {

    /**
     *
     */
    public void createUI() {
        final JFrame frame = new JFrame("NumericTextField");
        frame.setSize(400, 400);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter some input (only numbers are allowed of max length 10):");
        final JTextField textField = new JTextField(30);
        // Add the document filter to text field for numeric and length check.
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new NumericAndLengthFilter(10));
        panel.add(label);
        panel.add(textField);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Entry point of the application.
     * 
     * @param args Input arguments.
     */
    public static void main(String[] args) {
        final NumericTextField test = new NumericTextField();
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                test.createUI();
            }
        });
    }

    /**
     * A document filter for numeric and length check.
     */
    private class NumericAndLengthFilter extends DocumentFilter {

        /**
         * Number of characters allowed.
         */
        private int length = 0;

        /**
         * Restricts the number of charcacters can be entered by given length.
         * 
         * @param length Number of characters allowed.
         */
        public NumericAndLengthFilter(int length) {
            this.length = length;
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                throws BadLocationException {
            if (isNumeric(string)) {
                if (this.length > 0 && fb.getDocument().getLength() + string.length() > this.length) {
                    return;
                }
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            if (isNumeric(text)) {
                if (this.length > 0 && fb.getDocument().getLength() + text.length() > this.length) {
                    return;
                }
                super.insertString(fb, offset, text, attrs);
            }
        }

        /**
         * This method tests whether given text can be represented as number. This
         * method can be enhanced further for specific needs.
         * 
         * @param text Input text.
         * @return {@code true} if given string can be converted to number; otherwise
         *         returns {@code false}.
         */
        private boolean isNumeric(String text) {
            if (text == null || text.trim().equals("")) {
                return false;
            }
            for (int iCount = 0; iCount < text.length(); iCount++) {
                if (!Character.isDigit(text.charAt(iCount))) {
                    return false;
                }
            }
            return true;
        }
    }
}
