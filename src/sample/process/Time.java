package sample.process;

import sun.util.resources.CalendarData;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Time {
    private static final Calendar calendar = new GregorianCalendar(2017, Calendar.MAY , 25);
    private static int prevMonth = calendar.get(Calendar.MONTH);

    static void tick() {
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        if (prevMonth!=calendar.get(Calendar.MONTH)) {
            MainData.monthPassed=true;
            prevMonth=calendar.get(Calendar.MONTH);
        } else MainData.monthPassed=false;
    }   // + 1 мин за сек

    public static String getTime() {    // получить игровое время

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);

        return (day+" / "+month);
    }

    public static int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

}
