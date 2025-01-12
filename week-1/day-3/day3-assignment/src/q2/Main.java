package q2;

public class Main
{
    public static void main(String[] args)
    {
        // the picture is stored in the src folder and named as picture.jpg
        //normal use of normal file read and write without buffer
        String str= "picture.jpg";
        long startTime_normal = System.currentTimeMillis();
        NormalFileReadWrite_withbuffer_withoutbuffer.NormalFileReadWrite(str);
        long endTime_normal = System.currentTimeMillis();
        System.out.println("Time taken file read and write without buffer:  "+(endTime_normal - startTime_normal)+"ms");


        //normal use of normal file read and write with buffer
        long startTime_normal_buffer = System.currentTimeMillis();
        NormalFileReadWrite_withbuffer_withoutbuffer.NormalFileReadWrite_buffer(str);
        long endTime_normal_buffer = System.currentTimeMillis();
        System.out.println("Time taken file read and write with buffer:  "+(endTime_normal_buffer - startTime_normal_buffer)+"ms");



        //use of  file input stream read and write in milliseconds
        long startTime_inputstream = System.currentTimeMillis();
        InputStreamFileReadWrite_withbuffer_withoutbuffer.InputStreamFileReadWrite(str);
        long endTime_inputstream = System.currentTimeMillis();
        System.out.println("Time taken file input stream read and  output stream write without buffer in ms:  "+(endTime_inputstream - startTime_inputstream)+"ms");



        //use of  file input stream read and write in nanoseconds without buffer
        long startTime_inputstream_ns = System.nanoTime();
        InputStreamFileReadWrite_withbuffer_withoutbuffer.InputStreamFileReadWrite(str);
        long endTime_inputstream_ns = System.nanoTime();
        System.out.println("Time taken file input stream read and  output stream write without buffer in ns:  "+(endTime_inputstream_ns - startTime_inputstream_ns)+"ns");



        //use of  file input stream read and write in nanoseconds with buffer
        long startTime_inputstream_ns_buffer = System.nanoTime();
        InputStreamFileReadWrite_withbuffer_withoutbuffer.InputStreamFileReadWrite_buffer(str);
        long endTime_inputstream_ns_buffer = System.nanoTime();
        System.out.println("Time taken file input stream read and  output stream write with buffer in ns:  "+(endTime_inputstream_ns_buffer - startTime_inputstream_ns_buffer)+"ns");

    }
}
