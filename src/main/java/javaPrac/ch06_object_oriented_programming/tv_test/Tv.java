package javaPrac.ch06_object_oriented_programming.tv_test;

public class Tv {
    // Tv의 속성 (맴버변수)
    public String color;  // 색상
    public boolean power;  // 전원상태 (on/off)
    public int channel;  // 채널

    //Tv의 기능(메서드)
    public void power() { power = !power;}  // Tv를 켜거나 끄는 기능을 하는 메서드
    public void channelUp() { ++channel; }  // Tv의 채널을 높이는 기능을 하는 메서드
    public void channerDown() { --channel; }  // Tv의 채널을 낮추는 기능을 하는 메서드
}
