package Lv1._80_이웃한_칸;

class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        String target = board[h][w];

        for(int i=0; i<4; i++) {
            int ch = h+dh[i];
            int cw = w+dw[i];
            if(ch >= 0 && ch < n && cw >= 0 && cw< n) {
                String check = board[h+dh[i]][w+dw[i]];
                if(target.equals(check)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static  void main(String[] args) {
        Solution s = new Solution();
        String[][] s1 = {{"blue", "red", "orange", "red"},{"red", "red", "blue", "orange"},{"blue", "orange", "red", "red"},{"orange", "orange", "red", "blue"}};
        String[][] s2 = {{"yellow", "green", "blue"},{"blue", "green", "yellow"},{"yellow", "blue", "blue"}};
        String[][] s3 = {{"red", "red", "red"},{"red", "red", "red"},{"red", "red", "red"}};
        System.out.println(s.solution(s1,1, 1));  // 2
        System.out.println(s.solution(s2, 0, 1));  // 1
        System.out.println(s.solution(s3, 0, 0));  // 1
    }
}
