package Lv2._34_K진수에서_소수_개수_구하기;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String num = Integer.toString(n, k);
        String[] numbs = num.split("0");

        for(String number : numbs) {
            if(!number.equals("")){
                long i = Long.parseLong(number);
                if(isPrime(i)) answer++;
            }
        }

        return answer;
    }

    boolean isPrime(long num) {
        if(num == 1){
            return false;
        }
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.solution(437674, 3)); // 3
        System.out.println(s.solution(110011, 10)); // 2
    }
}
