package javaPrac.ch07_object_oriented_programming2._07_interface.interface_test3;

public class InterfaceTest3 {
    public static void main(String[] args) {
        A a = new A();
        a.methodA();
    }
}

class A {
    void methodA() {
        I i = InstanceManager.getInstance();    // 제3의 클래스의 메서드를 통해서 인터ㅔ이스 I를 구현한 클래스의 인스턴스를 얻어온다.
        i.methodB();
        System.out.println(i.toString());       // i로 Object클래스의 메서드 호출가능
    }
}

interface I {
    public abstract void methodB();
}

class B implements I {
    @Override
    public void methodB() {
        System.out.println("methodB in B class");
    }

    public String toString() { return "class B"; }
}

class InstanceManager {
    public static I getInstance() {
        return new B();
    }
}