package org.example.services;

import org.example.services.interfaces.DependencyFactory;

/**
 * Implementation of DependencyFactory.
 */
public class DependencyFactoryImpl implements DependencyFactory {
    @Override
    public <T> T createInstance(Class<T> type) {
        try {
            return type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance of " + type, e);
        }
    }
}
