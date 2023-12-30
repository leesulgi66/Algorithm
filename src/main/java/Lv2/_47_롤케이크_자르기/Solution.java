package Lv2._47_롤케이크_자르기;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int count1 = 0;
        int count2 = 0;

        for(int i=0; i<topping.length; i++) {
            //배열의 모든 수를 key=수, value=수의 개수 -> map2를 초기화 시켜준다. 새로운 수가 들어갈 때 마다 count2를 증가시킨다.
            if(map2.containsKey(topping[i])) {
                Integer val = map2.get(topping[i]);
                map2.put(topping[i], val+1);
            }else {
                map2.put(topping[i], 1);
                count2++;
            }
        }

        for(int i=0; i<topping.length; i++) {
            //배열의 수를 하나씩 꺼내서 map1로 옮기며 새로운 수가 들어갈 때 마다 count1을 증가시킨다.
            int t = topping[i];
            if(map1.containsKey(t)) {
                Integer val = map1.get(t);
                map1.put(t, val+1);
            }else {
                map1.put(t, 1);
                count1++;
            }
            //가진 수가 0이 되면 map2에서 삭제 후 count2를 감소 시켜준다.
            if(map2.get(t) == 1) {
                map2.remove(t);
                count2--;
            }else {
                Integer val = map2.get(t);
                map2.put(t, val-1);
            }

            //count1과 count2가 같을 때만 공평한 분배
            if(count1 == count2 && count1 != 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[] {1, 2, 1, 3, 1, 4, 1, 2}));  // 2
        System.out.println(s.solution(new int[] {1, 2, 3, 1, 4}));  // 0
        System.out.println(s.solution(new int[] {1,1}));  // 1
    }
}
