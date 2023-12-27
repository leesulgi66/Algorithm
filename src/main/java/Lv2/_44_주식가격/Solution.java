package Lv2._44_주식가격;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=0; i<prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i); // index
        }

        while(!stack.isEmpty()) {
            answer[stack.peek()] = (length-1) - stack.peek();
            stack.pop();
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new int[]{1, 2, 3, 2, 3})));  // {4, 3, 1, 1, 0}
    }
}
