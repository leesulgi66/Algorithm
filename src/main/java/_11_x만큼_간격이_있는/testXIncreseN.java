package _11_x만큼_간격이_있는;

import java.util.Arrays;

public class testXIncreseN {
    public static void main(String[] args) {
        int x = -4;
        int n = 2;
        //x만큼 간격이 있는
        int num = 0;
        long[] answer = new long[n];
        // write your code here
        for (int i=0; i<n;i++){
            num += x;
            answer[i] = num;
        }
        System.out.println(Arrays.toString(answer));
    }
}
