package q2;
import java.lang.annotation.*;
//1) first step is to create the annotation class
//author
@Target(value = { ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Author
{
    String name() default "unknown";
}