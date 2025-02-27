package q5;

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
           System.out.println("Enter the address of user");
           String address=sc.next();
           System.out.println("Enter the nationality of user");
           String nationality=sc.next();
           if(Objects.equals(nationality, "india") || Objects.equals(nationality, "INDIA") || Objects.equals(nationality, "India"))
           {
               User user=new User(name,age,address,nationality);
               System.out.println(user.toString());
           }
           else
           {
               throw new InvalidCountryException("Invalid Country ["+nationality+"]");
           }
        }
        catch (InvalidCountryException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
