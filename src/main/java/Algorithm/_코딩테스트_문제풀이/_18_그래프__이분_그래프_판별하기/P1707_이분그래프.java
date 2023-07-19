package Algorithm._코딩테스트_문제풀이._18_그래프__이분_그래프_판별하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P1707_이분그래프 {
    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean[] visited;
    static boolean IsEven;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int t=0; t<testCase; t++) { // 주어진 테스트 케이스 만큼 돌림
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            A = new ArrayList[V+1];
            visited = new boolean[V+1];
            check = new int[V+1];
            IsEven = true;
            for(int i=1; i<=V; i++) {
                A[i] = new ArrayList<Integer>();
            }
            // 에지 데이터 저장하기
            for(int i=0; i<E; i++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                A[start].add(end);
                A[end].add(start);
            }
            // 모든 노드에서 DFS 실행 해야함
            for(int i=1; i<=V; i++) {
                if(IsEven){
                    DFS(1);
                }else {
                    break;
                }
            }

            if(IsEven) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static void DFS(int start){
        visited[start] = true;
        for(int i : A[start]) { // 인접리스트로 받아서 start에서 연결된 모든 노드를 탐색
            if(!visited[i]) {
                // 바로 직전에 있는 노드와 다른 집합으로 분류를 해주는것이 필요
                check[i] = (check[start] +1)%2;
                DFS(i);
            }else {
                if(check[start] == check[i]) {
                    IsEven = false;
                }
            }
        }
    }
}
