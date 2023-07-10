package Algorithm._코딩테스트_문제풀이._17_알고리즘_코딩테스트_문제풀이_강의_37_소수_구하기;

import java.util.Scanner;

public class P1929_소수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int A[] = new int[N+1];
        for(int i=1; i<=N; i++) {
            A[i] = i;
        }

        for(int i=2; i<Math.sqrt(N); i++) {
            if(A[i]==0) continue;
            for(int j=i+i; j<=N; j = j+i) { // 첫번째 i는 건너뛰고 두번째 i부터, j는 i의 배수만큼 이동시키기
                A[j] = 0;
            }
        }

        for(int i=M; i<=N; i++) {
            if(A[i]!=0) {
                System.out.println(A[i]);
            }
        }
    }
}
