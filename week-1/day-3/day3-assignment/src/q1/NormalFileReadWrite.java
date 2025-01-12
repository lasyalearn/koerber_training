package q1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NormalFileReadWrite
{
    // fileread is done by char type
    // hence suited for text files and not for char
    // hence the picture1 i was unable to open
    // it comes asa file format unsupported
    public static void NormalFileReadWrite(String fileName)
    {
        // since the FileReader  not need to be closed
        //  no need ARM
        try
        {
            FileReader fr=new FileReader(fileName);
            FileWriter fw=new FileWriter("picture1.jpg");
            int ch;
            while((ch=fr.read())!=-1)
            {
                fw.write(ch);
            }
        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
