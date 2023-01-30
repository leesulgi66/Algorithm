package javaPrac.ch05_array.string_array;

//https://www.youtube.com/watch?v=8yjC3t7j-eg&ab_channel=%EB%82%A8%EA%B6%81%EC%84%B1%EC%9D%98%EC%A0%95%EC%84%9D%EC%BD%94%EB%94%A9

public class ArrayEx16 {
    public static void main(String[] args) {
        System.out.println("매개변수의 개수 : "+args.length);
        for(int i=0; i<args.length; i++) {
            System.out.println("args["+i+"] = \""+ args[i] + "\"");
        }
    }
}
