package q3;

import java.util.Scanner;

public class q3_tester
{
    public static void main(String[] args)
    {
        // savings account
        //here conversion is required because the object is of the type Account and not Savings
        //hence the getbalace is method of the base savings account so if the base has to use it
        // then we need conversion
        //  once way to  avoid this to use abstraction
        // but the question  asked for inheritance
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choice 1.Savings account 2.Current account");
        System.out.println("Enter the number: ");
        int choice = scanner.nextInt();
        if(choice ==1)
        {
            SavingsAccount account1= new SavingsAccount("Koerber", "1234512345", 50000, 1000);
            double balance= account1.getBalance();
            System.out.println("balance: "+balance);
            // withdraw out of limit
            account1.withdraw(50000);
            //withdraw within the limit
            account1.withdraw(30000);
        }
        else if(choice==2)
        {
            //current account
            CurrentAccount account2= new CurrentAccount("Koerberban", "1234512345", 50000, "abcd" ,1000);
            double balance_current= account2.getBalance();
            System.out.println("balance: "+balance_current);
            // withdraw out of limit
            account2.withdraw(60000);
            //withdraw within the limit
            account2.withdraw(50500);
        }
        else
        {
            System.out.println("Entered the wrong option");
        }

    }
}
