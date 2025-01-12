package q3;

import java.io.Serializable;
// serialization is  heavy for JVM
//hence we use marker interface to info JVM that it should expect serialization
//if not mentioned then NotSerializableException will be thrown
public class Employee implements Serializable
{
    private int id;
    private String name;
    private String address;
    private double salary;

    public Employee(int id,String name,String address, double salary)
    {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.id = id;
    }
    //getters
    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getAddress()
    {
        return address;
    }
    public double getSalary()
    {
        return salary;
    }
    //setters
    public void setId(int id)
    {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public String display() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }
}
