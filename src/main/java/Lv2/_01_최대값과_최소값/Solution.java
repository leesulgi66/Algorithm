package Lv2._01_최대값과_최소값;

//최댓값과 최솟값
//        문제 설명
//        문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
//        예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.
//
//        제한 조건
//        s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
//        입출력 예
//        s	return
//        "1 2 3 4"	"1 4"
//        "-1 -2 -3 -4"	"-4 -1"
//        "-1 -1"	"-1 -1"
//https://school.programmers.co.kr/learn/courses/30/lessons/12939

import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[]words = s.split(" ");
        //String 배열을 int배열로 변환
        int[] nums = Arrays.stream(words).mapToInt(Integer::parseInt).toArray();
        int maxNum = nums[0];
        int minNum = nums[0];
        for(int i : nums) {
            maxNum = Math.max(i, maxNum);
            minNum = Math.min(i, minNum);
        }

        return minNum +" "+maxNum;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("1 2 3 4"));
        System.out.println(s.solution("-1 -2 -3 -4"));
        System.out.println(s.solution("-1 -1"));
    }
}