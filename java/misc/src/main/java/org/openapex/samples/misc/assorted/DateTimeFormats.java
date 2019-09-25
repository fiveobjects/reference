package org.openapex.samples.misc.assorted;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Properties;

public class DateTimeFormats {
    public static void main(String[] args) {
        Locale zh_CN = new Locale("zh", "CN");
        Locale zh_TW = new Locale("zh", "TN");
        Properties p = new Properties();
        Locale locale = new Locale("zh", "HK", "HANS");
        Locale l = zh_CN;
        initDateFormats(p, l);
        System.out.println(p);
        System.out.println(p.getProperty("dateTimeFormatStrings.shortDateTimeFormat"));
        DateTimeFormatter f = DateTimeFormatter.ofPattern(p.getProperty("dateTimeFormatStrings.shortDateTimeFormat"));
        DateFormat f1 = new SimpleDateFormat(p.getProperty("dateTimeFormatStrings.shortDateTimeFormat"));
        //System.out.println(f1.format());

    }
    private static void initDateFormats(Properties properties, Locale locale) {
        DateFormat shortDateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        DateFormat longDateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
        DateFormat mediumDateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        DateFormat shortTimeFormat = DateFormat.getTimeInstance(DateFormat.SHORT, locale);
        DateFormat mediumTimeFormat = DateFormat.getTimeInstance(DateFormat.MEDIUM, locale);
        DateFormat longTimeFormat = DateFormat.getTimeInstance(DateFormat.LONG, locale);
        properties.put("dateTimeFormatStrings.shortDateFormat", getDatePattern(shortDateFormat));
        properties.put("dateTimeFormatStrings.longDateFormat", getDatePattern(longDateFormat));
        properties.put("dateTimeFormatStrings.mediumDateFormat", getDatePattern(mediumDateFormat));
        properties.put("dateTimeFormatStrings.shortTimeFormat", getTimePattern(shortTimeFormat));
        properties.put("dateTimeFormatStrings.short24TimeFormat", get24TimePattern(shortTimeFormat));
        properties.put("dateTimeFormatStrings.mediumTimeFormat", getTimePattern(mediumTimeFormat));
        // pull out day of year:
        properties.put("dateTimeFormatStrings.longTimeFormat", getTimePattern(longTimeFormat).replace(" z", ""));
        // Not totally locale safe:
        properties.put("dateTimeFormatStrings.fullTimeFormat", getTimePattern(longTimeFormat).replace(" z", "").replace("s", "s:u"));

        properties.put("dateTimeFormatStrings.shortDateTimeFormat", getDatePattern(shortDateFormat) + " " + getTimePattern(shortTimeFormat));
        properties.put("dateTimeFormatStrings.mediumDateTimeFormat", getDatePattern(mediumDateFormat) + " " + getTimePattern(mediumTimeFormat));
    }

    /**
     * Gets the ExtJS format for a Java date format.
     * @param formatter DateFormat to use to get the Java localized pattern.
     * @return Format string for use in ExtJS's Ext.Date.format(date, format);
     */
    private static String getDatePattern(DateFormat formatter) {
        String pattern = ((SimpleDateFormat) formatter).toPattern();
        pattern = pattern.replace("MMMM", "F");
        // don't want to change MMM to M and then change M to n, one or the other.
        if (pattern.contains("MMM")) {
            pattern = pattern.replace("MMM", "M");
        } else {
            pattern = pattern.replace("MM", "m").replace("M", "n");
        }
        pattern = pattern.replace("yyyy", "Y").replace("yy", "y").replace("dd", "d");

        return pattern;
    }

    /**
     * Gets the ExtJS format for a Java time format (non-24 hour time).
     * @param formatter DateFormat to use to get the Java localized pattern.
     * @return Format string for use in ExtJS's Ext.Date.format(date, format);
     */
    private static String getTimePattern(DateFormat formatter) {
        String pattern = ((SimpleDateFormat) formatter).toPattern();
        pattern = pattern.replace("hh", "h").replace("HH", "H").replace("h", "g").replace("H", "G").replace("mm", "i").replace("ss", "s").replace("a", "A");
        return pattern;
    }

    private static String get24TimePattern(DateFormat formatter) {
        String pattern = ((SimpleDateFormat) formatter).toPattern();
        pattern = pattern.replace("mm", "i").replace("ss", "s").replace("h", "H").replace("HH", "H").replace(" a", "");
        return pattern;
    }
}
