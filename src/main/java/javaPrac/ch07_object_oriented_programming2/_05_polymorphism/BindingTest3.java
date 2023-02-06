package javaPrac.ch07_object_oriented_programming2._05_polymorphism;

public class BindingTest3 {
    public static void main(String[] args) {
        Parent p = new Child3();
        Child3 c = new Child3();

        System.out.println("p.x = "+ p.x);
        p.method();
        System.out.println();
        System.out.println("c.x = " + c.x);
        c.method();
    }
}

class Child3 extends Parent{
    int x = 200;

    void method() {
        System.out.println("x = " +x);  // this.x와 같다
        System.out.println("super.x = " + super.x);
        System.out.println("this.x = " + this.x);
    }
}
