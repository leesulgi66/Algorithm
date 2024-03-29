package javaPrac.ch07_object_oriented_programming2._06_abstract_class.abstract_player;

abstract class Player {
    boolean pause;  // 일시정지 상태를 저장하기 위한 변수
    int currentPos; // 현재 Play되고 있는 위치를 저장하기 위한 변수

    Player() {  // 추상클래스도 생성자가 있어야 한다.
        pause = false;
        currentPos = 0;
    }
    // 지정된 위치(pos)에서 재생을 시작하는 기능이 수행하도록 작성되어야 한다.
    abstract void play(int pos);    // 추상 메서드
    // 재생을 즉시 멈추는 기능을 수행하도록 작성되어야 한다.
    abstract void stop();   // 추상 메서드

    void play() {
        play(currentPos);   // 추상메서드를 상요할 수 있다.
    }
    void pause() {
        if(pause) { // pause가 true일 때(정지상태)에서 pause가 호출되면,
            pause = false;  // pause의 상태를 false로 바꾸고,
            play(currentPos);   // 현재의 위치에서 Play를 한다.
        } else {    // pause가 false일 때(play상태)에서 pause가 호출되면,
            pause = true;
            stop();
        }
    }
}
