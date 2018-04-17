package fx.just;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import util.TumbrJsonUtil;

import java.util.List;

public class PageXPic {
    public static String url = "E:/tumblr/pantyhoseinnylons.txt_json1.txt";
// http://tgp.pantyhoseinnylons.com/09/02fZ99/photos/010pn-angel.jpg
    public static void main(String[] args) {
        try {
            List<String> stringList = TumbrJsonUtil.getStringsFromTxt(url);
            for (String s : stringList) {
                s = s.substring(0,s.indexOf("index"));
                if (!s.equals("")) {
                    for (int i = 1; i <= 16; i++) {
                        String st = "";
                        if (i < 10) {
                            st = "0";
                        }
                        System.out.println(s + "photos/0"+st+i+"pn-angel.jpg");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
