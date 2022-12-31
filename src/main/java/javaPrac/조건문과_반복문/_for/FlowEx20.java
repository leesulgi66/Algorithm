package javaPrac.조건문과_반복문._for;

public class FlowEx20 {
    public static void main(String[] agrs) {
        for(int i=1; i<=5; i++) {
            for(int j=1; j<=5; j++) {
                System.out.printf("[%d, %d]", i,j);
            }
            System.out.println();
        }
    }
}
