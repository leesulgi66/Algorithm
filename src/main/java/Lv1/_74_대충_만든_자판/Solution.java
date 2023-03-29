package Lv1._74_대충_만든_자판;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"})));
        System.out.println(Arrays.toString(s.solution(new String[]{"AGZ", "BSSS"}, new String[]{"ASA", "BGZ"})));
        System.out.println(Arrays.toString(s.solution(new String[]{"AA"}, new String[]{"B"})));
    }

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for(int i=0; i<targets.length; i++) {
            answer[i] = cal(keymap, targets[i]);
        }

        return answer;
    }

    public int cal(String[] keymap, String target) {
        int sum = 0;
        char[] splitCh = target.toCharArray();
        int[] num = new int[target.split("").length];

        for (int i=0; i< keymap.length; i++) {
            for(int j=0; j< splitCh.length; j++) {
                if(keymap[i].contains(String.valueOf(splitCh[j]))) {
                    if(num[j]!=0){
                        num[j] = Math.min(num[j], keymap[i].indexOf(splitCh[j])+1);
                    }else {
                        num[j] = keymap[i].indexOf(splitCh[j])+1;
                    }
                }
            }
        }

        for(int i=0; i<num.length; i++) {
            if(num[i]==0) {
                return -1;
            }else {
                sum += num[i];
            }
        }

        return sum;
    }
}
