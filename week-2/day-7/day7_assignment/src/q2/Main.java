package q2;

import java.lang.reflect.Method;

@Author(name = "Johny")
@Version(number = 1.0)
public class Main
{
    public static void main(String[] args)
    {
        readAnnotations.readAnnotationsOfClassMethodsConstructors("q2.AnnotatedClass");
    }
}
