package q1;

public class SingletonLazy
{

    // lazy intialization

    private static SingletonLazy instance;
    //lazy initialization
    // it is instantiated when it is used for the first time

    private SingletonLazy()
    {
        System.out.println("The object has been created");
    }

    public static SingletonLazy getInstance()
    {
        if(instance == null)
        {
            instance = new SingletonLazy();
        }
        else
        {
            System.out.println("The object has already been created");
        }
        return instance;
    }

    public  void displayMessageSingletonLazy()
    {
        System.out.println("Singleton pattern: lazy initialization");
    }


    public static void main(String[] args)
    {
        SingletonLazy singleton = SingletonLazy.getInstance();
        singleton.displayMessageSingletonLazy();
    }
}

