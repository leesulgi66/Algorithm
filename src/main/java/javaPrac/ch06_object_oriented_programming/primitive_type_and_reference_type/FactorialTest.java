package javaPrac.ch06_object_oriented_programming.primitive_type_and_reference_type;

public class FactorialTest {
    public static void main(String[] args){
        int result = factorial(4);

        System.out.println(result);
    }

    static int factorial(int n) {
        int result = 0;

        if( n ==  1)
            result = 1;
        else
            result = n * factorial(n-1); // 다시 메서드 자신을 호출한다.
        return result;
    }
}
