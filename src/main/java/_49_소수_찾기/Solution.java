package _49_소수_찾기;

//소수 찾기
//        문제 설명
//        1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
//
//        소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
//        (1은 소수가 아닙니다.)
//
//        제한 조건
//        n은 2이상 1000000이하의 자연수입니다.
//        입출력 예
//        n	result
//        10	4
//        5	3
//        입출력 예 설명
//        입출력 예 #1
//        1부터 10 사이의 소수는 [2,3,5,7] 4개가 존재하므로 4를 반환
//
//        입출력 예 #2
//        1부터 5 사이의 소수는 [2,3,5] 3개가 존재하므로 3를 반환

class Solution {
    public int solution(int n) {
        int answer = 0;
        //전체 약수 구하기
        for(int i = 0; i <= n ;i++) {
           if(make_prime(i)){
               answer++;
           };
        }

        return answer;
    }

    //약수를 구하는 함수
    private boolean make_prime(int num){
        // 0 과 1 은 소수가 아니므로 종료
        if(num < 2) {
            return false;
        }

        // 2 는 소수다
        if(num == 2) {
            System.out.println(num);
            return true;
        }

        // 제곱근 함수 : Math.sqrt()
        for(int i = 2; i <= Math.sqrt(num); i++) {

            // 소수가 아닐경우 종료
            if(num % i == 0) {
                return false;
            }
        }
        // 위 반복문에서 약수를 갖고 있지 않는경우 소수다.
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 10;
        System.out.println(solution.solution(n));
    }

// 2중for문 효율성 테스트 실패...
//        for (int i = 2; i <= n; i++) {
//            int tempNum = 0;
//            for (int j = 1; j <= n; j++) {
//                if (i % j == 0) {
//                    tempNum++;
//                }
//            }
//            if (tempNum == 2) {
//                answer ++;
//            }
//        }

}
