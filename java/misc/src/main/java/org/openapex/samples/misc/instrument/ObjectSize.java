package org.openapex.samples.misc.instrument;

import java.io.File;
import java.lang.instrument.Instrumentation;

public class ObjectSize {
    public static void main(String[] args) {
        File f = new File("data/user.csv");
        String hello = "Hello World";
        Integer num = Integer.valueOf(100);
        System.out.println("Size of file object (bytes): "+MyInstrumentationAgent.getObjectSize(f));
        System.out.println("Size of string (bytes): "+MyInstrumentationAgent.getObjectSize(hello));
        System.out.println("Size of integer (bytes): "+MyInstrumentationAgent.getObjectSize(num));
    }
}
