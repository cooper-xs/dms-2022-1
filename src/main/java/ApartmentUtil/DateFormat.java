package ApartmentUtil;

import Ex.TimeIllegalException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    // 当前时间 转换为 yyyy-MM-dd hh:mm:ss
    public static String nowToDateTime() {
        String strDate;
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        strDate = simpleDateFormat.format(date);
        return strDate;
    }

    // 年月日 转化为 数据库中的格式
    public static String timeToSave(String year, String month, String day) throws ParseException, TimeIllegalException {
        String strDate;
        if(! illegalTime(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)) | year.length() != 4 | month.length() != 2 | day.length() != 2) {
            throw new TimeIllegalException();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(year + month + day);
        strDate = simpleDateFormat.format(date);
        return strDate;
    }

    // 日期合法
    public static boolean illegalTime(int year, int month, int day) {
        if(month == 1 | month == 3 | month == 5 | month == 7 | month == 8 | month == 10 | month == 12) {
            return day >= 1 & day <= 31;
        } else if(month == 4 | month == 6 | month == 9 | month == 11) {
            return day >= 1 & day <= 30;
        } else if(month == 2){
            if(year % 400 == 0 | (year % 4 == 0 & year % 100 != 0)) {
                return day >= 1 & day <= 29;
            } else {
                return day >= 1 & day <= 28;
            }
        } else {
            return false;
        }
    }
}
