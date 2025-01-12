import java.util.Scanner;

public class question4 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int a[][];
        a = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                if(j==0 || j==i)
                {
                    a[i][j]=1;
                }
                else
                {
                    a[i][j]=a[i-1][j-1]+a[i-1][j];
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for (int j = 0; j <= i; j++)
            {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
