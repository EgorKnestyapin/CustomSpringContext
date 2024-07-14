package org.example.services.interfaces;

import org.example.context.IntensiveContext;

/**
 * Interface for dependency injection into class fields.
 */
public interface InjectionService {
    /**
     * Injects dependencies into class fields.
     *
     * @param instance instance into which dependencies should be injected
     * @param context context in which the object beans are located
     */
    <T> void injectDependencies(T instance, IntensiveContext context);
}
