package q2;

import java.io.*;

public class InputStreamFileReadWrite_withbuffer_withoutbuffer
{
    // fileinputstreamread is done by byte type
    // suited for videos and pictures
    // hence the picture2 i was able to open
    public static void InputStreamFileReadWrite_buffer(String fileName)
    {
        try
        {
            FileInputStream fr=new FileInputStream(fileName);
            BufferedInputStream br=new BufferedInputStream(fr);
            FileOutputStream fw=new FileOutputStream("picture2.jpg");
            BufferedOutputStream bw=new BufferedOutputStream(fw);
            int ch;
            while((ch=br.read())!=-1)
            {
                bw.write(ch);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // with bufferedinputstream
    public static void InputStreamFileReadWrite(String fileName)
    {
        try
        {
            FileInputStream fr=new FileInputStream(fileName);
            FileOutputStream fw=new FileOutputStream("picture20.jpg");
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
}
