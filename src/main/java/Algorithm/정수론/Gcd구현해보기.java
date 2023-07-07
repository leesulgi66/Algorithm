package Algorithm.정수론;

import java.util.Scanner;

public class Gcd구현해보기 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int answer = gcd(a, b);

        System.out.println(answer);
    }

    private static int gcd(int a, int b) {
        if(a % b == 0) {
            return b;
        }

        int temp = a%b;
        a = b;
        b = temp;
        return gcd(a, b);
    }


}
