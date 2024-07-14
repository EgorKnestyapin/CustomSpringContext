package org.example.services.interfaces;

import java.util.Set;

/**
 * Interface for finding classes annotated with {@link org.example.annotations.IntensiveComponent}.
 */
public interface SearchService {
    /**
     * Finds classes annotated with {@link org.example.annotations.IntensiveComponent}
     *
     * @param basePackage package to look for
     * @return set of found classes marked with annotation {@link  org.example.annotations.IntensiveComponent}
     */
    Set<Class<?>> findIntensiveComponentAnnotatedClasses(String basePackage);

    /**
     * Finds a class of a specific type annotated with {@link org.example.annotations.IntensiveComponent}
     *
     * @param packageName package to look for
     * @param type type of class to find
     * @return found class of specific type
     */
    Class<?> findClass(String packageName, Class<?> type);
}
