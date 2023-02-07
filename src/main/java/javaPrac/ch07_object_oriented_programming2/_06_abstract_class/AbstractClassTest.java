package javaPrac.ch07_object_oriented_programming2._06_abstract_class;

abstract class AbstractClassTest {
    abstract void play(int pos);
    abstract void stop();
}

class AudioPlayer extends AbstractClassTest {
    void play(int pos) {
        // 구현 될 내용 오버라이딩
    }
    void stop() {
        // 구현 될 내용 오버라이딩
    }
}

// 추상화 : 클래스간의 공통점을 찾아내서 공통의 조상을 만드는 작업
// 구체화 : 상속을 통해 클래스를 구현, 확장하는 작업.