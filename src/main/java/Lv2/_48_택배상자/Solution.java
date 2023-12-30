package Lv2._48_택배상자;

import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int index = 0;

        for(int i=1; i<=order.length; i++) {
            if(order[index] != i) {
                stack.push(i);
            }else {
                answer++;
                index++;
            }

            while(!stack.isEmpty() && stack.peek() == order[index]) {
                stack.pop();
                answer++;
                index++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[] {4, 3, 1, 2, 5})); // 2
        System.out.println(s.solution(new int[] {5, 4, 3, 2, 1})); // 5
        System.out.println(s.solution(new int[] {1, 2, 3, 4, 5})); // 5
        System.out.println(s.solution(new int[] {2, 1, 3, 5, 4})); // 5

    }
}