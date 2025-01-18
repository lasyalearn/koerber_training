package q1;
public class SingletonEager
{

    // Eager initialization of the Singleton instance
    // the instance is created as soon as the class is loaded
    //even if it never used
    //public static final is assigned to the instance
    // it marked final as it should not be reassigned again

    private static final SingletonEager instance = new SingletonEager();

    // for singleton the constructor should be private why because
    // we want to prevent external instantiation
    private SingletonEager()
    {
        System.out.println("The object has been created");
    }


    //Singleton pattern mean there should only be one object for the class
    //since we have instantiated  at creation time
    //we need to return the instance
    //and constructor is private
    //hence it cannot be called
    public static SingletonEager getInstance() {
        return instance;
    }

    public void displayMessageSingletonEager()
    {
        System.out.println("Singleton pattern: Eager initialization");
    }

    public static void main(String[] args)
    {
        SingletonEager singleton = SingletonEager.getInstance();
        singleton.displayMessageSingletonEager();
    }
}