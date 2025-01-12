package q5;

abstract public class Emp implements Payable
{
    private String employee_name;
    private int employee_id;
    Emp(String employee_name, int employee_id)
    {
        this.employee_id=employee_id;
        this.employee_name=employee_name;
    }
    public String toString() {
        return ("Employee id: " + employee_id + ", name: " + employee_name );
    }
    abstract public double getPayment();

}