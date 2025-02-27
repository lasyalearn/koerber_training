package q1;

// the issue with serialization is that it is not thread safe
// as it create a new object
// when we deserialize it

import java.io.*;

public class SingletonSerializationIssue  implements java.io.Serializable
{
    private static SingletonSerializationIssue instance;
    private SingletonSerializationIssue()
    {
        System.out.println("The object has been created");
    }
    public static SingletonSerializationIssue getInstance()
    {
        if(instance == null)
        {
            instance = new SingletonSerializationIssue();
        }
        else
        {
            System.out.println("The object has already been created");
        }
        return instance;
    }
    public void displayMessageSingletonSerializationIssue()
    {
        System.out.println("Singleton pattern: serialization issue");
    }
    //generally during deserialization a new object is created
    // this will violate the singleton
    //JVM will invoke this method
    // this method will be called during deserialization
    // return getInstance()
    //help to  maintain the singleton during deserialization
    //@Serial--> helps to indetify that participate in serialization
    //like readResolve
    @Serial
    protected Object readResolve() {
        return getInstance();
    }
    // get the same hashcode as the instance
    // if the method is not smae then we get different hashcodes
    public static <SingletonSerializationSafe> void main(String[] args) throws IOException, ClassNotFoundException {
        SingletonSerializationIssue singleton1 = SingletonSerializationIssue.getInstance();
        singleton1.displayMessageSingletonSerializationIssue();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
        oos.writeObject(singleton1);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.ser"));
        SingletonSerializationSafe singleton2 = (SingletonSerializationSafe) ois.readObject();
        ois.close();
        System.out.println("Object1  hashcode: " + singleton1.hashCode());
        System.out.println("Object2 hashcode: " + singleton2.hashCode());


    }
}
