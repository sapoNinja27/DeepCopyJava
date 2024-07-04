package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class DeepCopyUtil {

    public static <T> T deepCopy(T obj) throws IllegalAccessException {
        if (obj == null) {
            return null;
        }

        Class<?> clazz = obj.getClass();
        T copy;
        try {
            copy = (T) clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return obj;
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object fieldValue = field.get(obj);
//            System.out.println(field.getName() + ":" + fieldValue);
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            if ((field.getType().isPrimitive())) {
                field.set(copy, fieldValue);
            } else {
                field.set(copy, deepCopy(fieldValue));
            }
        }

        return copy;
    }
}

