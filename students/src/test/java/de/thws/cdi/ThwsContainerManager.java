package de.thws.cdi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ThwsContainerManager {

    <T> T manage(Class<T> clazz) {

        try {
            T newObject = clazz.getDeclaredConstructor().newInstance();

            for (var field : clazz.getDeclaredFields()) {
                System.out.println("field: " + field.getName());

                if (field.isAnnotationPresent(ThwsInject.class)) {
                    field.setAccessible(true);

                    Object managedInjectableObject = field.getType().getDeclaredConstructor().newInstance();

                    try {
                        Method m = managedInjectableObject.getClass().getMethod("init");
                        m.invoke(managedInjectableObject, new Object[] {});
                    } catch (NoSuchMethodException e) {
                        System.out.println("no specific managedInjectableObject initialization");
                    }

                    field.set(newObject, managedInjectableObject);
                }

            }

            return newObject;

        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            throw new RuntimeException(e);
        }

    }
}
