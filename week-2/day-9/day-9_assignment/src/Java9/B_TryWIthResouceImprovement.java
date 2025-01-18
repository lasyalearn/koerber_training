package Java9;

import java.util.InputMismatchException;
import java.util.Scanner;

//try with resource
//this feature was introduced in java 7
// and enhanced in java 9 (multiple resources)
// classes with resource need be close like files or database connection
//hence we implement AutoCloseable
// which is an interface
class DoSideWork implements AutoCloseable
{
    public DoSideWork()
    {
        System.out.println("crt of DoSideWork");
    }
    void doSideWork()
    {
        System.out.println("doing side work");
    }
    @Override
    public void close() throws Exception
    {
        System.out.println("closing side work");
    }
}
class Work implements AutoCloseable
{
    public Work(){
        System.out.println("ctr of work");
    }
    void doWork(){
        System.out.println("doing main work");
    }

    @Override
    public void close() throws Exception
    {
        System.out.println("close ");
    }
}
public class B_TryWIthResouceImprovement
{
    public static void main(String[] args)
    {
        try
        {
            Work w=new Work();
            DoSideWork ds=new DoSideWork();
            w.doWork();
            ds.doSideWork();
            w.close();
            ds.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}