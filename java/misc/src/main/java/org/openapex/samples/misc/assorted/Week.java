package org.openapex.samples.misc.assorted;

public class Week {

    public final Week SUNDAY = new Week("SUNDAY",0);
    public final Week MONDAY = new Week("MONDAY",1);

    private String name;
    private int val;

    private Week(String name, int val) {
        this.name = name;
        this.val = val;
    }

    public int getIndex() {
        return this.val;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static void main(String[] args) {
        new Week("TUESDAY", 2);
    }
}