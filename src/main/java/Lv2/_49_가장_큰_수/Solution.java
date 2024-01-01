package Lv2._49_가장_큰_수;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] strArr = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        // 내림차순 정렬
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
                // 오름차순 정렬 (o1+o2).compareTo(o1+o2);
            }
        });

        // 첫 번째 값이 0일 경우 0을 리턴
        if(strArr[0].equals("0")) return "0";

        for(String s : strArr) {
            answer.append(s);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[] {6, 10, 2})); // "6210"
        System.out.println(s.solution(new int[] {3, 30, 34, 5, 9})); // "9534330"
    }
}
