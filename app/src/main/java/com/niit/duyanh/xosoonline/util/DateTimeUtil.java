package com.niit.duyanh.xosoonline.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Duy Anh on 10/08/2016.
 */
public class DateTimeUtil {

    /**
     * created by Duy Anh on 11/08/2016
     *
     * @param fromdate
     * @param todate
     * @return
     */
    public static ArrayList<String> getMutilDate(Date fromdate, Date todate) {

        ArrayList<String> result = new ArrayList<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        while (true) {
            String str = dateFormat.format(fromdate);

            result.add(str);

            Calendar calendar = Calendar.getInstance();

            calendar.setTime(fromdate);

            calendar.add(calendar.DATE, 1);

            fromdate = calendar.getTime();

            if (fromdate.compareTo(todate) > 0) {
                break;
            }
        }
        return result;
    }

    /**
     * created by Duy Anh on 16/08/2016
     * <p/>
     * lấy thứ
     *
     * @param date
     * @return
     */
    public static String getDayOfWeek(Date date) {
        String result = "";
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        calendar.setTime(date);

        int day = calendar.get(Calendar.DAY_OF_WEEK);

        switch (day) {
            case Calendar.MONDAY:
                result += "Thứ 2";
                break;
            case Calendar.TUESDAY:
                result += "Thứ 3";
                break;
            case Calendar.WEDNESDAY:
                result += "Thứ 4";
                break;
            case Calendar.THURSDAY:
                result += "Thứ 5";
                break;
            case Calendar.FRIDAY:
                result += "Thứ 6";
                break;
            case Calendar.SATURDAY:
                result += "Thứ 7";
                break;
            case Calendar.SUNDAY:
                result += "Chủ Nhật";
                break;
        }

        result += "-" + dateFormat.format(date);

        return result;
    }

}
