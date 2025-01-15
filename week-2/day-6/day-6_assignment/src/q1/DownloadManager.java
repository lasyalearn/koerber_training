package q1;

public class DownloadManager
{
    public static void download(String url){
        System.out.println(Thread.currentThread().getName()+" is starting download "+ url);
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" is done download "+ url);
    }
}
