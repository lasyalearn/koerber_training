public class question1
{

    static int sum=0;
    public  static void Fib_series(int a, int b,int n)
    {
        if(n==0)
        {
            return;
        }
        int temp=a+b;
        a=b;
        b=temp;
        sum=sum+b;
        System.out.println(" "+b);
        Fib_series(a,b,n-1);
    }
    public static void main(String[] args)
    {
        // Write a program called Fibonacci to display the first 20 Fibonacci numbers F(n),
        //where F(n)=F(n–1)+F(n–2) and F(1)=F(2)=1. Also compute their average.
        int n=20;
        int a=0;
        int b=1;
        System.out.println(a+" "+b);
        sum=a+b;
        n=n-1;
        Fib_series(0,1,n);
        System.out.println(sum/20.0);

    }
}
