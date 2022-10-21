package _25_정수_제곱근_판별;

public class testNum25 {
    public static void main(String[] args) {
        long n = 121;
        // 정수 제곱근 판별
        long answer = (long)Math.sqrt(n);
        if (answer * answer == n){
            answer = (answer+1) * (answer+1);
            System.out.println(answer);
        }else{
            answer = -1;
            System.out.println(answer);
        }
    }
}
