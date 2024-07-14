package org.example.context;

import org.example.services.*;
import org.example.services.interfaces.DependencyFactory;
import org.example.services.interfaces.InjectionService;
import org.example.services.interfaces.SearchService;

import java.util.HashMap;
import java.util.Map;

/**
 * Context for managing objects annotated with {@link org.example.annotations.IntensiveComponent}
 */
public class IntensiveContext {
    private String packageName;
    private SearchService searchService;
    private DependencyFactory dependencyFactory;
    private InjectionService injectionService;
    private Map<Class<?>, Object> cache = new HashMap<>();

    /**
     * @param packageName package to look for
     */
    public IntensiveContext(String packageName) {
        this.packageName = packageName;
        this.searchService = new SearchServiceImpl();
        this.dependencyFactory = new DependencyFactoryImpl();
        this.injectionService = new InjectionServiceImpl();
    }

    /**
     * Retrieves an instance of the specified class type, initializing and injecting its dependencies into fields
     * marked with annotations {@link org.example.annotations.IntensiveComponent}
     *
     * @param type class object representing the type to retrieve
     * @return an instance of the specified typ
     */
    public <T> T getObject(Class<T> type) {
        if (cache.containsKey(type)) {
            return (T) cache.get(type);
        }

        Class<?> aClass = searchService.findClass(packageName, type);
        T instance = (T) dependencyFactory.createInstance(aClass);
        injectionService.injectDependencies(instance, this);
        cache.put(type, instance);
        return instance;
    }
}
