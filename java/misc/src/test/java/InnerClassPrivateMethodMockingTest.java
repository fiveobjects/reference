import org.junit.Test;
import org.openapex.samples.misc.unitest.InnerClassPrivateMethodMocking;
import org.powermock.reflect.Whitebox;

import java.lang.reflect.Constructor;

public class InnerClassPrivateMethodMockingTest {
    @Test
    public void testMethodB() throws Exception{
        InnerClassPrivateMethodMocking target = new InnerClassPrivateMethodMocking();
//        Class clazz = Whitebox.getInnerClassType(InnerClassPrivateMethodMocking.class, "InnerClass");
//        Constructor constructor = Whitebox.getConstructor(clazz, InnerClassPrivateMethodMocking.class);
//        Object innerClass = constructor.newInstance(new InnerClassPrivateMethodMocking());
//        System.out.println(innerClass);



    }
}
