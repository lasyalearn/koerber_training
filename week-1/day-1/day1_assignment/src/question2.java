import java.util.Scanner;

public class question2
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int n= scanner.nextInt();
        int[] arr;
        arr= new int[n];
        int counter=0;
        while(counter != n)
        {
            System.out.println("Enter the marks");
            int mark= scanner.nextInt();
            if(mark>=0 && mark <=100)
            {
                arr[counter]=mark;
                counter++;
            }
            else {
                System.out.println("Entered marks are invalid");
                System.out.println("try again");
            }
        }
        int sum=0;
        for(int ele:arr)
        {
            sum=sum+ele;
        }
        System.out.println(sum/n);
    }
}
