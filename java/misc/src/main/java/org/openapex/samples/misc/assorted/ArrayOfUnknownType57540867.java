package org.openapex.samples.misc.assorted;

import java.lang.reflect.Array;

public class ArrayOfUnknownType57540867 {
    public static void main(String[] args) {
        int[] i = {1, 2, 3};
        String[] s = {"a", "b", "c"};
        Dog[] d = {new Dog("d"), new Dog("e")};
        process(i);
        process(s);
        process(d);
    }

    private static void process(Object data) {
        System.out.println(data.getClass().getComponentType());
        if(data.getClass().isArray()) {
            int length = Array.getLength(data);
            for(int count =0; count < length; count++ ){
                System.out.println(Array.get(data, count));
            }
        }
    }

    private static class Dog {
        public String name;

        public Dog(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
