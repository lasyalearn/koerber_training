package q1;

public class Main
{
    public static void main(String[] args)
    {
        // the picture is stored in the src folder and named as picture.jpg
        //normal use of normal file read and write
        String str= "picture.jpg";
        long startTime_normal = System.currentTimeMillis();
        NormalFileReadWrite.NormalFileReadWrite(str);
        long endTime_normal = System.currentTimeMillis();
        System.out.println("Time taken: "+(endTime_normal - startTime_normal)+"ms");
        //use of  file input stream read and write in milliseconds
        long startTime_inputstream = System.currentTimeMillis();
        InputStreamFileReadWrite.InputStreamFileReadWrite(str);
        long endTime_inputstream = System.currentTimeMillis();
        System.out.println("Time taken: "+(endTime_inputstream - startTime_inputstream)+"ms");
        //use of  file input stream read and write in nanoseconds
        long startTime_inputstream_ns = System.nanoTime();
        InputStreamFileReadWrite.InputStreamFileReadWrite(str);
        long endTime_inputstream_ns = System.nanoTime();
        System.out.println("Time taken: "+(endTime_inputstream_ns - startTime_inputstream_ns)+"ns");


    }
}
