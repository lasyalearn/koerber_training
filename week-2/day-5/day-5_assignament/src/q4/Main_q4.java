package q4;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_q4
{
    public static void main(String[] args)
    {
        PriorityQueue<q4.Product> pq = new PriorityQueue<>(new PriceComparator());
        for(int i=0;i<5;i++)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter product id: ");
            int id = sc.nextInt();
            System.out.println("Enter product name: ");
            String name = sc.next();
            System.out.println("Enter product price: ");
            double price = sc.nextDouble();
            q4.Product product = new q4.Product(id,name,price);
            pq.add(product);

        }
        System.out.println(pq);

    }
}
