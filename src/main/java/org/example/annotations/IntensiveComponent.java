package org.example.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation for marking components managed by the IntensiveContext
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface IntensiveComponent {
}
