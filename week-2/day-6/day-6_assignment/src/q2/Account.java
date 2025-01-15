package q2;

public class Account
{
    final Object lock = new Object();
    private double balance;
    Account(double balance)
    {
        this.balance = balance;
    }
    //setters
    public void setBalance(double balance)
    {
        this.balance = balance;
    }
    //getters
    public double getBalance()
    {
        return balance;
    }
    @Override
    public String toString()
    {
        StringBuffer stringBuffer= new StringBuffer("Account{");
        stringBuffer.append("balance=").append(balance);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
    // sync method
    public synchronized void addAmountSync(double amount)
    {
        this.balance += amount;
    }
    //sync method
    public synchronized void subtractAmountSync(double amount)
    {
        if(this.balance >= amount)
        {
            this.balance -= amount;
        }
        else
        {
            System.out.println("Insufficient Balance");
        }
    }
    // block method
    public void addAmount(double amount)
    {
        synchronized (lock)
        {
            this.balance += amount;
        }
    }
    //block method
    public void subtractAmount(double amount)
    {
        synchronized (lock)
        {
            if(this.balance >= amount)
            {
                this.balance -= amount;
            }
            else
            {
                System.out.println("Insufficient Balance");
            }

        }
    }
}
