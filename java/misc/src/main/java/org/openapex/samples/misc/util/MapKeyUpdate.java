package org.openapex.samples.misc.util;

import java.util.HashMap;
import java.util.Map;

public class MapKeyUpdate {
    public static void main(String[] args) {
        Integer x = new Integer(100);
        Integer y = new Integer(100);

        System.out.println(x == y); // false : Object equality, they are different
        System.out.println(x == 100); // true : Auto unboxing kicked in  as one of them is primitive
        System.out.println(x == Integer.valueOf(100)); // false: Object equality
        System.out.println(Integer.valueOf(100) == Integer.valueOf(100)); // true: Object equality but interestingly this is true since Integer cache used by valueof() returns the same object
        Map<Object, Object> data = new HashMap<>();
        data.put("1234", "abc");
        data.put("2", "pqr");
        data.put("342", "xyz");
        data.put("40", "mno");

        data.entrySet().forEach(e -> {
            Object normalizedKey = e.getKey().toString() + '0';
            //ßdata.remove(e.getKey());
            //e.se(normalizedKey, e.getValue());
        });
        System.out.println(data);
    }

}
