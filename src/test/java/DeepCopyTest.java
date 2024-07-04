import org.example.DeepCopyUtil;
import org.example.ObjectChildTest;
import org.example.ObjectTest;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;

public class DeepCopyTest {


    @Test
     /*
     Tests if the copied object is equal to the original, field by field, then checks the list of objects within it and verifies them as well
     */
    public void test() throws IllegalAccessException {
        ObjectTest object = ObjectTest.getObjectTest();
        ObjectTest result = DeepCopyUtil.deepCopy(object);
        testFields(object, result);
        List<ObjectChildTest> objectChildTests = object.getObjectChildTests();
        List<ObjectChildTest> resultChildTests = result.getObjectChildTests();
        for (int i = 0; i < objectChildTests.size(); i++) {
            testFields(objectChildTests.get(i), resultChildTests.get(i));
        }
    }

    private void testFields(Object object, Object result) {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);

                Object value1 = field.get(object);
                Object value2 = field.get(result);
                System.out.println(field.getName() + " : " + value1 + " : " + value2);
                Assert.assertEquals(value1, value2);
            }
        } catch (IllegalAccessException ignored) {
            Assert.fail();
        }
    }

    @Test
     /*
     Tests if the copied collections have the same reference as the original collections
     */
    public void testCollections() throws IllegalAccessException {
        ObjectTest object = ObjectTest.getObjectTest();
        ObjectTest result = DeepCopyUtil.deepCopy(object);

        object.getStringList().add("test");
        Assert.assertNotEquals(object.getStringList().size(), result.getStringList().size());
    }

}
