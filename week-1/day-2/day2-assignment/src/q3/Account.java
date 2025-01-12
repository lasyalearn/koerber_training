package q3;

public  class Account
{
    // they are instance variables
    private String name;
    private String accountNumber;
    private double accountBalance;
    // setter
    Account(String name, String accountNumber,double accountBalance)
    {
        this.name=name;
        this.accountNumber=accountNumber;
        this.accountBalance=accountBalance;
    }
    public  void setAccountBalance(double accountBalance)
    {
        this.accountBalance=accountBalance;
    }
    //getter
    public String getName()
    {
        return(this.name);
    }
    public  String getAccountNumber()
    {
        return(this.accountNumber);
    }

    public double getAccountBalance() {
        return this.accountBalance;
    }
    //deposit method
    public void deposit(double deposit_money)
    {
        double amount=getAccountBalance()+deposit_money;
        setAccountBalance(amount);
    }
}