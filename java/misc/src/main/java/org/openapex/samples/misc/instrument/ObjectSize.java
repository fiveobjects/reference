package org.openapex.samples.misc.instrument;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;
import java.lang.instrument.Instrumentation;
import java.util.HashMap;
import java.util.Map;

public class ObjectSize {
    public static void main(String[] args) {
        File f = new File("data/user.csv");
        String hello = "Hello World";
        Integer num = Integer.valueOf(100);
        Map<Integer, Employee> employees = new HashMap<>();
        employees.put(1, new Employee("abc", "address1"));
        employees.put(2, new Employee("def", "address2"));
        employees.put(3, new Employee("ghi", "address3"));
        employees.put(4, new Employee("jkl", "address4"));
        System.out.println("Size of file object (bytes): " + MyInstrumentationAgent.getObjectSize(f));
        System.out.println("Size of string (bytes): " + MyInstrumentationAgent.getObjectSize(hello));
        System.out.println("Size of integer (bytes): " + MyInstrumentationAgent.getObjectSize(num));
        System.out.println("Size of map (bytes): " + MyInstrumentationAgent.getObjectSize(employees));
    }

    @Data
    @AllArgsConstructor
    private static class Employee {
        private String name;
        private String address;
    }
}
