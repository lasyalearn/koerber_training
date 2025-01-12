package q2;

import java.io.*;

public class NormalFileReadWrite_withbuffer_withoutbuffer
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
    public static void NormalFileReadWrite_buffer(String fileName)
    {
        // since the FileReader  not need to be closed
        //  no need ARM
        try
        {
            FileReader fr=new FileReader(fileName);
            BufferedReader br=new BufferedReader(fr);
            FileWriter fw=new FileWriter("picture10.jpg");
            BufferedWriter bw=new BufferedWriter(fw);
            int ch;
            while((ch=br.read())!=-1)
            {
                bw.write(ch);
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
