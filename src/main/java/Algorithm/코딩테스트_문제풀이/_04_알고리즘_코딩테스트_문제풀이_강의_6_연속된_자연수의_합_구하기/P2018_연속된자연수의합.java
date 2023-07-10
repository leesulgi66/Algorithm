package Algorithm.코딩테스트_문제풀이._04_알고리즘_코딩테스트_문제풀이_강의_6_연속된_자연수의_합_구하기;

import java.util.Scanner;

public class P2018_연속된자연수의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;

        while(end_index!=N) {
            if(sum==N) {
                count++; end_index++; sum = sum + end_index; // end_index를 이동후 sum에 합친다.
            }else if(sum>N) {
                sum = sum - start_index;    // start_index를 빼준 후 포인터를 이동시킨다. 포인트 이동과 sum연산 순서 주의하기!
                start_index++;
            }else{
                end_index++; sum = sum + end_index;
            }
        }
        System.out.println(count);
    }
}
