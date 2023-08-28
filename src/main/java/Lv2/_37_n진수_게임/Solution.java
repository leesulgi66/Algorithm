package Lv2._37_n진수_게임;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        int cnt = 0; // 조건문 카운팅을 위한 변수
        int max = t*m; // 반복문 최대 수
        StringBuilder sb = new StringBuilder();
        for (int i=0; sb.length()<=max; i++) { // sb의 크기가 max를 넘을 때 까지 n진수를 추가해 준다.
            sb.append(Integer.toString(i, n));
        }

        for(int i=p-1; cnt < t; i=i+m){ // sb에서 m의 순번째 숫자만 answer에 추가한다.
            answer.append(sb.charAt(i));
            cnt++;
        }

        return answer.toString().toUpperCase(); // 알파벳은 대문자로 모두 변환한다.
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(2,4,2,1));  // "0111"
        System.out.println(s.solution(16,16,2,1));  // "02468ACE11111111"
    }
}
