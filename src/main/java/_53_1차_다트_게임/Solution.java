package _53_1차_다트_게임;

//[1차] 다트 게임
//        문제 설명
//        다트 게임
//        카카오톡에 뜬 네 번째 별! 심심할 땐? 카카오톡 게임별~
//
//        Game Star
//
//        카카오톡 게임별의 하반기 신규 서비스로 다트 게임을 출시하기로 했다. 다트 게임은 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임으로, 모두가 간단히 즐길 수 있다.
//        갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다. 다트 게임의 점수 계산 로직은 아래와 같다.
//
//        다트 게임은 총 3번의 기회로 구성된다.
//        각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
//        점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
//        옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
//        스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
//        스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
//        스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
//        Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
//        스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
//        0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.
//
//        입력 형식
//        "점수|보너스|[옵션]"으로 이루어진 문자열 3세트.
//        예) 1S2D*3T
//
//        점수는 0에서 10 사이의 정수이다.
//        보너스는 S, D, T 중 하나이다.
//        옵선은 *이나 # 중 하나이며, 없을 수도 있다.
//        출력 형식
//        3번의 기회에서 얻은 점수 합계에 해당하는 정수값을 출력한다.
//        예) 37
//
//        입출력 예제
//        예제	dartResult	answer	설명
//        1	1S2D*3T	37	11 * 2 + 22 * 2 + 33
//        2	1D2S#10S	9	12 + 21 * (-1) + 101
//        3	1D2S0T	3	12 + 21 + 03
//        4	1S*2T*3S	23	11 * 2 * 2 + 23 * 2 + 31
//        5	1D#2S*3S	5	12 * (-1) * 2 + 21 * 2 + 31
//        6	1T2D3D#	-4	13 + 22 + 32 * (-1)
//        7	1D2S3T*	59	12 + 21 * 2 + 33 * 2
//        해설 보러가기

import java.util.Arrays;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] number = {0,1,2,3,4,5,6,7,8,9};
        String[] numberString = {"0","1","2","3","4","5","6","7","8","9"};
        String[] bonus = {"S", "D", "T"};
        String[] option = {"*", "#"};
        String[] splitString = dartResult.split(""); //문자열을 낯개로 쪼개기

        int[] resultnum = new int[10]; //빈 배열 생성

        //쪼갠 문자열 수만큼 for문
        for(int i = 0; i < splitString.length; i++) {
            if (Arrays.asList(numberString).contains(splitString[i])){
                //숫자 1일 경우 뒤의 숫자가 0이 와서 10이 될 가능성 조건
                if(splitString[i].equals("1")) {
                    if(splitString[i+1].equals("0")) {
                        continue;
                    }else {
                        resultnum[i] = 1;
                    }
                //숫자 0일 경우 앞의 숫자가 1이와서 10이 될수 있는 조건
                }else if(splitString[i].equals("0")){
                    if (i==0) {
                        resultnum[i] = 0;
                    }else if(splitString[i-1].equals("1")){
                        resultnum[i] = 10;
                    }
                //현재 숫자의 index 위치를 빈 배열의 같은 index 위치로 옮긴다.
                }else {
                    resultnum[i] = number[Arrays.asList(numberString).indexOf(splitString[i])];
                }
            }

            //문자 S,D,T의 경우
            if (Arrays.asList(bonus).contains(splitString[i])){
                if (splitString[i].equals("S")){
                    resultnum[i-1] = resultnum[i-1];
                }else if (splitString[i].equals("D")) {
                    resultnum[i-1] = resultnum[i-1] * resultnum[i-1];
                }else if (splitString[i].equals("T")) {
                    resultnum[i-1] = resultnum[i-1] * resultnum[i-1] * resultnum[i-1];
                }
            }

            //문자 *,#의 경우
            if((Arrays.asList(option).contains(splitString[i]))){
                if(splitString[i].equals("*")) {
                    resultnum[i-2] = resultnum[i-2] * 2;
                    //i의 인덱스가 2이상일 때만 이 전의 수에 연산해 준다.
                    if(i > 2){
                        if(resultnum[i-4] != 0) {
                            resultnum[i-4] = resultnum[i-4] * 2;
                            System.out.println("4번"+resultnum[i-4]);
                        }else if (resultnum[i-5] != 0) {
                            resultnum[i-5] = resultnum[i-5] * 2;
                            System.out.println("5번"+resultnum[i-5]);
                        }
                    }

                }else if(splitString[i].equals("#")) {
                    resultnum[i-2] = resultnum[i-2] * -1;
                }
            }
        }
        System.out.println(Arrays.toString(resultnum));

        answer  = Arrays.stream(resultnum).sum();

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String dartResult = "2S*2T*3S";
        System.out.println(solution.solution(dartResult));
    }
}
