package q2;

public class Bank implements Runnable
{
    //bank subtracts
    Account account;

    public Bank(Account account)
    {
        this.account = account;
    }

    @Override
    public void run()
    {
        for(int i=0;i<100;i++)
        {
            account.subtractAmount(1000);
        }
    }
}
