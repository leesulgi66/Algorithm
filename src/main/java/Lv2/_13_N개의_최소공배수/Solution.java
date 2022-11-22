package Lv2._13_N개의_최소공배수;

//https://school.programmers.co.kr/learn/courses/30/lessons/12953
/*
N개의 최소공배수
문제 설명
두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.
예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.

제한 사항
arr은 길이 1이상, 15이하인 배열입니다.
arr의 원소는 100 이하인 자연수입니다.
입출력 예
arr	result
[2,6,8,14]	168
[1,2,3]	6
 */

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];

        for(int i = 1;i<arr.length;i++){
            //최대공약수
            int gcd = gcd(answer,arr[i]);
            //최소공배수
            answer = answer * arr[i] / gcd;
        }
        return answer;
    }

    //최대공약수 (유클리드 호제법)
    public int gcd(int a, int b){
        int r = a % b;
        if(r == 0){
            return b;
        }else {
            return gcd(b, r);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[] {2,6,8,14})); //168
    }
}
