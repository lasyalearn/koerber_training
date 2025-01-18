package q1;

public class SingletonEnum
{
    enum singletonEnum
    {
        singleton;

        public void displaySingletonEnum()
        {
            System.out.println("The object has been created");
        }

    }

    public static void main(String[] args)
    {

        singletonEnum s1= singletonEnum.singleton;
        // itseems that we singleton.singleton is called JVM will create the instance
        // and load it to the memory
        singletonEnum s2= singletonEnum.singleton;
        s1.displaySingletonEnum();
        s2.displaySingletonEnum();
        System.out.println("s1 hashcode:" +s1.hashCode());
        System.out.println("s2 hashcode: "+s2.hashCode());
    }
    // is  safe

}
