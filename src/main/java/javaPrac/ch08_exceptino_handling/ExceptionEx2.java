package javaPrac.ch08_exceptino_handling;

public class ExceptionEx2 {
    public static void main(String[] args) {
        int number = 100;
        int result = 0;

        for(int i=0; i<10; i++) {
            //result = number / (int)(Math.random() * 10);   <- 실수를 0으로 나눌 수 없기 때문에 오류가 난다.
            System.out.println(result);
        }
    }
}
