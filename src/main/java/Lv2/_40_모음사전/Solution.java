package Lv2._40_모음사전;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<String> list;
    static String[] words = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        // dfs를 이용해 list를 채워준다.
        dfs("", 0);

        for(int i=0; i<list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i;
            }
        }

        return answer;
    }

    static void dfs(String str, int len) {
        list.add(str);
        if(len == 5) return;
        for(int i=0; i<5; i++) {
            dfs(str + words[i], len + 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("AAAAE")); // 6
        System.out.println(s.solution("EIO")); // 1189
    }
}
