package q1;

public class SingletonThreadSafe
{
    //to make the class thread safe we need to use synchronized keyword
    //synchronized keyword will lock the object on which it is used
    private static SingletonThreadSafe instance;
    private SingletonThreadSafe()
    {
        System.out.println("The object has been created");
    };
    public static SingletonThreadSafe getInstance()
    {
        if(instance == null)
        {
            // to unsure it is thread safe we need to use synchronized
            synchronized (SingletonThreadSafe.class)
            {
                if(instance == null)
                {
                    instance = new SingletonThreadSafe();
                }
            }
        }
        else
        {
            System.out.println("The object has already been created");
        }
        return instance;
    }
    public void displayMessageSingletonThreadSafe()
    {
        System.out.println("Singleton pattern: thread safe initialization");
    }
    public static void main(String[] args)
    {
        SingletonThreadSafe singleton = SingletonThreadSafe.getInstance();
        singleton.displayMessageSingletonThreadSafe();
    }

}
