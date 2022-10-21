package _38_나머지가_1이_되는_수_찾기;
//나머지가 1이 되는 수 찾기
//        문제 설명
//        자연수 n이 매개변수로 주어집니다. n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록 solution 함수를 완성해주세요. 답이 항상 존재함은 증명될 수 있습니다.
//
//        제한사항
//        3 ≤ n ≤ 1,000,000
//        입출력 예
//        n	result
//        10	3
//        12	11
//        입출력 예 설명
//        입출력 예 #1
//
//        10을 3으로 나눈 나머지가 1이고, 3보다 작은 자연수 중에서 문제의 조건을 만족하는 수가 없으므로, 3을 return 해야 합니다.
//        입출력 예 #2
//
//        12를 11로 나눈 나머지가 1이고, 11보다 작은 자연수 중에서 문제의 조건을 만족하는 수가 없으므로, 11을 return 해야 합니다.

public class TestNum40 {
    int solution(int n) {
        int answer = 0;
        int i = 1;
        while (i< 1000000){
            if(n%i == 1){
                answer = i;
                break;
            }else {
                i++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        TestNum40 testNum40 = new TestNum40();
        int n = 10;
        System.out.println(testNum40.solution(n));
    }
}
