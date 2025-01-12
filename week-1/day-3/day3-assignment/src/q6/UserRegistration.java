package q6;

import java.util.Objects;
import java.util.Scanner;

public class UserRegistration
{
    public static void main(String[] args)
    {
        try
        {
           Scanner sc=new Scanner(System.in);
           System.out.println("USER REGISTRATION");
           System.out.println("Enter the the user details");
           System.out.println("Enter the name of user");
           String name=sc.next();
           System.out.println("Enter the age of user");
           int age=sc.nextInt();
           if(age<18 || age>=60)
           {
               throw new AgeInvalidException("Age should be between 18 and 60");
           }
           System.out.println("Enter the address of user");
           String address=sc.next();
           System.out.println("Enter the nationality of user");
           String nationality=sc.next();
           User user=new User(name,age,address,nationality);
           System.out.println(user.toString());
        }
        catch (AgeInvalidException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
