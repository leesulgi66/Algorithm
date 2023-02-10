package javaPrac.ch07_object_oriented_programming2._08_inner_class.anonymous_class;

public class InnerEx6 {
    Object iv = new Object() { void method() {}};         // 익명 클래스
    static Object cv = new Object() { void method() {} }; // 익명 클래스

    void myMethod() {
        Object lv = new Object() { void method() {} };    // 익명 클래스
    }
}
