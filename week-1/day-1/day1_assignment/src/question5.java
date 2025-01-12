import java.util.Scanner;

public class question5
{
    public static class Date
    {
        private int dd;
        private int mm;
        private int yyyy;
        Date(int dd, int mm, int yyyy)
        {
            this.dd=dd;
            this.mm=mm;
            this.yyyy=yyyy;
        }
        public void displayPresentDate()
        {
            System.out.println(this.dd+"/"+this.mm+"/"+this.yyyy);
        }
        private boolean isLeap(int yyyy)
        {
            if ((yyyy % 400 == 0 || yyyy % 100 != 0) && (yyyy % 4 == 0))
                return true;
            else
                return false;

        }
        public void displayNextDate(int dd,int mm, int yyyy)
        {
            dd=dd+1;
            int[] arr={-1,31,28,31,30,31,30,31,31,30,31,30,31};
            if(isLeap(yyyy))
            {
                arr[2]=29;//hey no of days in feb is 29 if it is a leap year
            }
            if(dd>arr[mm])
            {
                dd=1;
                mm=mm+1;
                if(mm>12)
                {
                    mm=1;
                    yyyy++;
                }
            }
            System.out.println("next date: " + dd + "/" + mm + "/" + yyyy);

        }

    }
    public static void  main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the date: ");
        int dd= scanner.nextInt();
        System.out.println("Enter the month: ");
        int mm= scanner.nextInt();
        System.out.println("Enter the year: ");
        int yyyy= scanner.nextInt();
        Date date1= new Date(dd,mm,yyyy);
        date1.displayPresentDate();
        date1.displayNextDate(dd,mm,yyyy);

    }
}
