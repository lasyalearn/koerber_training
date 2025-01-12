package q3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class q3_main_ser
{
    public static void main(String[] args)
    {
        //SERIALIZATION
        /*
        *  in Java is the process of converting an object into a byte stream so it can be:
        * Stored in a file, database, or memory
        * Transmitted over a network
        * Persisted for later reconstruction
        * The reverse process of converting the byte stream back into an object is called deserialization.
        * */
        Employee employee = new Employee(1,"John Doe","123 Main Street",50000.0);
        //ObjectOutputStream ---> It used to serialize an object into a byte stream
        //ObjectInputStream ---> It used to deserialize a object from the input stream
        // first we need to serialize the object employee
        // so first we need to use ObjectOutputStream
        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("employee.ser")))
        {
            out.writeObject(employee);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
