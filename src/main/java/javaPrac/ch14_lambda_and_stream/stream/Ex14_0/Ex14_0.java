package javaPrac.ch14_lambda_and_stream.stream.Ex14_0;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex14_0 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> intStream = list.stream();  // list를 데이터 소스로 하는 스트림을 생성
        intStream.forEach(System.out::print);
//        intStream.forEach(System.out::print);  // 최종연산 후에 스트림이 닫히기 때문에 다시 호출하려고 하면 에러가난다.

        // stream은 1회용
        intStream = list.stream();  // 한번 더 출력 하려면 스트림을 다시 생성해야 한다.
        intStream.forEach(System.out::print);
        System.out.println();

        String[] strArr = {"a", "b", "c", "d"};
        Stream<String> strStream = Stream.of("a", "b", "c");
        Stream<String> strStream2 = Stream.of(new String[]{"a", "b", "c"});
        Stream<String> strStream3 = Stream.of(strArr);
        Stream<String> strStream4 = Arrays.stream(strArr);
        strStream.forEach(System.out::println);

        int[] intArr = {1,2,3,4,5};
        IntStream intStream1 = Arrays.stream(intArr);   // 기본형 스트림(연산 가능한 .sum(), average() 메서드가 있고, 오토방싱의 제거로 속도도 향상된다.)
//        intStream1.forEach(System.out::println);
//        System.out.println("count = "+intStream1.count());
//        System.out.println("count = "+intStream1.sum());
        System.out.println("count = "+intStream1.average());

        Integer[] intArr2 = {1,2,3,4,5};
        Stream<Integer> intStream2 = Arrays.stream(intArr2); // Integer객체 스트림
//        intStream2.forEach(System.out::println);
        System.out.println("count = "+intStream2.count());
        System.out.println();

//        IntStream intStream3 = new Random().ints(); // 무한 스트림
//        IntStream intStream3 = new Random().ints(5); // 난수의 size
        IntStream intStream3 = new Random().ints(5, 10); // 난수의 범위(마지막 범위는 제외 5~9)
        intStream3
                .limit(5)
                .forEach(System.out::println);

        // 특정 범위의 정수를 요소로 갖는 스트림 생성
        IntStream intStream4 = IntStream.range(1, 5);       // 1,2,3,4
        IntStream intStream5 = IntStream.rangeClosed(1, 5); // 1,2,3,4,5

        // 람다식을 이용한 Stream - iterate(), generate()  * 기본적으로 무한 스트림!
        // iterate(T seed, UnaryOperator f) 단항 연산자
        Stream<Integer> intStream6 = Stream.iterate(0, n -> n + 2); // iterrate()는 seed값이 필요
        intStream6.limit(10).forEach(System.out::println);

        // generate(Supplier s) : 주기만 하는것. 입력x, 출력o
        Stream<Integer> oneStream = Stream.generate(()->1);             // generate()는 seed값이 불필요
        oneStream.limit(10).forEach(System.out::println);
    }
}
