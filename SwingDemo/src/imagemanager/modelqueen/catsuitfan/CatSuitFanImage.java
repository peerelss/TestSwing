package imagemanager.modelqueen.catsuitfan;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.TumbrJsonUtil;

/**
 * Created by kevin on 2017/9/16.
 */
public class CatSuitFanImage {
    public static String url = "https://catsuitfan.wordpress.com/2016/10/07/2924/";
    public static String mFileName = "CatSuitFan_image";

    public static void main(String[] args) {
        getPicFromUrl(url);
    }
    public static void getPicFromUrl(String url){
        try {
            StringBuffer sb=new StringBuffer();
            Document document = Jsoup.connect(url).get();
            Elements elements = document.getElementsByTag("img");
            for (Element element : elements) {
                if (element.toString().contains("data-orig-file")) {
                    String str = element.attr("data-orig-file");
                    sb.append(str+"\n");
            //        System.out.println("jpg = " + str);
                }
            }
            sb.append("\n\n");
            TumbrJsonUtil.putStringToTxt(mFileName,sb.toString());
            Element element=document.getElementsByClass("nav-previous").first();
            Element element1=element.getElementsByTag("a").first();
          //  System.out.println(" doc = "+element.toString());
            String nextUrl=element1.attr("href");
            System.out.println(" next url = "+nextUrl);
            getPicFromUrl(nextUrl);
        } catch (Exception e) {
            System.out.println(" error = " + url);
            e.printStackTrace();
        }
    }
}
