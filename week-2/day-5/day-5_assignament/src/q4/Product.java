package q4;

import java.util.Comparator;

public class Product
{
    private int productId;
    private String productName;
    private double productPrice;

    public Product(int productId, String productName, double productPrice)
    {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }
    //getters
    public int getProductId()
    {
        return productId;
    }
    public String getProductName()
    {
        return productName;
    }
    public double getProductPrice()
    {
        return productPrice;
    }
    //setters
    public void setProductId(int productId)
    {
        this.productId = productId;
    }
    public void setProductName(String productName)
    {
        this.productName = productName;
    }
    public void setProductPrice(double productPrice)
    {
        this.productPrice = productPrice;
    }
    @Override
    public String toString()
    {
        return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice + "]";
    }
}
