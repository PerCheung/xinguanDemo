package util;

/**
 * 判断控制台输入字符是否为正整数的工具类
 *
 * @author Peter Cheung
 * @user PerCheung
 * @date 2021/12/16 23:44
 */
public class IsNumberUtil {
    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
