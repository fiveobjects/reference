package org.openapex.samples.misc.assorted;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<String> stringList1 = new ArrayList<>(Arrays.asList("01", "03", "15"));
        List<String> stringList = new ArrayList<>(Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15"));

        stringList.addAll(stringList1);
        Set<String> set = new HashSet<>(stringList);
        stringList = new ArrayList<>();
        stringList.addAll(set);
        System.out.println("=== s:" + stringList);
        List<Test> tests = new ArrayList<>();
        tests.addAll(Arrays.asList(Test.VAL1, Test.VAL2));
        System.out.println(tests);
        System.out.println(Arrays.toString(Test.values()));
    }

    public enum Test {
        VAL1("prop1", "prop2"),
        VAL2("prop3", "prop4");
        private final String p1;
        private final String p2;

        public String getP1() {
            return p1;
        }

        public String getP2() {
            return p2;
        }

        Test(String p1, String p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        public String toString() {
            return "p1:" + p1 + " p2:" + p2;
        }
    }
}
