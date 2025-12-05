package AnnotationBolte;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)   // available at runtime
@Target(ElementType.TYPE)             // only usable on class/interface
public @interface MyAnnotation {
}
