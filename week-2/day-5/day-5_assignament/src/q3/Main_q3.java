package q3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main_q3
{
    public static void main(String[] args)
    {
        ArrayList<Double> Numbers = new ArrayList<>();
        try(BufferedReader br= new BufferedReader(new FileReader(new File("data.txt"))))
        {
            String line;
            while((line=br.readLine())!=null)
            {
                Numbers.add(Double.parseDouble(line));
            }
            Numbers.sort(Collections.reverseOrder());
            System.out.println(Numbers.getFirst());

        }catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
