package q2;

public class Bank_sync_method implements Runnable
{
    //bank subtracts
    Account account;

    public Bank_sync_method(Account account)
    {
        this.account = account;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++)
        {
            account.subtractAmountSync(1000);
        }

    }
}
