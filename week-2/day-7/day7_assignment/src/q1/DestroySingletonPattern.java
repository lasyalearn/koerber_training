package q1;
import java.lang.reflect.*;

//Java Reflection
//allows you to inspect and modify classes/method/constructor/annotation at runtime





// in java reflection has access to private constructor
//which may lead to creation of new instance of the class
//it will violate the singleton pattern

public class DestroySingletonPattern {

    private static DestroySingletonPattern instance;

    private DestroySingletonPattern()
    {
        // if i comment these
        // i will be like remove the safegaurd
        // reflection will able to create a instance
//        if (instance != null) {
//            throw new RuntimeException("Violating Singleton pattern.");
//        }
        System.out.println("The object has been created");
    }

    public static DestroySingletonPattern getInstance()
    {
        if (instance == null) {
            instance = new DestroySingletonPattern();
        }
        return instance;
    }
    public void displayMessageDestroySingletonPattern()
    {
        System.out.println("Singleton pattern: destroy singleton pattern");
    }
    public static void main(String[] args)
    {
        DestroySingletonPattern singleton1 = DestroySingletonPattern.getInstance();
        singleton1.displayMessageDestroySingletonPattern();
        System.out.println("Singleton1 hashcode: " + singleton1.hashCode());


        try
        {
            //Constructor is used to to access the private constructor of the singleton class
            //constructor is class

            Constructor<DestroySingletonPattern> constructor = DestroySingletonPattern.class.getDeclaredConstructor();
            // we make the access private
            constructor.setAccessible(true);
            DestroySingletonPattern singleton2 = constructor.newInstance();
            System.out.println("Singleton2 hashcode: " + singleton2.hashCode());
        }
        catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
