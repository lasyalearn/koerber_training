package q4;

public class HourlyEmployee extends Employee
{
    private int no_of_hours;
    private double price_per_hour;

    HourlyEmployee(String employee_name, int employee_id,int no_of_hours,double price_per_hour)
    {
        super(employee_name, employee_id);
        this.no_of_hours=no_of_hours;
        this.price_per_hour=price_per_hour;
    }
    @Override
    public void increase_salary(double percent)
    {
        price_per_hour=price_per_hour+(price_per_hour*percent/100);
    }

    @Override
    void weekly_salary()
    {
        System.out.println("The weekly salary of a hourly employee is: "+no_of_hours*price_per_hour);
    }


}
