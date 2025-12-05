package AnnotationBolte;

import java.lang.annotation.*;

@Repeatable(Roles.class)           // Enables multiple usage
@Target(ElementType.TYPE)          // Can only be used on classes
@Retention(RetentionPolicy.RUNTIME)
public @interface Role {
    String value();
}
