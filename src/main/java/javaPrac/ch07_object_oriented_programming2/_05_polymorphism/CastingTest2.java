package javaPrac.ch07_object_oriented_programming2._05_polymorphism;

public class CastingTest2 {
    public static void main(String[] args) {
        Car car = new Car();
        Car car2 = null;
        FireEngine fe = null;

        car.drive();
        fe = (FireEngine) car;  // 컴파일은 OK. 실행시 에러가 발생. (조상타입의 인스턴스를 자손타입의 참조변수로 참조하는 것은 허용되지 않는다.)
        fe.drive();
        car2 = fe;
        car2.drive();
    }
}
