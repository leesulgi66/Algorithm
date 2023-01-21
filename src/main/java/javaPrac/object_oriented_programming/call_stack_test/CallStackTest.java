package javaPrac.object_oriented_programming.call_stack_test;

public class CallStackTest {
    public static void main(String[] args) {
        firstMethod();
    }

    static void firstMethod() {
        secondMethod();
    }

    static void secondMethod() {
        System.out.println("secondMethod()");
    }
}
