package lab_test;

import java.util.Comparator;

public class Sortbyprice implements Comparator<Merch>
{
    @Override
    public int compare(Merch o1, Merch o2) {
        return Double.compare(o2.getUnitPrice(),o1.getUnitPrice());
    }


}
