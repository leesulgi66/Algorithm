package javaPrac.object_oriented_programming.tv_test2;

class Tv {
    // Tv의 속성(맴버변수)
    String color;  // 색상
    boolean power; // 전원상태
    int channel;  // 채널
    
    // Tv이 기능(매서드)
    void power() { power = !power;}  // Tv를 켜거나 끄는 기능을 하는 메서드
    void channelUp() { ++channel; }  // Tv의 채널을 높이는 기능을 하는 메서드
    void channerDown() { --channel; }  // Tv의 채널을 낮추는 기능을 하는 메서드
}

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
