package javaPrac.조건문과_반복문._while;

public class FlowEx30 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 0;

        while(true) {
            if(sum > 100)
                break;
            ++i;
            sum += i;
        }// end of while
        System.out.println("i = "+i);
        System.out.println("sum = "+sum);
    }
}
