package q3;

public class SavingsAccount extends Account
{
    private double interest;
    private double min_balance;
    private double max_withdrawal_amount;
    SavingsAccount(String name, String accountNumber, double accountBalance, double min_balance)
    {
        super(name, accountNumber, accountBalance);
        this.min_balance= min_balance;
        this.interest=5;
        this.max_withdrawal_amount=super.getAccountBalance()-min_balance;

    }
    //setter
    // no setter for now
    //the user shouldn't be able to set interest  nor min balance which are decided by the bank
    // Implement getBalance() method.
    //This method will add the total interest to the accountBalance value and return the
    //value but it won’t change the accountBalance value.
    //getter
    public double getInterest()
    {
        return interest;
    }
    public double getMin_balance()
    {
        return min_balance;
    }
    // ig it should be private
    public  double getMax_withdrawal_amount()
    {
        return max_withdrawal_amount;
    }
    public double getBalance()
    {
        //return()
        return (getAccountBalance()+(getInterest()*getAccountBalance()/100));
    }
    public void withdraw(double withdrawal_amount)
    {
        //return()
        if(max_withdrawal_amount>=withdrawal_amount) {
            setAccountBalance(super.getAccountBalance() - withdrawal_amount);
            System.out.println("Withdrawed: "+ withdrawal_amount);
            return;
        }
        System.out.println("Withdrawal over the limit. This is not permissible");

    }
    public void display(String name, String accountNumber, double accountBalance, double min_balance, double max_withdrawal_amount, double interest)
    {
        System.out.println("name: "+name);
        System.out.println("account number: "+accountNumber);
        System.out.println("account balance: "+accountBalance);
        System.out.println("min_balance: "+min_balance);
        System.out.println("max_withdrawal: "+max_withdrawal_amount);
        System.out.println("interest: "+interest);
    }
}
