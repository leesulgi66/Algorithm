package javaPrac.조건문과_반복문._while;

public class FlowEx31 {
    public static void main(String[] agrs) {
        for(int i=0; i <=10; i++) {
            if(i%3==0)
                continue;
            System.out.println(i);
        }
    }
}
