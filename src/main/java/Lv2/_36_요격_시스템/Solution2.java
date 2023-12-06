package Lv2._36_요격_시스템;

import java.util.Arrays;

class Solution2 {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, ((x, y) -> x[1] - y[1]));
        int num = targets[0][1];
        System.out.println(Arrays.deepToString(targets));
        for(int i=1; i<targets.length; i++) {
            if(targets[i][0] >= num) {
                num = targets[i][1];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String [] args) {
        Solution2 s = new Solution2();
        System.out.println(s.solution(new int[][]{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}}));
    }
}
