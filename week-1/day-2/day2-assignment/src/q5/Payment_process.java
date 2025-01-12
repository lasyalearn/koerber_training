package q5;

class Payment_process
{

     public static void get_salary(Payable payable)
     {
          double ans= payable.getPayment();
          System.out.println("Payment: "+ans);
     }
}
