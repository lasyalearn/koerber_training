package q5;

class Invoice implements Payable
{
    private String partNum;
    private  String partDescription;
    private int quality;
    private double pricePerItem;
    Invoice(String partNum, String partDescription, int quality, double pricePerItem)
    {
        this.partNum=partNum;
        this.partDescription=partDescription;
        this.quality=quality;
        this.pricePerItem=pricePerItem;
    }
    //setter
    public void setPartNum(String partNum)
    {
        this.partNum=partNum;
    }
    public void setPartDescription(String partDescription)
    {
        this.partDescription=partDescription;
    }
    public void setQuality(int quality)
    {
        this.quality=quality;
    }
    public void setPricePerItem()
    {
        this.pricePerItem=pricePerItem;
    }
    //getter
    public String getPartNum()
    {
        return partNum;
    }
    public String getPartDescription()
    {
        return partDescription;
    }
    public int getQuality()
    {
        return quality;
    }
    public double getPricePerItem()
    {
        return pricePerItem;
    }
    @Override
    public String toString()
    {

        System.out.println("part number: "+partNum);
        System.out.println("part description: "+partDescription);
        System.out.println("quality: "+quality);
        System.out.println("pricePerItem: "+pricePerItem);
        return null;
    }
    @Override
    public double getPayment()
    {
        return quality*pricePerItem;
    }
}
