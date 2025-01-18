package q2;
//1) first step is to create the annotation class
//version
import java.lang.annotation.*;
@Target(value = { ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Version {
    double number();
}