package Lv2._39_더_맵게;

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();
        for(int i: scoville) {
            priorityQueueLowest.add(i);
        }
        while(priorityQueueLowest.peek() < K) {
            if(priorityQueueLowest.size() == 1) {
                if(priorityQueueLowest.peek() < K) {
                    return -1;
                }
            }
            int a = priorityQueueLowest.poll();
            int b = priorityQueueLowest.poll();
            priorityQueueLowest.add(a+(b*2));
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.solution(new int[] {1, 2, 3, 9, 10, 12}, 7)); // 2
//        System.out.println(s.solution(new int[] {10, 10, 10, 10, 10}, 100)); //4
        System.out.println(s.solution(new int[] {1, 1, 1, 1, 1}, 100)); // -1

    }
}