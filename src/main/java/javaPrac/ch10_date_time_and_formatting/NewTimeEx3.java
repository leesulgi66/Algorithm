package javaPrac.ch10_date_time_and_formatting;

import java.time.*;
import java.time.temporal.*;
import static java.time.DayOfWeek.*;
import static java.time.temporal.TemporalAdjuster.*;

class DayAfterTomorrow implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        return temporal.plus(2, ChronoUnit.DAYS);
    }
}

class NewTimeEx3 {
    public static void main(String[] args) {
        //LocalDate today = LocalDate.now();    // 현재 시간
        LocalDate today = LocalDate.of(2015,12,15); // 예제의 시간으로 셋팅
        LocalDate date = today.with(new DayAfterTomorrow());

        p(today); // System.out.println(today);
        p(date);
        p(today.with(TemporalAdjusters.firstDayOfNextMonth())); // 다음 달의 첫 날
        p(today.with(TemporalAdjusters.firstDayOfMonth())); // 이 달의 첫 날
        p(today.with(TemporalAdjusters.lastDayOfMonth())); // 이 달의 마지막 날
        p(today.with(TemporalAdjusters.firstInMonth(TUESDAY))); // 이 달의 첫번째 화요일
        p(today.with(TemporalAdjusters.lastInMonth(TUESDAY))); // 이 달의 마지막 화요일
        p(today.with(TemporalAdjusters.previous(TUESDAY))); // 지난 주 화요일
        p(today.with(TemporalAdjusters.previousOrSame(TUESDAY))); // 지난 주 화요일(오늘 포함)
        p(today.with(TemporalAdjusters.next(TUESDAY))); // 다음 주 화요일
        p(today.with(TemporalAdjusters.nextOrSame(TUESDAY))); // 다음 주 화요일(오늘 포함)
        p(today.with(TemporalAdjusters.dayOfWeekInMonth(4,TUESDAY))); // 이 달의 4번째 화요일
    }

    static void p(Object obj) {
        System.out.println(obj);
    }
}
