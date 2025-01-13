package q3;

import java.io.Serializable;
// serialization is  heavy for JVM
//hence we use marker interface to info JVM that it should expect serialization
//if not mentioned then NotSerializableException will be thrown
public class Employee implements Serializable
{
    private int id;
    private String name;
    private Address address;
    private double salary;

    public Employee(int id,String name,Address address, double salary)
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
    public void  getAddress()
    {
        System.out.println(address.getCity());
        System.out.println(address.getState());
        System.out.println(address.getCountry());
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
    public void setAddress(Address address)
    {

    }
    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public String display() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address.getCity()+" " + address.getState()+ " " + address.getCountry() + '\'' +
                ", salary=" + salary +
                '}';
    }
}
