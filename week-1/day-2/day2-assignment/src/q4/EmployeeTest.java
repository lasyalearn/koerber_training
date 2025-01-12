package q4;

import java.util.ArrayList;
public class EmployeeTest
{
    public static void main(String[] args)
    {
        // we can't create a class of an abstract class
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new SalariedEmployee("Koerber1", 1,2000));
        employees.add(new HourlyEmployee("Koerber2", 2, 40,10));
        employees.add(new ComissionEmployee("koerber3", 3, 10, 20));


        System.out.println("Weekly Salaries of Employees:");
        for (Employee employee : employees) {
            Payment_process.get_salary(employee);
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("\nIncreasing salaried employee salaries by 10%...");
        for (Employee employee : employees) {
            Payment_process.increased_salary(10,employee);
        }
        Payment_process.increased_salary(10, employees.get(0));
        System.out.println("Weekly Salaries of Employees:");
        for (Employee employee : employees) {
            Payment_process.get_salary(employee);
        }



    }

}
