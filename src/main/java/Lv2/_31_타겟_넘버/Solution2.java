package Lv2._31_타겟_넘버;

import java.util.LinkedList;
import java.util.Queue;

class Solution2 {
    class Pair{
        int cur;
        int depth;

        Pair(int cur, int depth) {
            this.cur = cur;
            this.depth = depth;
        }
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(numbers[0], 0));
        queue.offer(new Pair(-numbers[0], 0));

        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            if(p.depth == numbers.length-1) {
                if(p.cur == target) {
                    answer++;
                }
            }else {
                int c1 = p.cur + numbers[p.depth+1];
                int c2 = p.cur - numbers[p.depth+1];

                queue.add(new Pair(c1, p.depth+1));
                queue.add(new Pair(c2, p.depth+1));
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.solution(new int[] {4, 1, 2, 1}, 4)); // 2
    }
}
