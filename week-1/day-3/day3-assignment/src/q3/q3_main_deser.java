package q3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class q3_main_deser
{
    public static void main(String[] args)
    {
        //DESERIALIZATION
        try(ObjectInputStream in=new ObjectInputStream(new FileInputStream("employee.ser")))
        {
            Employee e=(Employee)in.readObject();
            //readObject() returns Object
            //hence type cast in
            System.out.println(e.display());
        } catch (IOException | ClassCastException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
