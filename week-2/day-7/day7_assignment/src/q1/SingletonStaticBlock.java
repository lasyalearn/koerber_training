package q1;
public class SingletonStaticBlock
{
    //static blocks
    //static{}
    //it used to initialize the static variables
    //it is called before the main method
    //it is called only once per class
    //JVM uses to load the class into memo
    private static SingletonStaticBlock instance;

    static
    {
        try
        {
            instance = new SingletonStaticBlock();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


    private SingletonStaticBlock()
    {
        System.out.println("The object has been created");
    }

    public static SingletonStaticBlock getInstance()
    {
        return instance;
    }

    public void displayMessageSingletonStaticBlock()
    {
        System.out.println("Singleton pattern: Static block initialization");
    }


    public static void main(String[] args) {
        SingletonStaticBlock singleton = SingletonStaticBlock.getInstance();
        singleton.displayMessageSingletonStaticBlock();
    }
}
