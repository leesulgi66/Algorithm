package _32_삼진법_뒤집기;

import java.util.ArrayList;
import java.util.List;

//https://programmers.co.kr/learn/courses/30/lessons/68935
//3진법 뒤집기
//        문제 설명
//        자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
//
//        제한사항
//        n은 1 이상 100,000,000 이하인 자연수입니다.
//        입출력 예
//        n	result
//        45	7
//        125	229
//        입출력 예 설명
//        입출력 예 #1
//
//        답을 도출하는 과정은 다음과 같습니다.
//        n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
//        45	1200	0021	7
//        따라서 7을 return 해야 합니다.
//        입출력 예 #2
//
//        답을 도출하는 과정은 다음과 같습니다.
//        n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
//        125	11122	22111	229
//        따라서 229를 return 해야 합니다.

public class testNum34 {
    public int solution(int n) {
//        String num = Integer.toString(n, 3);  //3진수로 변경
//        String[] nums = num.split(""); //배열로 변경 [1,2,0,0,]
//        List<String> emptyNum = new ArrayList<>();
//
//        for (int i=nums.length-1; i >= 0; i--){  //역순으로 list.add
//            emptyNum.add(nums[i]);
//        }
//        System.out.println(Collections.unmodifiableList(emptyNum)); //배열 상태 체크 [0,0,2,1]
//
//        String result = "";
//        for (String item : emptyNum){
//            result += item;
//        }
//        System.out.println(result);  //[0021] 문자열;
//        int answer = Integer.parseInt(result, 3);
//        System.out.println(answer);
        //-----------------------------------------------------------------------두번째
        List<Integer> numlist = new ArrayList<>();
        while (n > 0) {
            int i = n%3;
            numlist.add(i);
            n = n/3;
        }
        //System.out.println(numlist); //list 확인  [0,0,2,1]
        String result = "";
        for (Integer i : numlist){
            result += i;
        }
        int intNum = Integer.parseInt(result);
        int answer = intNum/3;


        return answer;
    }


    public static void main(String[] args) {
        testNum34 testNum34 = new testNum34();
        int answer = testNum34.solution(45);
        System.out.println(answer);
    }

}
