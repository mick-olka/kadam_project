package sample.process;

import java.util.Date;

public class Time {
    static Date dt = new Date(2014, 0, 0, 23, 50);  // выставить дату и время

    static void tick() {
        dt.setTime(dt.getTime()+60000);
    }   // + 1 мин за сек

    public static String getTime() {    // получить игровое время
        int h =dt.getHours();
        int m =dt.getMinutes();
        String h0;
        String m0;
        if (h<10) h0="0"+h;
        else h0=""+h;
        if (m<10) m0="0"+m;
        else m0=""+m;
        return (h0+":"+m0);
    }

}
