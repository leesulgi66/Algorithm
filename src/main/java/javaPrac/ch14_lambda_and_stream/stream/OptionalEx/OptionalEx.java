package javaPrac.ch14_lambda_and_stream.stream.OptionalEx;

import java.util.Optional;

public class OptionalEx {
    public static void main(String[] args) {
//        int[] arr = null;
        int[] arr = new int[0];
        System.out.println("arr.length = "+arr.length);

//        Optional<String> opt = null;    // 사용은 가능. 하지만 바람직한 코드는 X
        Optional<String> opt = Optional.empty();
//        Optional<String> opt = Optional.of("acb");
        System.out.println("opt = "+opt);
//        System.out.println("opt = "+opt.get());   // .get()은 잘 사용하지 않는다. (NoSuchElementException)

        String str = "";

//        try {
//            str = opt.get();
//        } catch (Exception e) {
//            str = "";   // 예외가 발생하면 빈문자열("")로 초기화
//        }

        str = opt.orElse("EMPTY");   // Optional에 저장된 값이 null이면 ""반환
        str = opt.orElseGet(()->new String());   // Optional에 저장된 값이 null이면 ""반환
//        str = opt.orElseGet(String::new);  // 메서드 참조
        System.out.println("str = "+str);
    }
}
