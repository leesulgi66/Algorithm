package javaPrac.ch07_object_oriented_programming2._06_abstract_class.abstract_player;

public class CDPlayer extends Player{
    void play(int currentPot) {
        // 조상의 추상메서드를 구현. 내용 생략
    }
    void stop() {
        // 조상의 추상메서드를 구현. 내용 생략
    }

    // CDPlayer클래스에 추가로 정의된 멤버
    int currentTrack;   // 현재 재생중인 트랙

    void nextTrack() {
        currentTrack++;
    }

    void preTrack() {
        if(currentTrack > 1) {
            currentTrack--;
        }
    }
}
