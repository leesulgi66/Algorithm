package Lv2._56_소수_찾기;

import java.util.HashSet;
import java.util.Set;

class Solution {
    static Set<Integer> set;
    static boolean[] visit;
    public int solution(String numbers) {
        int answer = 0;
        int len = numbers.length();
        visit = new boolean[len];
        set = new HashSet<>();

        dfs(numbers, "", 0);

        for(int num : set) {
            if(isPrime(num)) answer++;
        }

        return answer;
    }

    void dfs (String numbers, String s, int depth) {
        if(depth>numbers.length()) {
            return;
        }

        for(int i=0; i<numbers.length();i++) {
            if(!visit[i]) {
                visit[i] = true;
                set.add(Integer.parseInt(s+numbers.charAt(i)));
                dfs(numbers, s+numbers.charAt(i) , depth + 1);
                visit[i] = false;
            }

        }
    }

    boolean isPrime(long num) {
        if(num <= 1){
            return false;
        }
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("011"));
    }
}
