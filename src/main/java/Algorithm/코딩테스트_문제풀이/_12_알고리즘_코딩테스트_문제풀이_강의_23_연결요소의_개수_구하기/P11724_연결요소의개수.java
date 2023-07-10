package Algorithm.코딩테스트_문제풀이._12_알고리즘_코딩테스트_문제풀이_강의_23_연결요소의_개수_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11724_연결요소의개수 {
    static ArrayList<Integer>[] A;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        A = new ArrayList[n+1];
        for(int i=1; i<n+1; i++) {
            A[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        int count = 0;
        for(int i=1; i<n+1; i++) {
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    private static void DFS(int v) {
        if(visited[v]) {
            return;
        }
        visited[v] = true;
        for(int i : A[v]){
            if(!visited[i]) {
                DFS(i);
            }
        }
    }
}
