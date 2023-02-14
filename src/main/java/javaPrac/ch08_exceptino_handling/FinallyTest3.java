package javaPrac.ch08_exceptino_handling;

public class FinallyTest3 {
    public static void main(String[] args) {
        // method1()은 static메서드이므로 인스턴스 생성없이 직첩 호출이 가능하다.
        FinallyTest3.method1();
        System.out.println("method1()의 수행을 마치고 main메서드로 돌아왔습니다.");
    }
    static void method1() {
        try{
            System.out.println("method1()이 호출되었습니다.");
            return; // 현재 실행 중인 메서드를 종료한다.
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("method1()의 finally블럭이 실행되었습니다.");
            // 앞에서 리턴문을 만나 함수가 종료되었지만 finally블럭은 실행이 된다!
        }
    }
}
