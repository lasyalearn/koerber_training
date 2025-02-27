package q1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
public class FileUtil
{
    public static List<String> readFiles(String fileName)
    {
        List<String> files=new ArrayList<>();

        try(BufferedReader br=new BufferedReader(new FileReader(fileName))){
            String line=null;
            while ((line=br.readLine())!=null){
                files.add(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return files;
    }
}
