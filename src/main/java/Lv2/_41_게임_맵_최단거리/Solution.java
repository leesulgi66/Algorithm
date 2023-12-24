package Lv2._41_게임_맵_최단거리;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] dx = {0,1,-1,0};
    static int[] dy = {1,0,0,-1};
    static boolean[][] visit;
    static int[][] map;
    static int height ;
    static int width ;
    public int solution(int[][] maps) {
        int answer = -1;
        map = maps;
        height = maps.length -1;
        width = maps[0].length -1;
        visit = new boolean [height+1][width+1];

        BFS(0, 0);
        answer = map[height][width];

        if(answer != 1) {
            return answer;
        }else {
            return -1;
        }
    }

    void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{x, y});
        visit[x][y] = true; // 첫 번째 지점 0,0 true로 초기화
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            if(now[0] == (width) && now[1] == (height)) {
                return;
            }
            for(int i=0; i<4; i++){
                int sx = now[0]+dx[i];
                int sy = now[1]+dy[i];
                if(sx>=0 && sx<=height && sy>=0 && sy<=width) {
                    if(!visit[sx][sy] && map[sx][sy] != 0){
                        map[sx][sy] = map[now[0]][now[1]] + 1;
                        visit[sx][sy] = true;
                        queue.offer(new int[]{sx, sy});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}})); // 11
//        System.out.println(s.solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}})); // -1
        System.out.println(s.solution(new int[][] {{1,1,1,1},{1,1,1,1},{1,1,1,1}})); // -1
    }
}
