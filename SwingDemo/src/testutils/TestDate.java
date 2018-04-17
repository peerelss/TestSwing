package testutils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kevin on 2017/2/7.
 */
public class TestDate {
    public static void main(String[] args){
        System.out.println(" date = "+dateToStr(getNow()));
    }
    public static Date getNow() {
        Date currentTime = new Date();
        return currentTime;
    }
    public static String dateToStr(java.util.Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(dateDate);
        return dateString;
    }
}
