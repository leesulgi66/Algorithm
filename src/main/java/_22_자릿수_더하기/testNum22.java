package _22_자릿수_더하기;

public class testNum22 {
    public static void main(String[] args) {
        int n = 123;
        //자릿수 더하기
        int answer = 0;
        while (n > 0){
            answer += n%10;
            n/=10;
        }
        System.out.println(answer);
    }
}
