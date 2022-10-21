package _43_시저_암호;

//시저 암호
//        문제 설명
//        어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
//
//        제한 조건
//        공백은 아무리 밀어도 공백입니다.
//        s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
//        s의 길이는 8000이하입니다.
//        n은 1 이상, 25이하인 자연수입니다.
//        입출력 예
//        s	n	result
//        "AB"	1	"BC"
//        "z"	1	"a"
//        "a B z"	4	"e F d"

import java.util.Arrays;

class Solution {
    public String solution(String s, int n) {
        //아스키 코드를 이용해서 풀어보기
        //공백은 무효 처리, 숫자가 z를 넘어가면 다시 a로 만들기
        char[] array = s.toCharArray();

        System.out.println(Arrays.toString(array));

        int[] numArray = new int [array.length];

        for(int i = 0; i < array.length; i++) {
            //대문자 ascii
            if (array[i] > 64 && array[i] < 91){
                int sumAscii = array[i]+n;
                if(sumAscii > 90) {
                    sumAscii = sumAscii - 90 + 64;
                }
                numArray[i] = sumAscii;
            }
            //소문자 ascii
            else if (array[i] > 96 && array[i] < 123){
                int sumAscii = array[i]+n;
                if(sumAscii > 122) {
                    sumAscii = sumAscii - 122 + 96;
                }
                numArray[i] = sumAscii;
            }
            //공백
            else if (array[i] == 32){
                numArray[i] = array[i];
            }
        }

        System.out.println(Arrays.toString(numArray)); // [97, 32, 65]
        //int 배열을 char배열로 변환
        char[] answerArray = new char [numArray.length];
        for (int i = 0; i < numArray.length; i++) {
            answerArray[i] = (char) numArray[i];
        }
        System.out.println(Arrays.toString(answerArray)); // [a, , A]

        //char 배열을 String으로 변환
        String answer = String.valueOf(answerArray);
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "z Z";
        int n = 1;

        System.out.println(solution.solution(s, n));
    }
}


