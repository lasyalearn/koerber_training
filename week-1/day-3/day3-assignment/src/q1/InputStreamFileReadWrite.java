package q1;

import java.io.*;

public class InputStreamFileReadWrite
{
    // fileinputstreamread is done by byte type
    // suited for videos and pictures
    // hence the picture2 i was able to open
    public static void InputStreamFileReadWrite(String fileName)
    {
        try
        {
            FileInputStream fr=new FileInputStream(fileName);
            FileOutputStream fw=new FileOutputStream("picture2.jpg");
            int ch;
            while((ch=fr.read())!=-1)
            {
                fw.write(ch);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // what is the difference between InputStreamFileReadWrite and NormalFileReadWrite?
    //
}
