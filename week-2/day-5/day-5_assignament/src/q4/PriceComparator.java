package q4;

import java.util.Comparator;

public class PriceComparator implements Comparator<q4.Product>
{
    // ascending order
    // we can reverse o1 and o2 to get descending order
    //return Double.compare(o2.getProductPrice(), o1.getProductPrice());
    @Override
    public int compare(q4.Product o1, q4.Product o2) {
        return Double.compare(o1.getProductPrice(), o2.getProductPrice());
    }

}
