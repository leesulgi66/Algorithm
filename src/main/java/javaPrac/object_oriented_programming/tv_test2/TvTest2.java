package javaPrac.object_oriented_programming.tv_test2;

import javaPrac.object_oriented_programming.Tv;

public class TvTest2 {
    public static void main(String[] args) {
        Tv t1 = new Tv();
        Tv t2 = new Tv();
        System.out.println("t1의 channel값은 "+ t1.channel + "입니다.");
        System.out.println("t2의 channel값은 "+ t2.channel + "입니다.");

        t1.channel = 7;  // channel 값을 7으로 한다.
        System.out.println("t1이 channel값을 7로 변경하였습니다.");

        System.out.println("t1의 channel값은 "+ t1.channel + "입니다.");
        System.out.println("t2의 channel값은 "+ t2.channel + "입니다.");
    }
}
