package lab_text;

import java.util.Comparator;

public class Merch implements Comparable<Merch>
{

    private String itemCode;
    private int quatity;
    private  double unitPrice;
    //getters
    Merch(String itemCode,int quatity,double unitPrice)
    {
        this.unitPrice=unitPrice;
        this.quatity=quatity;
        this.itemCode=itemCode;
    }
    public String getitemCode()
    {
        return itemCode;
    }
    public int getQuatity()
    {
        return quatity;
    }
    public double getUnitPrice()
    {
        return unitPrice;
    }
    //setters
    public void setitemCode(String itemCode)
    {
        this.unitPrice=unitPrice;
    }
    public void setQuatity(int quatity)
    {
        this.quatity=quatity;
    }
    public void setUnitPrice(double unitPrice)
    {
        this.unitPrice= unitPrice;
    }
    public String display() {
        return "Merch{" +
                "itemcode=" + itemCode +
                ", quantity='" + quatity + '\'' +
                ", unitprice='" +  unitPrice + '\'' +
                '}';
    }

    @Override
    //based on id
    public int compareTo(Merch o)
    {
        return CharSequence.compare(this.itemCode,o.itemCode);
    }
}
