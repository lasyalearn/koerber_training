package q1;

import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Map<String,Integer> mp= new HashMap<>();
        try(BufferedReader br =new BufferedReader(new FileReader(new File("story.txt"))))
        {
            String line;
            while((line=br.readLine())!=null)
            {
                String[] words=line.split("[ ,?./';!@#$%^&*()\\-]");
                for(String word:words)
                {
                    if(mp.containsKey(word))
                    {
                        mp.put(word,(mp.get(word)+1));
                    }
                    else
                    {
                        mp.put(word,1);
                    }
                }
            }

        }catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        Set<Map.Entry<String,Integer>> set = mp.entrySet();
        for(Map.Entry<String,Integer> entry:set)
        {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
//        BufferedReader br = new BufferedReader(new FileReader(new File("story.txt")));
//        String line;
//        while((line=br.readLine())!=null)
//        {
//            System.out.println(line);
//        }

    }
}
