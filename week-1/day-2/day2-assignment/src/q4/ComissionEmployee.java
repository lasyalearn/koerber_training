package q4;

public class ComissionEmployee extends Employee
{
    private double a;
    private double sales_per_week;
    ComissionEmployee(String employee_name, int employee_id,double a, double sales_per_week)
    {
        super(employee_name, employee_id);
        this.a=a;
        this.sales_per_week=sales_per_week;
    }
    @Override
    public void increase_salary(double percent)
    {
        a=a+(a*percent/100);
    }
    @Override
    void weekly_salary()
    {
        System.out.println("The weekly salary of a comission employee is: "+(a*sales_per_week/100));
    }


}
