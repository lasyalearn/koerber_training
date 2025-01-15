package q2;

public class Main_sync_method
{
    public static void main(String[] args)
    {
        // sync method
        //same account
        Account account1 = new Account(1000);
        System.out.println("Beginning of sync method: "+account1.toString());
        Company_sync_method companySync = new Company_sync_method(account1);
        Bank_sync_method bankSync = new Bank_sync_method(account1);
        Thread companyThreadSync = new Thread(companySync);
        Thread bankThreadSync = new Thread(bankSync);
        companyThreadSync.start();
        bankThreadSync.start();
        try {
            bankThreadSync.join();
            companyThreadSync.join();
        } catch (InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("Ending of sync method: "+account1.toString());
        System.out.println("End of the main thread");

    }
}
