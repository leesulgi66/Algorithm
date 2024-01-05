package Lv1._83_정수를_나선형으로_배치하기;

import java.util.Arrays;

class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int tx = 0;
        int ty = 0;
        int direction = 0;

        for(int i=1; i<=n*n; i++) {
            answer[tx][ty] = i;
            if(direction==0) {
                if(ty+1 < n && answer[tx][ty+1]==0) {
                    ty++;
                }else{
                    direction=1;
                }
            }
            if(direction==1) {
                if(tx+1 < n && answer[tx+1][ty]==0) {
                    tx++;
                }else{
                    direction=2;
                }
            }
            if(direction==2) {
                if(ty-1 >= 0 && answer[tx][ty-1]==0) {
                    ty--;
                }else{
                    direction=3;
                }
            }
            if(direction==3) {
                if(tx-1 >= 0 && answer[tx-1][ty]==0) {
                    tx--;
                    if(answer[tx-1][ty]!=0) {
                        direction=0;
                    }
                }else{
                    direction=0;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.solution(5)));
    }
}
