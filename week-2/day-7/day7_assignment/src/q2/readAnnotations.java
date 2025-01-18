package q2;

import java.lang.reflect.Method;

public class readAnnotations
{
    public static void readAnnotationsOfClassMethodsConstructors(String className)
    {
        try
        {

            Class<?> class1=Class.forName(className);
            Author author1=class1.getAnnotation(Author.class);
            Version version1=class1.getAnnotation(Version.class);
            System.out.println("Author Name: " + author1.name());
            System.out.println("Version Number: "+version1.number());

            Method[] methods=class1.getMethods();
            for(Method method:methods)
            {
                if(method.isAnnotationPresent(Author.class))
                {
                    Author author=method.getAnnotation(Author.class);
                    System.out.println("Author Name: " + author.name());
                }
                if(method.isAnnotationPresent(Version.class))
                {
                    Version version=method.getAnnotation(Version.class);
                    System.out.println("Version Number: "+version.number());
                }
            }
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
