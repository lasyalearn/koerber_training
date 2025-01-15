package q2;

public class Company implements Runnable
{
    // company adds
    Account account;

    public Company(Account account)
    {
        this.account = account;
    }

    @Override
    public void run()
    {
        for(int i=0;i<100;i++) {
            account.addAmount(1000);
        }

    }

}
