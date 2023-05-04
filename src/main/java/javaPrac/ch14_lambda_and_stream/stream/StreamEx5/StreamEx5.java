package javaPrac.ch14_lambda_and_stream.stream.StreamEx5;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx5 {
    public static void main(String[] args) {
        String[] strArr = {
                "Inheritance", "Java", "Lambda", "stream",
                "OptionalDouble", "IntStream", "count", "sum"
        };

        Stream.of(strArr)
                .parallel() // 병렬로 처리
                .forEach(System.out::println); // 병렬로 처리시 순서보장x 원한다면 forEachOrdered를 사용(속도는 낮아진다)

        boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);
        Optional<String> sWord = Stream.of(strArr)
                .filter(s->s.charAt(0)=='s').findFirst();
        System.out.println("noEmptyStr = "+noEmptyStr);
        System.out.println("sWord = "+sWord.get());

        // Stream<String>을 Stream<Integer>으로 변환   (s) -> s.length()
        Stream<Integer> integerStream = Stream.of(strArr).map(String::length);

        // Stream<String[]>을 IntStream으로 변한.  IntStream기본형 스트림(성능 향상을 위해 사용)
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        int count = intStream1.reduce(0, (a,b) -> a +1);
        int sum = intStream2.reduce(0, (a,b) -> a+b);

        OptionalInt max = intStream3.reduce(Integer::max);  // count, sum과 달리 Optional로 다루는 이유는 초기값(identity)이 없기 때문에 null이 발생할 수 있기 때문.
        OptionalInt min = intStream4.reduce(Integer::min);
        System.out.println("count = "+count);
        System.out.println("sum = "+sum);
        System.out.println("max = "+max.getAsInt());
        System.out.println("min = "+min.getAsInt());
    }
}
