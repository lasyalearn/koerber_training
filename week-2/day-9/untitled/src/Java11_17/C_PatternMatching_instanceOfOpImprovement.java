package Java11_17;

public class C_PatternMatching_instanceOfOpImprovement
{
    public static void main(String[] args)
    {
        Object a ="Koerber";
//        if(a instanceof String)
//        {
//            String s = (String) a;
//            System.out.println("a is a string: "+s);
//        }

        if(a instanceof String s)
        {
            System.out.println("a is a string: "+s);
        }

    }

}
