package Algorithm._코딩테스트_문제풀이._16_알고리즘_코딩테스트_문제풀이_강의_36_최솟값을_만드는_괄호_배치_찾기;

import java.util.Scanner;

public class P1541_잃어버린괄호 {
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String example = sc.nextLine();
        String[] str = example.split("-");
        for(int i=0; i<str.length; i++) {
            int temp = mySum(str[i]);
            if(i==0) answer = answer + temp;
            else answer = answer - temp;
        }

        System.out.println(answer);
    }

    private static int mySum(String s) {
        int sum =0;
        String[] temp = s.split("[+]");
        for(int i=0; i<temp.length; i++) {
            sum = sum + Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
