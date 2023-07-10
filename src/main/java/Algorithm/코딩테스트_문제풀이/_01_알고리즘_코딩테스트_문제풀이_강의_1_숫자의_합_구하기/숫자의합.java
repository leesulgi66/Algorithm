package Algorithm.코딩테스트_문제풀이._01_알고리즘_코딩테스트_문제풀이_강의_1_숫자의_합_구하기;

import java.util.Scanner;

public class 숫자의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 입력값을 String형 변수 SNum에 저장한 후 char[]형 변수로 변환하기
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();   // char배열로 변환
        int sum = 0;
        for(int i=0; i<cNum.length; i++) {
            sum += cNum[i] - '0';   // 아스키코드를 이용한 cNum[i]를 정수형으로 변환하면서  sum에 더하여 누적하기
        }
        System.out.println(sum);
    }
}