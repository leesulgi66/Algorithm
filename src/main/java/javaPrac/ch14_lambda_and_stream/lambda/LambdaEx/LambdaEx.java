package javaPrac.ch14_lambda_and_stream.lambda.LambdaEx;

import java.util.function.*;

public class LambdaEx {
    public static void main(String[] args) {
//        Function<String, Integer> f = (String s) -> Integer.parseInt(s);
//        Function<String, Integer> f = 클래스이름::메서드이름;
        Function<String, Integer> f = Integer::parseInt;  // 메서드 참조
//        Function<String, Integer> f = (String s) -> Integer.parseInt(s); 메서드 참조 -> 람다식변환 생각하기
        System.out.println(f.apply("100")+200);     // 문자열이 숫자로 잘 변했다면 값은 300
        System.out.println();

        // Supplier는 입력X, 출력O
//        Supplier<MyClass> s = () -> new MyClass();
//        Supplier<MyClass> s = () -> 클래스이름::메서드이름;
        Supplier<MyClass> s = MyClass::new; // 메서드 참조

//        Function<Integer, MyClass2> f2 = (i) -> new MyClass2(i);
        Function<Integer, MyClass2> f2 = MyClass2::new; // 메서드 참조

        MyClass mc = s.get();
        System.out.println(mc);
        System.out.println(s.get());
        System.out.println();

        MyClass2 mc2 = f2.apply(100);
        System.out.println(mc2.iv);
        System.out.println();


//        Function<Integer, int[]> f3 = (i) -> new int[i];
        Function<Integer, int[]> f3 = int[]::new;   // 메서드 참조
        System.out.println(f3.apply(10).length);
    }
}

class MyClass {}

class MyClass2 {
    int iv;

    MyClass2(int iv) {
        this.iv = iv;
    }
}
