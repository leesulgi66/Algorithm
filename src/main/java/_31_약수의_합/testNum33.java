package _31_약수의_합;

public class testNum33 {
    //약수의 합
    //https://programmers.co.kr/learn/courses/30/lessons/12928
    public int solution(int n) {
        int answer = 0;

        for(int i=1; i < n+1; i++){
            if(n%i == 0){
                answer += i;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        testNum33 testNum33 = new testNum33();
        int result = testNum33.solution(12);
        System.out.println(result);
    }
}
