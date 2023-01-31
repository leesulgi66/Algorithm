package javaPrac.ch07_object_oriented_programming2._01_inheritance;

class TV{
    boolean power;  // 전원상태(on/off)
    int channel;    // 채널

    void power() { power = !power; }
    void channelUp() { ++channel; }
    void channelDown() { --channel; }
}

class VCR {
    boolean power;  // 전원상태(on/off)
    int counter = 0;
    void power() { power = !power; }
    void play() {}
    void stop() {}
    void rew() {}
    void ff() {}
}

class TVCR extends Tv {
    VCR vcr = new VCR();

    void play() {
        vcr.play();
    }

    void stop() {
        vcr.stop();
    }

    void rew() {
        vcr.rew();
    }

    void ff() {
        vcr.ff();
    }
}
