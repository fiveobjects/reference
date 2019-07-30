package org.openapex.samples.misc.assorted;

import java.time.LocalDateTime;

public class LocalDateTimeMillisMicros57262155 {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.parse("2019-06-11T11:08:03.520808999");
        System.out.println(dateTime.toString());
        System.out.println(dateTime.getNano());
    }
}
