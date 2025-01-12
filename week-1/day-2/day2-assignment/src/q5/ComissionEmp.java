package q5;


public class ComissionEmp extends Emp
{
    private double a;
    private double sales_per_week;
    ComissionEmp(String employee_name, int employee_id, double a, double sales_per_week)
    {
        super(employee_name, employee_id);
        this.a=a;
        this.sales_per_week=sales_per_week;
    }
    @Override
    public double getPayment() {
        return a * sales_per_week / 100;
    }
}
