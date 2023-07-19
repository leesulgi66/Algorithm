package Algorithm.탐색_종류;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static int[][] arr;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> arrayList;
    static ArrayList<Integer>order;
    public static void main(String[] args) {
        arr = new int[][] {{1,2},{1,3},{2,5},{2,6},{3,4},{4,6}};
        visited = new boolean[7];
        arrayList = new ArrayList<>();
        order = new ArrayList<>();
        for(int i=0; i<7; i++) {
            arrayList.add(new ArrayList<>());
        }

        for(int[] i : arr) {
            arrayList.get(i[0]).add(i[1]);
        }

        BFS(1);

        System.out.println(Arrays.toString(visited)); // 방문 배열 모두 방문 했는가
        System.out.println(order);  // 탐색 순서. [1, 2, 3, 5, 6, 4]

    }

    static void BFS(int a) {
        Queue<Integer> queue = new LinkedList<>();
        if(visited[a]){
            return;
        }
        visited[a]=true;
        queue.offer(a);

        while(!queue.isEmpty()) {
            int now = queue.poll();
            visited[now]=true;
            order.add(now);
            for(int i : arrayList.get(now)) {
                if(!visited[i]) {
                    queue.add(i);
                }
            }
        }

    }
}
