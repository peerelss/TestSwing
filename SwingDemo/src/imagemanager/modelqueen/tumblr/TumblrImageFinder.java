package imagemanager.modelqueen.tumblr;

import imagemanager.utils.OkHttpUtilKevin;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.TumbrJsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2017/11/4.
 */
public class TumblrImageFinder {
    public static String url = "https://gigilica.tumblr.com/page/index";
    public static String name = "0117"+"gigilica";
    public static String frameName = "https://gigilica.tumblr.com";
    public static List<String> errorList = new ArrayList<>();
    public static List<String> frameList = new ArrayList<>();
    public static void main(String[] args) {
        for (int i = 1; i <= 150; i++) {
            String result = OkHttpUtilKevin.getStringFromUrlWithProxyTumblr(url.replace("index", i + ""));
            System.out.println("current index = " + i);
            if (null == result || "".equals(result)) {
            //    errorList.add(i + "");
            } else {
             //   System.out.println("result = "+result);
                getPicFromString(result);
                getFrameFromString(result);
            }
        }
        for (int i = 0; i < errorList.size(); i++) {
            String result = OkHttpUtilKevin.getStringFromUrlWithProxyTumblr(url.replace("index", errorList.get(i)));
            System.out.println("current error index = " + errorList.get(i));
            if (null == result || "".equals(result)) {
                errorList.add(i + "");
            } else {
                getPicFromString(result);
                getFrameFromString(result);
            }
        }
        for (int i = 0; i < frameList.size(); i++) {
            String result = OkHttpUtilKevin.getStringFromUrlWithProxyTumblr(frameList.get(i));
            System.out.println("current frame = " + frameList.get(i));
            if (null == result || "".equals(result)) {
                frameList.add(frameList.get(i));
            } else {
                getPicFromString(result);
                //    getFrameFromString(result);
            }
        }
    }

    public static void getPicFromString(String result) {
        StringBuffer sb = new StringBuffer();
        Document document = Jsoup.parse(result);
        Elements elements = document.getElementsByTag("img");
        for (Element element : elements) {
            String s = element.attr("src");
            if (null != s && !"".equals(s)) {
                if (s.endsWith(".jpg") || s.endsWith("gif") || s.endsWith("png")) {
                    if (!s.contains("avatar")) {
                        s=TumbrJsonUtil.formatString(s);
                        sb.append(s + "\n");
                        System.out.println(s);
                    }
                }

            }
        }
        TumbrJsonUtil.putStringToTxt(name, sb.toString() + "\n\n");
    }

    public static void getFrameFromString(String result) {
        Document document = Jsoup.parse(result);
        Elements elements = document.getElementsByTag("iframe");
        for (Element element : elements) {
            String s = element.attr("src");
            if (null != s && !"".equals(s) && s.contains("photoset")) {
                frameList.add(frameName + s);
                System.out.println("frame = " + frameName + s);
            }
        }
    }

    public static void get() {

    }
}
