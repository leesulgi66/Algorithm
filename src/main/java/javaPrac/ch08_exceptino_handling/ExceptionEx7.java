package javaPrac.ch08_exceptino_handling;

public class ExceptionEx7 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try {
            System.out.println(3);
            System.out.println(0/0);
            System.out.println(4);  // 실행되지 않는다.
        }catch(ArithmeticException ae) {
            if(ae instanceof ArithmeticException)
                System.out.println("true");
            System.out.println("ArithmeticException");
        }catch(Exception e) {   // ArithmeticException을 제외한 모든 예외가 처리된다.
            System.out.println("Exception");
        }
        System.out.println(6);
    }
}
