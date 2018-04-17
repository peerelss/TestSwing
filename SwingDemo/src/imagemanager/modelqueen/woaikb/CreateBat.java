package imagemanager.modelqueen.woaikb;

import util.TumbrJsonUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by kevin on 2017/9/23.
 */
public class CreateBat {
    public static String CURL = "curl -o JPG_URL URL";

    public static void main(String[] args) {
        File file = new File("J:\\java\\0906\\result.txt");
        String name = "woaikb";
        BufferedReader reader = null;
        String temp = null;
        int line = 1;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((temp = reader.readLine()) != null) {
                if (temp.endsWith(".jpg")) {
                    TumbrJsonUtil.putStringToTxt(name,format(temp));
                    line++;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String format(String str) {
        System.out.println(str);
        String temp = str.substring(str.lastIndexOf("/")+1, str.indexOf(".jpg") + 4);
        return CURL.replace("JPG_URL", temp).replace("URL",str);
    }
}
