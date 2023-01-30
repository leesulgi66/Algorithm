package javaPrac.ch06_object_oriented_programming.my_math_test;

public class MyMathTest {
    public static void main(String[] args) {
        MyMath mm = new MyMath();
        long result = mm.add(5L, 3L);
        long result2 = mm.subtract(5L, 3L);
        long result3 = mm.multiply(5L, 3L);
        double result4 = mm.divide(5L, 3L);  // long의 변수가 자동으로 double로 형변환 된다.

        System.out.println("add(5L, 3L) = "+result);
        System.out.println("subtract(5L, 3L) = "+result2);
        System.out.println("multiply(5L, 3L) = "+result3);
        System.out.println("divide(5L, 3L) = "+result4);
    }
}

class MyMath {
    long add(long a, long b) {
        long result = a + b;
        return result;
    }
    long subtract(long a, long b) { return a - b ;}
    long multiply(long a, long b) { return a * b ;}
    double divide(double a, double b) { return a / b ;}
}
