package q1;

public class SingletonCloningIssue implements Cloneable
{

    private static SingletonCloningIssue instance;

    private SingletonCloningIssue()
    {
        System.out.println("The object has been created");
    }

    public static SingletonCloningIssue getInstance()
    {
        if (instance == null) {
            instance = new SingletonCloningIssue();
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        // we should override the clone method
        //as it is not thread safe
        //and we should allow to create anew object
        throw new CloneNotSupportedException("Cloning of Singleton is not allowed");
    }

    public static void main(String[] args)
    {
        SingletonCloningIssue singleton1 = SingletonCloningIssue.getInstance();
        try {
            SingletonCloningIssue singleton2 = (SingletonCloningIssue) singleton1.clone();
        } catch (CloneNotSupportedException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
