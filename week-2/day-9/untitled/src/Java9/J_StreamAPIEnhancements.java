package Java9;

import java.util.List;

public class J_StreamAPIEnhancements
{
    public static void main(String[] args) {
        //takewhile
        System.out.println("takewhile");
        List<Integer > list=List.of(4,6,8,9,50);
        // list.stream().filter(n->n%2==0).forEach(n-> System.out.println(n));
        list.stream().takeWhile(n->n%2==0).forEach(n-> System.out.println(n));

        //	dropwhile
        System.out.println("dropwhile");
        list.stream().dropWhile(n->n%2==0).forEach(n-> System.out.println(n));
        //	Stream.iteate (enhanced)
        //Stream.iterate(1, x->x+1).limit(5).forEach(x-> System.out.println(x));// what if somebody forget to call limit(5)
        //Stream.iterate(1, x->x<=5, x->x+1).forEach(n-> System.out.println(n));
    }
}
