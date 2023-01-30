package javaPrac.ch06_object_oriented_programming.primitive_type_and_reference_type;

public class ReferenceParamEx {
    public static void main(String[] args) {
        Data d = new Data();
        d.x = 10;
        System.out.println("main() : x = " + d.x);

        change(d);
        System.out.println("After change(d)");
        System.out.println("main() : x = " + d.x);
    }

    static void change(Data d) { // 참조형 매개변수
        d.x = 1000;
        System.out.println("change() : x = " + d.x);
    }

    // 1. change메서드가 호출되면서 참조변수 d의 값(주소)이 매개변수 d에 복사됨. 이제 매개변수 d에 저장된 주소값으로 x에 접근이 가능.
    // 2. change메서드에서 매개변수 d로 x의 값을 1000으로 변경
    // 3. change메서드가 종ㄹ되면서 매개변수 d는 스택에서 제거됨.
}
