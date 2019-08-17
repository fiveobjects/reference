package org.openapex.samples.misc.thread;

public class SpringMultipleThreads {
    public static void main(String[] args) {
        new SpringMultipleThreads().postConstructor();
    }
    private void postConstructor() {

        Thread threadAlpha = new Thread(() -> {
            while (true) {
                System.out.println("1");
                try {
                    Thread.sleep(1000 * 3);
                } catch (InterruptedException e) {
                }
            }
        });
        Thread threadBeta = new Thread(() -> {
            while (true) {
                System.out.println("2");
                try {
                    Thread.sleep(1000 * 3);
                } catch (InterruptedException e) {
                }
            }
        });
        threadBeta.start();
        threadAlpha.start();
    }
}
