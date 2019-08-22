package org.openapex.samples.misc.instrument;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class MyInstrumentationAgent {
    private static Instrumentation instrumentation;

    public static void premain(String agentArgs, Instrumentation inst){
        instrumentation = inst;
        System.out.println("Set the instrumentation from premain");
        //instrumentation.addTransformer(new MyClassTransformer());
    }
    public static void premain(String agentArgs){
        System.out.println("Unable to set instrumentation premain");
    }

    public static void agentmain(String agentArgs, Instrumentation inst){
        instrumentation = inst;
        System.out.println("Set the insttrumentation from agentmain");
    }
    public static void agentmain(String agentArgs){
        System.out.println("Unable to set instrumentation agentmain");
    }

    public static long getObjectSize (Object object){
        if (instrumentation != null){
            return instrumentation.getObjectSize(object);
        }
        System.out.println("Unable to determine object size, instrumentation is not available");
        return 0;
    }

    private static class MyClassTransformer implements ClassFileTransformer{

        @Override
        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
            // Here change the byte code
            byte[] newbytes = new byte[100];
            System.out.println(newbytes.length);
            return newbytes;
        }
    }
}
