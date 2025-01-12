package q3;

public class CurrentAccount extends Account
{
    private String tradeLicenseNumber;
    private double overdraft;

    CurrentAccount(String name, String accountNumber, double accountBalance, String tradeLicenseNumber, double overdraft)
    {

        super(name, accountNumber, accountBalance);
        this.tradeLicenseNumber=tradeLicenseNumber;
        this.overdraft=overdraft;
    }
    public double getBalance()
    {
        return super.getAccountBalance();
    }
    public void withdraw(double amount)
    {
        if(amount<=(super.getAccountBalance()+overdraft)) {
            setAccountBalance(super.getAccountBalance() - amount);
            System.out.println("Withdrawed: "+ amount);
            System.out.println("Balance: "+ super.getAccountBalance());
            return;
        }
        System.out.println("Withdrawal over the limit. This is not permissible");
    }
    public void display(String name, String accountNumber, double accountBalance, String tradeLicenseNumber, double overdraft)
    {
        System.out.println("name: "+name);
        System.out.println("account number: "+accountNumber);
        System.out.println("account balance: "+accountBalance);
        System.out.println("trade license: "+tradeLicenseNumber);
        System.out.println("overdraft: "+overdraft);
    }

}
