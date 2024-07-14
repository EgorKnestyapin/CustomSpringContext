package org.example.services.interfaces;

/**
 * Interface for creating class instances.
 */
public interface DependencyFactory {
    /**
     * Creates instances for a specific class using the default constructor
     *
     * @param type type of class to create
     * @return class instance
     */
    <T> T createInstance(Class<T> type);
}
