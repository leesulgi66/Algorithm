package javaPrac.ch07_object_oriented_programming2._03_package_and_import;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ImportTest {
    public static void main(String[] args) {
        Date today = new Date();

        SimpleDateFormat date = new SimpleDateFormat("yyy/MM/dd");
        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");

        System.out.println("오늘 날짜는 "+date.format(today));
        System.out.println("현재 시간은 "+time.format(today));
    }
}
