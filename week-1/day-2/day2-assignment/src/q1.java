public class q1
{
    static class Employee
    {
        private int id;
        private String firstName;
        private String lastName;
        private int salary;
        Employee(int id, String firstName , String lastName, int salary )
        {
            this.firstName=firstName;
            this.id=id;
            this.lastName=lastName;
            this.salary=salary;
        }
        public int getID()
        {
            return id;
        }
        public String getFirstName()
        {
            return firstName;
        }
        public String getLastName()
        {
            return lastName;
        }
        public String getName()
        {
            return (firstName+lastName);
        }
        public int getSalary()
        {
            return salary;
        }
        public void setSalary(int salary_new)
        {
            this.salary=salary_new;
        }
        public int getAnnualSalary()
        {
            return (salary*12);
        }
        public int raiseSalary(int percent)
        {
            return (salary+(salary*percent/100));
        }
        public String toString()
        {
            return ("Employee"+"[id= "+id+" name= "+firstName+" "+ lastName+",salary= "+salary+"]");
        }
    }
    public static void main(String[] args)
    {
        Employee employee= new Employee(1, "lasya", "koerber", 50000);

        employee.raiseSalary(20);
        System.out.println(employee);
    }
}
