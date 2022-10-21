package _39_문자열_내림차순으로_배치하기;

import java.util.Arrays;

//문자열 내림차순으로 배치하기
//        문제 설명
//        문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
//        s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
//
//        제한 사항
//        str은 길이 1 이상인 문자열입니다.
//        입출력 예
//        s	       | return
//        "Zbcdefg"| "gfedcbZ"
public class TestNum41 {
    public String solution(String s) {
//        char[] temp = s.toCharArray();

        String[] temp = s.split("");
        int[] tempAscii = new int[temp.length];
        int[] sortAscii = new int[temp.length];
        char[] listAnswer = new char [temp.length];
        for(int i = 0; i < temp.length; i++) {
            tempAscii[i] = (int) temp[i].charAt(0);
        }

        Arrays.sort(tempAscii);

        for (int i = tempAscii.length -1, j = 0; i >= 0; i--,j++) {
            sortAscii[j] = tempAscii[i];
        }

        for (int i =0; i < sortAscii.length; i++) {
            listAnswer[i] = ((char)sortAscii[i]);
        }
        String answer = String.valueOf(listAnswer);

        return answer;
    }

    public static void main(String[] args) {
        TestNum41 testNum41 = new TestNum41();
        String s = "Zbcdefg";
        System.out.println(testNum41.solution(s));
    }
}
