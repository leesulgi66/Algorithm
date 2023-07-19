package Algorithm._코딩테스트_문제풀이._07_스택__스택으로_수열_만들기;

import java.util.Scanner;
import java.util.Stack;

public class P1874_스택수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        StringBuffer bf = new StringBuffer();
        for(int i=0; i<A.length; i++) {
            int su = A[i];
            if(su >= num) {
                while(su >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }
            else {
                int n = stack.pop();
                if(n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                }else {
                    bf.append("-\n");
                }
            }
        }
        if(result) System.out.println(bf);
    }
}
