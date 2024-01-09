package Lv2._53_프렌즈4블록;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int result = 1;
        char[][] boardArr = new char [m][n];
        int[][] d1 = new int[][] {{0,1},{1,0},{1,1}};

        // String을 배열로 변경
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                boardArr[i][j] = board[i].charAt(j);
            }
        }

        while(result != 0) {
            int cnt = 0;
            int[][] boardCheck = new int [m][n];
            char[][] nArr = new char[m][n];
            // 세가지 위치의 블록 체크(우,하,우하)
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    char target = boardArr[i][j];
                    int stack = 0;
                    for(int k=0; k<3; k++) {
                        int x = d1[k][0];
                        int y = d1[k][1];
                        if(i+y>=0 && i+y<m && j+x>=0 && j+x<n) {
                            // 체크 대상이 현재 값과 같고, 1과 빈값(0)이 아니어야 한다.
                            if(boardArr[i+y][j+x]!='1' && target == boardArr[i+y][j+x] && boardArr[i+y][j+x]!=0) {
                                stack++;
                            }
                        }
                    }

                    if(stack == 3) {
                        // 지워진 대상들 체크
                        boardCheck[i][j] = 1;
                        for(int k=0; k<3; k++) {
                            int x = d1[k][0];
                            int y = d1[k][1];
                            boardCheck[i+y][j+x] = 1;
                        }
                    }
                }
            }
            // 찾은 갯수 추가(check 배열에서 1로 바뀐 갯수)
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(boardCheck[i][j]==1) {
                        cnt++;
                        boardArr[i][j] = '1';
                    }
                }
            }

            answer += cnt;
            result = cnt;

            // 블록 재 정렬
            for(int i=0; i<n; i++) {
                Queue<String> queue = new LinkedList<>();
                for(int j=m-1; j>=0; j--) {
                    String t = boardArr[j][i]+"";
                    if(j==0){
                        if(boardArr[j][i]!='1'){
                            queue.offer(t);
                        }
                    }else if(boardArr[j][i]!='1') {
                        queue.offer(t);
                    }
                }
                int len = m-1;
                while(!queue.isEmpty()){
                    nArr[len][i] = queue.poll().charAt(0);
                    len--;
                }
            }

            boardArr = nArr.clone();

        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.solution(4, 5, new String[] {
//                "CCBDE",
//                "AAADE",
//                "AAABF",
//                "CCBBF"}));
//        System.out.println(s.solution(6, 6, new String[] {
//                "TTTANT",
//                "RRFACC",
//                "RRRFCC",
//                "TRRRAA",
//                "TTMMMF",
//                "TMMTTJ"}));
        System.out.println(s.solution(8, 5, new String[] {
                "HGNHU",
                "CRSHV",
                "UKHVL",
                "MJHQB",
                "GSHOT",
                "MQMJJ",
                "AGJKK",
                "QULKK"}));
    }
}
