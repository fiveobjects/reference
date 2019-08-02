package org.openapex.samples.misc.assorted;

public class EventPropagation {
    public static void main(String[] args) {
        C c = new C();
        c.foo();
    }
    abstract static class A {
        public void foo() {
            // Some stuff here
            onFoo();
        }

        protected void onFoo(){
            System.out.println("Action from A");
        }
    }

    abstract static class B extends A {
        @Override
        protected void onFoo() {
            // More stuff here
            System.out.println("Action from B");
            super.onFoo();
        }
    }

    static class C extends B {
        @Override
        protected void onFoo() {
            // Even more stuff here
            System.out.println("Action from C");
            super.onFoo();
        }
    }
}
