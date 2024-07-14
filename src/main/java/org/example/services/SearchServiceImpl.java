package org.example.services;

import org.example.annotations.IntensiveComponent;
import org.example.services.interfaces.SearchService;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;

import java.util.HashSet;
import java.util.Set;


/**
 * Implementation of SearchService using the Reflections library.
 */
public class SearchServiceImpl implements SearchService {
    @Override
    public Set<Class<?>> findIntensiveComponentAnnotatedClasses(String basePackage) {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .forPackage(basePackage)
                .addScanners(Scanners.TypesAnnotated));
        return reflections.getTypesAnnotatedWith(IntensiveComponent.class);
    }

    @Override
    public Class<?> findClass(String packageName, Class<?> type) {
        Set<Class<?>> intensiveComponentAnnotatedClasses = findIntensiveComponentAnnotatedClasses(packageName);
        Set<Class<?>> foundClasses = new HashSet<>();
        Class<?> foundClass = null;
        for (Class<?> intensiveComponentAnnotatedClass : intensiveComponentAnnotatedClasses) {
            if (type.isAssignableFrom(intensiveComponentAnnotatedClass)) {
                foundClasses.add(intensiveComponentAnnotatedClass);
                foundClass = intensiveComponentAnnotatedClass;
            }
        }
        if (foundClasses.size() != 1) {
            throw new RuntimeException("Class not found or there is more than one implementation");
        }
        return foundClass;
    }
}
