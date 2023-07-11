package Algorithm._코딩테스트_문제풀이._20_알고리즘_코딩테스트_문제풀이_강의_53_줄_세우기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2252_줄세우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            A.add(new ArrayList<>());
        }

        int indegree[] = new int[N+1];

        for(int i=0; i<M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A.get(S).add(E);
            indegree[E]++;  //진입차수 배열 데이터 자장 부분
        }

        // 위상 정렬 실행
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            if(indegree[i]==0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for(int next : A.get(now)) {
                indegree[next]--;
                if(indegree[next]==0) {
                    queue.offer(next);
                }
            }
        }
    }
}
