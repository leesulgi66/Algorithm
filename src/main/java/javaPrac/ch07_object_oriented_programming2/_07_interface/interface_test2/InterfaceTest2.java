package javaPrac.ch07_object_oriented_programming2._07_interface.interface_test2;

class A {
    void autoPlay(I i) {
        i.play();
    }
}

interface I {
    public abstract void play();
}

class B implements I {
    public void play() {
        System.out.println("play in B class");
    }
}

class C implements I {
    public void play() {
        System.out.println("play in C class");
    }
}

public class InterfaceTest2 {
    public static void main(String[] args) {
        A a = new A();
        a.autoPlay(new B());    // void autoPlay(I i)호출
        a.autoPlay(new C());    // void autoPlay(I i)호출
    }
}
