package javaPrac.ch07_object_oriented_programming2._02_overriding;

public class PointTest {
    public static void main(String[] args) {
        Point3D p3 = new Point3D(1,2,3);
        System.out.println(p3.getLocation());
    }
}

class Point {
    int x, y;

    Point() {}

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    String getLocation() {
        return "x : "+x+", y : "+y;
    }
}

class Point3D extends Point {
    int z;
    Point3D(int x, int y, int z) {
        super();   //<------- 생성자 첫 줄에서 다른 생성자를 호출하지 않기 때문에 컴파일러가 'super();'를 여기에 삽입한다. super()는 Point클래스의 기본 생성자인 Point()를 의미한다.
        //super(x, y);  이처럼 조상클래스의 생성자 Point(int x, int y)를 호출해서 사용가능하다.
        this.x = x;
        this.y = y;
        this.z = z;
    }

    String getLocation() {
        return "x : "+x+", y : "+y+", z : "+z;
    }
}
