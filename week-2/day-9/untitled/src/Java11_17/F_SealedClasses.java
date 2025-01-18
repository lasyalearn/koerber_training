package Java11_17;


sealed class  Animal permits Dog, Cat
{
    void sound()
    {
        System.out.println();
    }
}
non-sealed class Dog extends Animal
{
    @Override
    void sound()
    {
        System.out.println("bark");
    }
}
final class Cat extends Animal
{
    @Override
    void sound()
    {
        System.out.println("meow");
    }
}
class Human extends Dog
{
    @Override
    void sound()
    {
        System.out.println("hello");
    }

}
public class F_SealedClasses
{
    public static void main(String[] args)
    {
        Animal h = new Human();
        h.sound();
        Animal d = new Dog();
        d.sound();
        Animal c = new Cat();
        c.sound();

    }
}