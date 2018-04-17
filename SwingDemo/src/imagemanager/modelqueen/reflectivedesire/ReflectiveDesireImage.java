package imagemanager.modelqueen.reflectivedesire;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.TumbrJsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2017/12/9.
 */
public class ReflectiveDesireImage {
    public static String url = "https://reflectivedesire.com/photos/";
    public static String dom = "https://reflectivedesire.com";
    public static List<String> stringList = new ArrayList<>();

    public static void main(String[] args) {
        findImageFromUrl("https://reflectivedesire.com/photos/grey/");
        if(true){
            return;
        }
        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.getElementsByTag("a");
            for (Element element : elements) {
                String str = element.attr("href");
                if (str != null && str.contains("photos")) {
                    stringList.add(str);
                }
            }
            for(int i=0;i<stringList.size();i++){
                findImageFromUrl(dom+stringList.get(i));
            }
        /*    findImageFromUrl("https://reflectivedesire.com/photos/grey/");
            findImageFromUrl("https://reflectivedesire.com/photos/seattle-siren/");*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void findImageFromUrl(String url) {
        System.out.println("url = "+url);
        StringBuffer sb=new StringBuffer();
        try {
            Document document = Jsoup.connect(url).get();
            Elements elements=document.getElementsByTag("img");
            for(Element element:elements){
                String str=element.attr("src");
                sb.append(str+"\n");
            }
        } catch (Exception e) {
            System.out.println("error url  = "+url);
        }
        TumbrJsonUtil.putStringToTxt("reflectivedesire",sb.toString()+"\n");
    }
}
