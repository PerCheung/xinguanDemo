package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串和时间互相转换的工具类
 *
 * @author Peter Cheung
 * @user PerCheung
 * @date 2021/12/16 19:32
 */
public class DateUtil {
    //日期转换为字符串
    public static String dateToString(Date date) {
        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return smf.format(date);
    }

    //字符串转换为日期
    public static Date stringToDate(String str) throws ParseException {
        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return smf.parse("str");
    }
}
