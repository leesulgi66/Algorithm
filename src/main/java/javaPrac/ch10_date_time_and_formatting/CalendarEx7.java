package javaPrac.ch10_date_time_and_formatting;

import java.util.Calendar;

public class CalendarEx7 {
    public static void main(String[] args) {
        int year = 2023;
        int month = 3;

        Calendar sDay = Calendar.getInstance();     // 시작일
        Calendar eDay = Calendar.getInstance();     // 끝일

        // 월의 경우 0 부터 11까지의 값을 가지므로 1을 빼주어야 한다.
        // 예를들어, 2015년 11월 1일은 sDay.set(2015,10,1);과 같이 해줘야 한다.
        sDay.set(year, month-1, 1);
        // 입력월의 말일로 설정한다.
        eDay.set(year, month -1, sDay.getActualMaximum(Calendar.DATE));
        // 1일이 속한 주이 일요일로 날짜 선정.
        sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK)+1);
        // 말일이 속한 주의 일요일로 날짜 선정.
        eDay.add(Calendar.DATE, 7 - eDay.get(Calendar.DAY_OF_WEEK));

        System.out.println("        "+year+"년 "+month+"월");
        System.out.println("  SU  MO  TU  WE  TH  FR  SA");

        // 시작 일부터 마지막 일까지(sDay <= eDay) 1일씩 증가시키면서 일(Calendar.DATE)을 출력
        for(int n=1; sDay.before(eDay) || sDay.equals(eDay); sDay.add(Calendar.DATE, 1)) {
            int day = sDay.get(Calendar.DATE);
            System.out.print((day < 10) ? "   "+day : "  "+day);
            if(n++%7 == 0)System.out.println(); // 7일치를 찍고 나서 줄을 바꾼다.
        }
    }
}
