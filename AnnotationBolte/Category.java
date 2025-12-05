package AnnotationBolte;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(Categories.class)
public @interface Category {
    String value();
}
