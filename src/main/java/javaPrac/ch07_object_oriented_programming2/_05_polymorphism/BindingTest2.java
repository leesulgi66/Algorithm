package javaPrac.ch07_object_oriented_programming2._05_polymorphism;

public class BindingTest2 {
    public static void main(String[] args) {
        Parent  p = new Child2();
        Child2 c = new Child2();

        System.out.println("p.x = "+p.x);
        p.method();
        System.out.println("c.x = "+c.x);
        c.method();
    }
}

class Child2 extends Parent {}
