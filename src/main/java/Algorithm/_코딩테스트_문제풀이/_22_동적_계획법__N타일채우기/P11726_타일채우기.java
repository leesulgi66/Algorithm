package Algorithm._코딩테스트_문제풀이._22_동적_계획법__N타일채우기;

import java.util.Scanner;

public class P11726_타일채우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long D[] = new long[1001];
        D[1] = 1;   // 길이(N)가  1일때 타일 채우는 경우의 수
        D[2] = 2;   // 길이(N)가  2일때 타일 채우는 경우의 수

        for(int i=3; i<=N; i++) {
            D[i] = (D[i-1] + D[i-2]) % 1007;
        }

        System.out.println(D[N]);
    }
}
