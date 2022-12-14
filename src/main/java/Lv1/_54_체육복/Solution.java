package Lv1._54_체육복;

//체육복
//        문제 설명
//        점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
//
//        전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
//
//        제한사항
//        전체 학생의 수는 2명 이상 30명 이하입니다.
//        체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
//        여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
//        여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
//        여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
//        입출력 예
//        n	lost	reserve	return
//        5	[2, 4]	[1, 3, 5]	5
//        5	[2, 4]	[3]	4
//        3	[3]	[1]	2
//        입출력 예 설명
//        예제 #1
//        1번 학생이 2번 학생에게 체육복을 빌려주고, 3번 학생이나 5번 학생이 4번 학생에게 체육복을 빌려주면 학생 5명이 체육수업을 들을 수 있습니다.
//
//        예제 #2
//        3번 학생이 2번 학생이나 4번 학생에게 체육복을 빌려주면 학생 4명이 체육수업을 들을 수 있습니다.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int solution(int n, int[] lost, int[] reserve) {
        //진짜 너무너무 어렵다~~~~~~~~~~~
        int answer = 0;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        List<Integer> listLost = new ArrayList<>();
        List<Integer> listReserve = new ArrayList<>();

        //array 에서 list로 옮김
        for(int i : lost) {
            listLost.add(i);
        }
        for(int i : reserve) {
            listReserve.add(i);
        }

        System.out.println("리스트 체크 : "+listLost);
        System.out.println("리스트 체크 : "+listReserve);

        //중복값 제거, 주의점 원본 list에 바로 삭제시 index위치가 달라져 완전히 제거 되지 않기 때문에 사본을 만든 후 사본에 삭제
        for(int i = 0; i < lost.length; i++) {
            for (int j = 0 ; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    listLost.remove(Integer.valueOf(lost[i]));
                    listReserve.remove(Integer.valueOf(reserve[j]));
                }
            }
        }

        System.out.println("리스트 체크 : "+listLost);
        System.out.println("리스트 체크 : "+listReserve);

        for(int i : listReserve) {
            if(listLost.contains(i - 1)) {
                listLost.remove(Integer.valueOf(i-1));
            }else if (listLost.contains(i + 1)) {
                listLost.remove(Integer.valueOf(i+1));
            }
        }

        answer = n-listLost.size();
        return answer;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int[] lost = {1,2,3};
        int[] reserve = {2,4};
        System.out.println(solution.solution(n,lost,reserve));
    }
}