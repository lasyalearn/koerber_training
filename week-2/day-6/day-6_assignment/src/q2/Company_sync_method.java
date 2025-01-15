package q2;

public class Company_sync_method implements Runnable
{
    Account account;

    public Company_sync_method(Account account)
    {
        this.account = account;
    }

    @Override
    public void run()
    {
        for(int i=0;i<100;i++) {
            account.addAmountSync(1000);
        }

    }
}
