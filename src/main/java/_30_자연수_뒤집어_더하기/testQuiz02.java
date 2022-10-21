package _30_자연수_뒤집어_더하기;

import java.util.Arrays;

public class testQuiz02 {
    public String solution(int n) {
        //알고리즘 테스트 2번 문제!!
        //2번 문제 자연수 뒤집어 더하기!
        int numsum = 0;
        int[] numarr = new int[(int) (Math.log10(n) + 1)]; // 자연수 n 길이 만큼의 배열
        int count = 0; //while 문의 반복 횟수
        while(n > 0){
            int remainder = n%10;
            numsum += remainder; //합계
            numarr[count] = remainder; //배열에 역순으로 추가
            count++;
            n = n/10;
        }
        Arrays.toString(numarr); //숫자 배열을 문자 배열로 변환
        String answer = ""; //빈 문자 생성
        StringBuilder stringBuilder = new StringBuilder();

        for (int i=0; i<numarr.length;i++){
            if(i<numarr.length-1){
                stringBuilder.append(numarr[i]+"+"); //문자열의 수정은 + 기보단 Stringbuilder를 쓰자;
            }else{
                stringBuilder.append(numarr[i]+"=");
            }
        }
        answer = stringBuilder.toString();
        String.valueOf(numsum); //합계도 문자열로 변경
        answer += numsum;
        return answer;
    }

    public static void main(String[] args) {
        testQuiz02 method = new testQuiz02();
        System.out.println(method.solution(718253));
    }
}