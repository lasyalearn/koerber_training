package q5;

public class q5_test
{
    public static void main(String[] args)
    {
        Emp employee = new SalariedEmp("koerber",1,2000);
        Invoice invoice =new Invoice("KSC058","Software", 100,50);
//        double salaried_get_payment=employee.getPayment();
//        System.out.println("salaried_get_payment: "+salaried_get_payment);
//        double invoice_get_payment=invoice.getPayment();
//        System.out.println("invoice_get_payment: "+invoice_get_payment);
        Payment_process.get_salary(employee);
        Payment_process.get_salary(invoice);

    }
}
