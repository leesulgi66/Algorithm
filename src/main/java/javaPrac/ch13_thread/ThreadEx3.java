package javaPrac.ch13_thread;

public class ThreadEx3 {
    public static void main(String[] args) {
        ThreadEx3_1 t1 = new ThreadEx3_1();
        t1.run();
        // 이전 예제와 달리 쓰레드가 새로 생성되지 않았다.그저 ThreadEx3_1클래스의 run()이 호출되었을 뿐이다.
        // ThreadEx2와는 다르게 main 메서드가 포함되어 있음.
    }
}

class ThreadEx3_1 extends Thread {
    public void run() {
        throwException();
    }

    public void throwException() {
        try {
            throw new Exception();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
