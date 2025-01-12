package q5;


public class SalariedEmp extends Emp
{
    private double salary_per_week;

    SalariedEmp(String employee_name, int employee_id,double salary_per_week)
    {
        super(employee_name, employee_id);
        this.salary_per_week=salary_per_week;
    }
    @Override
    public double getPayment() {
        return salary_per_week;
    }
}
