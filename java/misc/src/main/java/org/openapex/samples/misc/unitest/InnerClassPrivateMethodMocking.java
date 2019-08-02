package org.openapex.samples.misc.unitest;

public class InnerClassPrivateMethodMocking {
    public InnerClass methodA() {
        return new InnerClass();
    }

    private class InnerClass {
        public void methodB() {
            send();
        }

        private String send() {
            return "hello";
        }
    }
}
