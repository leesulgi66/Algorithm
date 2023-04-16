package javaPrac.ch12_generics_enumeration_annotation._03_annotation;

public class Parent {
    void parentMethod() {}
}

class Child extends Parent {
    @Override
//    void parentmethod() {}
    void parentMethod() {}
}
