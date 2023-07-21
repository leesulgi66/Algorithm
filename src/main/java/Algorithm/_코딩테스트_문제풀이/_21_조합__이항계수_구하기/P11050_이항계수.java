package Algorithm._코딩테스트_문제풀이._21_조합__이항계수_구하기;

import java.util.Scanner;

public class P11050_이항계수 {
    static int N, K;
    static int D[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        D = new int[N+1][N+1];
        // 초기화
        for(int i=0; i<=N; i++) {
            D[i][i] = 1;
            D[i][0] = 1;
            D[i][1] = i;
        }

        // 점화식으로 배열 완성하기
        for(int i=2; i<=N; i++) {
            for(int j=1; j<i; j++) {
                D[i][j] = D[i-1][j] + D[i-1][j-1];
            }
        }
        System.out.println(D[N][K]);
    }
}
