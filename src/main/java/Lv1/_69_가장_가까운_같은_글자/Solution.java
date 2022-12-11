package Lv1._69_가장_가까운_같은_글자;

import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            if(i==0) {
                answer[0] = -1;
            }
            for(int j=i-1; j>=0; j--) {
                if(s.charAt(i) == s.charAt(j)) {
                    answer[i] = i-j;
                    break;
                }
                answer[i] = -1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution("foobarr")));
    }
}