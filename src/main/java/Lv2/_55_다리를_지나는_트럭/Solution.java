package Lv2._55_다리를_지나는_트럭;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int sum = 0;
        int time = 0;
        int idx=0;
        Queue<Integer> queue = new LinkedList<>();

        while(true) {

            if(idx == truck_weights.length) {
                time += bridge_length;
                break;
            }

            if(queue.size()== bridge_length) {
                int temp = queue.poll();
                sum -= temp;
                if(sum + truck_weights[idx] <= weight) {
                    queue.add(truck_weights[idx]);
                    sum += truck_weights[idx];
                    idx++;
                    time++;
                    continue;
                }else {
                    queue.add(0);
                    time++;
                    continue;
                }

            }

            if(sum + truck_weights[idx] <= weight) {
                queue.add(truck_weights[idx]);
                sum += truck_weights[idx];
                idx++;
                time++;
            }else {
                queue.add(0);
                time++;
            }
        }

        return time;
    }

    public static void main(String[]args) {
        Solution s = new Solution();
        System.out.println(s.solution(2,10,new int[]{7,4,5,6}));
    }
}
