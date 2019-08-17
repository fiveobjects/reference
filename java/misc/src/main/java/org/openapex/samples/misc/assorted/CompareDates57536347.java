package org.openapex.samples.misc.assorted;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CompareDates57536347 {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM");
        Calendar cal = Calendar.getInstance();
        Date comDate = new Date();
        cal.add(Calendar.DATE, 8);
        //this adds days to the calender
        comDate = cal.getTime();
        //this applies the edited calender to the date I'm comparing to

        ArrayList<String> arDat = new ArrayList<String>();
        arDat.add("15/08");
        arDat.add("15/09");
        arDat.add("30/08");

        Date redDate = new Date();
        System.out.println("compDate: " + comDate);
        for (int i = 0; i < arDat.size(); i++) {
            Date recDate = formatter.parse(arDat.get(i));
            if (formatter.format(recDate).compareTo(formatter.format(comDate)) < 0) {
                System.out.println("String comparison result: " + recDate);
            }
            if (recDate.compareTo(formatter.parse(formatter.format(comDate))) < 0) {
                System.out.println("Date comparison result: " + recDate);
            }
        }
    }
}
