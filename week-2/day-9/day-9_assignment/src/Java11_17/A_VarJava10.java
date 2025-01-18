package Java11_17;

import java.util.ArrayList;

public class A_VarJava10
{
    // var in java is like auto in c++
    public static void main(String[] args)
    {
        //var take the type of the variable
        //but it should be able to predict the type
        var Array = new ArrayList<String>();
        Array.add("a");
        Array.add("b");
        Array.add("c");
        Array.add("d");
        Array.add("e");
        Array.add("f");
        Array.forEach(System.out::println);

    }
}
