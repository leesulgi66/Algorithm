package Lv2._51_2xN타일링;

class Solution {
    public int solution(int n) {
        long D[] = new long[60000];
        D[1] = 1;   // 길이(N)가  1일때 타일 채우는 경우의 수
        D[2] = 2;   // 길이(N)가  2일때 타일 채우는 경우의 수

        for(int i=3; i<=n; i++) {
            D[i] = (D[i-1] + D[i-2]) % 1000000007;
        }
        return (int)D[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(4)); // 5
    }
}
