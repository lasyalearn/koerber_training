package q1;

import java.util.List;

public class DemoFileDownlade
{
    public static void main(String[] args) {
        List<String> urls=FileUtil.readFiles("data.txt");

//        for(String url: urls){
//            DownloadManager.download(url);
//        }
        for(String url: urls)
        {
            FileDownloadTask downloadTask=new FileDownloadTask(url);
            Thread thread=new Thread(downloadTask);
            thread.start();
        }
    }
}
