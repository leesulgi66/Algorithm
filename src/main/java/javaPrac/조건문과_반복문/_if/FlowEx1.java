package javaPrac.조건문과_반복문._if;

public class FlowEx1 {
    public static void main(String[] args) {
        int x = 0;
        System.out.printf("x=%d 일 때, 참인것은 %n", x);

        if(x==0) System.out.println("x==0");
        if(x!=0) System.out.println("x!=0");
        if(!(x==0)) System.out.println("! (x==0)");
        if(!(x!=0)) System.out.println("!(x!=0)");

        x = 1;
        System.out.printf("x=%d 일 때, 참인것은 %n", x);

        if(x==0) System.out.println("x==0");
        if(x!=0) System.out.println("x!=0");
        if(!(x==0)) System.out.println("! (x==0)");
        if(!(x!=0)) System.out.println("!(x!=0)");
    }
}
