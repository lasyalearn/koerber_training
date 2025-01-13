package lab_test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

import static java.util.Collections.sort;

public class Main
{
    public static void main(String[] args) throws IOException {
        ArrayList<Merch> list=new ArrayList<Merch>();
        BufferedReader br= new BufferedReader(new FileReader(new File("data.txt")));
        String line;
        while((line=br.readLine())!=null)
        {
            String arr[]=line.split(" ");
            Merch merch= new Merch(arr[0], Integer.parseInt(arr[1]),Double.parseDouble(arr[2]));
            list.add(merch);
        }
        for (Merch merch: list)
        {
            String s=merch.display();
            System.out.println(s);
        }
        //sort by  ascending names
        System.out.println(" sorted at ascending id");
        Collections.sort(list);
        for (Merch merch: list)
        {
            String s=merch.display();
            System.out.println(s);
        }
        System.out.println(" sorted at ascending id");
        Collections.sort(list, new Sortbyprice());
        for (Merch merch: list)
        {
            String s=merch.display();
            System.out.println(s);
        }




    }
}
