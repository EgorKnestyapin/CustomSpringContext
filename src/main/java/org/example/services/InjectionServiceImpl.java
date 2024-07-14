package org.example.services;

import org.example.annotations.IntensiveComponent;
import org.example.context.IntensiveContext;
import org.example.services.interfaces.InjectionService;

import java.lang.reflect.Field;

/**
 * Implementation of InjectService using the Reflections library.
 */
public class InjectionServiceImpl implements InjectionService {

    @Override
    public <T> void injectDependencies(T instance, IntensiveContext context) {
        Field[] fields = instance.getClass().getDeclaredFields();
        for (Field field: fields) {
            if (field.isAnnotationPresent(IntensiveComponent.class)) {
                field.setAccessible(true);
                Object dependency = context.getObject(field.getType());
                try {
                    field.set(instance, dependency);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Error while setting a field " + field, e);
                }
            }
        }
    }
}
