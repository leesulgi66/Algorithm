package Lv2._36_요격_시스템;

import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, ((x, y) -> x[0] - y[0]));  // 2차원 배열 정렬

        int preStart = targets[0][0];
        int preEnd = targets[0][1];

        for (int[] target : targets) {
            if (answer == 0) {
                answer += 1;
                continue;
            }

            int curStart = target[0];
            int curEnd = target[1];

            if (preStart <= curStart && curStart < preEnd) {
                // target 이 범위 안으로 들어오면 start 는 최대값으로 end는 최소값으로 범위를 갱신한다.
                preStart = Math.max(preStart, curStart);
                preEnd = Math.min(preEnd, curEnd);
            } else {
                // target 이 범위 밖으로 나가면 추가적인 요격이 필요하므로 answer+ 및 start와 end를 현재 target 값으로 변경한다.
                preStart = curStart;
                preEnd = curEnd;
                answer += 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s =new Solution();
        System.out.println(s.solution(new int[][]{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}}));  // 3
    }
}