package q5;

public class HourlyEmp extends Emp
{
    private int no_of_hours;
    private double price_per_hour;

    HourlyEmp(String employee_name, int employee_id,int no_of_hours,double price_per_hour)
    {
        super(employee_name, employee_id);
        this.no_of_hours=no_of_hours;
        this.price_per_hour=price_per_hour;
    }
    @Override
    public double getPayment() {
        return no_of_hours*price_per_hour;
    }
}
