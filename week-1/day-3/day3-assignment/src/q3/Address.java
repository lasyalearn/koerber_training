package q3;

public class Address implements java.io.Serializable
{
    private String city;
    private String state;
    private String country;

    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    //getters
    public String getCity()
    {
        return city;
    }
    public String getState()
    {
        return state;
    }
    public String getCountry()
    {
        return country;
    }
    //setters
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    @Override
    public String toString() {
        return "Address{" +
                "city=" + city +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

}
