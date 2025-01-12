import java.util.Scanner;
public class question3
{

    public static int[] copyOf(int[] array)
    {
        int[] arr_copy;
        arr_copy= new int[array.length];
        for(int i=0;i<array.length;i++)
        {
            arr_copy[i]=array[i];
        }
        return arr_copy;
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of the of the array to be copied: ");
        int n= scanner.nextInt();
        int[] arr;
        arr= new int[n];
        int[] arr_copy;
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the element of copy array: ");
            int ele= scanner.nextInt();
            arr[i]=ele;
        }
        arr_copy=copyOf(arr);
        for(int ele:arr_copy)
        {
            System.out.println(ele);
        }

    }
}
