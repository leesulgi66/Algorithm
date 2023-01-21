package javaPrac.object_oriented_programming.tv_test4;

import javaPrac.object_oriented_programming.tv_test.Tv;

public class TvTest4 {
    public static void main(String[] args) {
        Tv[] tvArr = new Tv[3];  // 길이가 3인 Tv객체 배열

        // Tv객체를 생성해서 Tv객체 배열의 각 요소에 저장  ※ 객체 배열을 생성하는 것 만으로는 객체가 생성되지 않는다.(실수하지 말것)
        for(int i=0; i<tvArr.length; i++) {
            tvArr[i] = new Tv();
            tvArr[i].channel = i+10;  //  tvArr[i]의 channel에 i+10을 저장
        }

        for(int i=0; i<tvArr.length; i++) {
            tvArr[i].channelUp();  // tvArr[i]의 메서드를 호출. 채널 1증가
            System.out.printf("tvArr[%d].channel = %d%n", i, tvArr[i].channel);
        }
    }
}
