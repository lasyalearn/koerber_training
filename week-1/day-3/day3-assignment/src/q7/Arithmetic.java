package q7;

import java.util.Scanner;

public class Arithmetic
{
    public static void main(String[] args) {

        try
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the first number");
            int a = sc.nextInt();
            System.out.println("Enter the second number");
            int b = sc.nextInt();
            if(b==0)
            {
                throw new ArithmeticInvalidException("Division by zero error");
            }
            else
            {
                System.out.println(a/b);
            }
        }
        catch (ArithmeticInvalidException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            System.out.println("Inside finally block");
        }

    }
}
