package javaPrac.control_statement._for;

public class FlowEx14 {
    public static void main(String[] args) {
        for(int i=1, j=10; i<=10; i++, j--) {
            System.out.printf("%d \t %d%n", i, j);
        }

        // 하나의 변수로 똑같이 출력
        for(int i=1; i<=10; i++) {
            System.out.printf("%d \t %d%n", i, 11-i);
        }
    }
}
