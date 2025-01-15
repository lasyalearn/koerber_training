package q2;

public class Main
{
    // First we need to identify the worker
    // and the job
    // here the worker are the company and the bank
    // job here is to add and subtract the money
    // the job should implement the runnable interface
    // and the worker should implement the thread class
    public static void main(String[] args)
    {
        System.out.println("Start of the main thread");
        Account account = new Account(50000);
        Company company = new Company(account);
        Bank bank = new Bank(account);
        System.out.println("Beginning: "+account.toString());
        Thread companyThread = new Thread(company);
        Thread bankThread = new Thread(bank);
        companyThread.start();
        bankThread.start();
        try {
            bankThread.join();
            companyThread.join();
        } catch (InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("Ending: "+account.toString());


    }
}
