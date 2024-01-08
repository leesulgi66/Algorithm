package Lv1._84_가장_많이_받은_선물;

import java.util.Arrays;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int[] answer = new int[friends.length]; // 정답 배열
        int[][] arr = new int[friends.length][friends.length]; // 주고 받은 선물 개수의 2차원 배열
        int[] presentPoint = new int[friends.length]; // 선물 지수 배열

        // 주고받은 선물 배열과 선물 지수 배열 만들기
        for(int i=0; i<gifts.length; i++) {
            String[] split = gifts[i].split(" ");
            int x = Arrays.asList(friends).indexOf(split[0]); // 선물 준 사람
            int y = Arrays.asList(friends).indexOf(split[1]); // 선물 받은 사람
            arr[x][y]++;
            presentPoint[x]++;
            presentPoint[y]--;
        }

        // 다음달 받을 선물 구하기
        for(int i=0; i< friends.length; i++) {
            for(int j=i; j< friends.length; j++) {
                if(j!=i) {
                    // 주고 받은 선물의 수가 같다면
                    if(arr[i][j]== arr[j][i]) {
                        // 선물 지수로 판별 후 값 증감
                        if(presentPoint[i] == presentPoint[j]) {
                            continue;
                        }else if(presentPoint[i] > presentPoint[j]) {
                            answer[i]++;
                        }else {
                            answer[j]++;
                        }
                    // 준 선물이 더 많다면 증가
                    }else if(arr[i][j] > arr[j][i]) {
                        answer[i]++;
                    // 준 선물이 적다면 반대가 증가
                    }else {
                        answer[j]++;
                    }
                }
            }
        }

        int max = 0;
        for(int i: answer) {
            if(i>max) max=i;
        }

        // 받은 선물 배열의 최대값이 정답
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[]{"muzi", "ryan", "frodo", "neo"},new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"})); // 2
        System.out.println(s.solution(new String[]{"joy", "brad", "alessandro", "conan", "david"},new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"})); // 4
        System.out.println(s.solution(new String[]{"a", "b", "c"},new String[]{"a b", "b a", "c a", "a c", "a c", "c a"})); // 0
    }
}
