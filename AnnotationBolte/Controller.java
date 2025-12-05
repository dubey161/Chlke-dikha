package AnnotationBolte;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Controller {
    String path();               // required
    boolean secured() default false;  // optional (with default)
}
