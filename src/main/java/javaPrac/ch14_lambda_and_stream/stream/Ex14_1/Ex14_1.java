package javaPrac.ch14_lambda_and_stream.stream.Ex14_1;

import java.util.stream.IntStream;

public class Ex14_1 {
    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(1, 10);                // 12345678910
        intStream.skip(3).limit(5).forEach(System.out::print);  // 45678
        System.out.println();

        intStream = IntStream.of(1,2,2,3,3,3,4,5,5,6);
        intStream.distinct().forEach(System.out::print);                   // 123456
        System.out.println();

        intStream = IntStream.rangeClosed(1, 10);                          // 12345678910
        intStream.filter(i->i%2==0).forEach(System.out::print);            // 246810
        System.out.println();

        intStream = IntStream.rangeClosed(1, 10);
        intStream.filter(i->i%2!=0 && i%3!=0).forEach(System.out::print);  // 157
//        intStream.filter(i->i%2!=0).filter(i->i%3!=0).forEach(System.out::println); //위의 식과 같다
        System.out.println();
    }
}
