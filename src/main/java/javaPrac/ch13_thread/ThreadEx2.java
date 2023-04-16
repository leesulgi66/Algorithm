package javaPrac.ch13_thread;

public class ThreadEx2 {
    public static void main(String[] args) throws Exception {
        ThreadEx2_1 t1 = new ThreadEx2_1();
        t1.start();
        // 호출스택의 첫 번째 메서드가 main메서드가 아니라 run 메서드인 것을 확인.
    }
}

class ThreadEx2_1 extends Thread {
    public void run() {
        throwException();
    }

    public void throwException() {
        try {
            throw new Exception();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
