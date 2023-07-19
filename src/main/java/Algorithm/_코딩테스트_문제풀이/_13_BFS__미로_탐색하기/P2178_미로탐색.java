package Algorithm._코딩테스트_문제풀이._13_BFS__미로_탐색하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178_미로탐색 {
    static int[] dx = {0,1,0,-1}; // 두 배열을 합쳐서 (하,우,상,좌 를 탐색한다.)
    static int[] dy = {1,0,-1,0};
    static boolean[][]visited;
    static int[][] A;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine()); // 공백이 없기때문에
            String line = st.nextToken(); // String으로 받는다.
            for(int j=0; j<M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j+1)); // 위의 긴 라인을 잘라서 숫자로 변환해 넣는다.
            }
        }
        BFS(0,0);
        System.out.println(A[N-1][M-1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j});
        visited[i][j] = true;
        while(!queue.isEmpty()){
            int now[] = queue.poll();
            for(int k=0; k<4; k++){ // 상하좌우 탐색
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x >= 0 && y >= 0 & x < N && y < M){  // 배열을 넘어가면 안되고
                    if(A[x][y] != 0 && !visited[x][y]) { // 0이어서 갈수 없거나 기방문한 곳이면 안됨
                        // 이제 갈수 있는곳이다.
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1; // 핵심! (현재 탐새한 배열에 depth값을 입력한다.
                        queue.add(new int[] {x,y});
                    }
                }
            }
        }
    }
}
