package org.openapex.samples.misc.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComplexNumberMatch57534193 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        final String regex = "(?=[\\d.i])(\\d++\\.?+\\d*+|\\d*+\\.?+\\d++)?(?:\\+)(\\d++\\.?+\\d*+|\\d*+\\.?+\\d++)?+i(?=\\s|\\z)"+
                "|(?=[\\d.i])(\\d++\\.?+\\d*+|\\d*+\\.?+\\d++)?(\\d++\\.?+\\d*+|\\d*+\\.?+\\d++)?+i?(?=\\s|\\z)";
        final String string = sc.nextLine();

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }

    }
}
