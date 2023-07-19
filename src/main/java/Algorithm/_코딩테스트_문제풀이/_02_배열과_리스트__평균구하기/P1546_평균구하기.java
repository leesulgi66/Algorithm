package Algorithm._코딩테스트_문제풀이._02_배열과_리스트__평균구하기;

import java.util.Scanner;

public class P1546_평균구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        long sum = 0;
        long max = 0;

        for(int i=0; i<N; i++) {
            if(A[i]>max) max = A[i];
            sum = sum + A[i];
        }

        System.out.println(sum*100.0/max/N);
    }
}