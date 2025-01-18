package Java9;

import  java.util.*;
//class Foo{
//    @SafeVarargs
//    public Foo(int ...list){
//
//    }
//    @SafeVarargs
//   static public void foo1(int ...list){
//
//    }
//
//    @SafeVarargs        //why only final method?
//    final public void foo2(int ...list){
//
//    }
//    @SafeVarargs        //why only final method?
//     private void foo3(int ...list){
//
//    }
//
//}
public class D_SafeVarargsDemo {
    public static void main(String[] args) {
        List<String> l1=Arrays.asList("A","B");
        List<String> l2=Arrays.asList("M","X");
        foo(l1, l2);

    }

    // this method is not safe
    // as we have object type
    // we aren't doing anything wrong
    // but still we get a warning they it can go wrong(class cast exception)
    // we supperress the warning
    //by using SafeVarargs annotation
    @SafeVarargs
    private static void foo(List<String> ...list) {
        for(List<String> data: list)
        {
            System.out.println(data);
        }
        //the class cast exception
        //---> intially at index there is string
        //---> now it has integer
        // hence we get class cast exception
//        Object[] oList=list;
//        oList[0]=Arrays.asList(12,22);//heap polluation
//        String name=list[0].get(0);
//        System.out.println(name);
    }
}