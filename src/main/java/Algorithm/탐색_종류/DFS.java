package Algorithm.탐색_종류;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class DFS {
    static int[][] arr;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> arrayList;
    static ArrayList<Integer>order;
    public static void main(String[] args) {
        // DFS 는 재귀함쉬 및 스택으로 구현 가능하다.
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

        DFS(1);
        //DFS2(1);

        System.out.println(Arrays.toString(visited)); // 방문 배열 모두 방문 했는가
        System.out.println(order);  // 탐색 순서. [1, 2, 5, 6, 3, 4] 재귀, [1, 3, 4, 6, 2, 5] 스택
    }

    static void DFS(int a) { // 재귀로 구현
        if(visited[a]) {
            return;
        }
        visited[a] = true;
        order.add(a);

        for(int i : arrayList.get(a)) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }

    static void DFS2(int b) { // 스텍으로 구현
        Stack<Integer> stack = new Stack<>();
        if(visited[b]) {
            return;
        }
        visited[b] = true;
        stack.add(b);

        while(!stack.isEmpty()) {
            int now = stack.pop();
            visited[now] = true;
            order.add(now);
            for(int i : arrayList.get(now)) {
                if(!visited[i]) {
                    stack.add(i);
                }
            }

        }
    }
}
