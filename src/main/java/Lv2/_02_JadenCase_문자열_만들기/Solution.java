package Lv2._02_JadenCase_문자열_만들기;

//JadenCase 문자열 만들기
//        문제 설명
//        JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
//        문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
//
//        제한 조건
//        s는 길이 1 이상 200 이하인 문자열입니다.
//        s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.
//        숫자는 단어의 첫 문자로만 나옵니다.
//        숫자로만 이루어진 단어는 없습니다.
//        공백문자가 연속해서 나올 수 있습니다.
//        입출력 예
//        s	return
//        "3people unFollowed me"	"3people Unfollowed Me"
//        "for the last week"	"For The Last Week"
//        ※ 공지 - 2022년 1월 14일 제한 조건과 테스트 케이스가 추가되었습니다.
//https://school.programmers.co.kr/learn/courses/30/lessons/12951

class Solution {
    public String solution(String s) {
        String answer = s.toLowerCase();
        char[] words = answer.toCharArray();
        for(int i = 0 ; i < words.length; i++){
            //첫 글자가 아니어야 하고,
            if(words[i] != words[0]) {
                //글자가 공백일 경우
                if(words[i] == ' ') {
                    //마지막 글자가 아니고, 바로 다음 문자가 공백이 아니며, 소문자인 경우
                    if(words[i] != words[words.length-1] && words[i+1] != ' ' && words[i] > 96 && words[i] < 123){
                        words[i+1] = (char)(words[i+1]-32);
                    }
                }else {
                    //바로 전 문자가 공백이 아니고, 소문자인 경우
                    if (words[i-1] == ' ' && words[i] > 96 && words[i] < 123) {
                        words[i] = (char) (words[i] - 32);
                    }
                }
            }else{
                //첫 글자가 소문자인 경우
                if(words[0] > 96) {
                    words[0] = (char)(words[0] - 32);
                }
            }
        }
        answer = new String(words);

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution("3people unFollowed me"));
        System.out.println(s.solution("A bb 1a Aa vvv"));
    }
}
