package ligui;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2017/8/23.
 */
public class LiGuiImageFinder {
    public static String INDEX_PAGE = "INDEX_PAGE";
    public static String URL = "http://www.ligui.org/toutiaonvshen/8954" + INDEX_PAGE + ".html";
    public static List<String> list = new ArrayList<>();
    public static String ID = "img_view";
    public final static String pre = "";
    public static String[] urls={"http://www.ligui.org/ligui/3519.html",
            "http://www.ligui.org/ligui/3571.html",
            "http://www.ligui.org/ligui/3568.html",
            "http://www.ligui.org/ligui/3565.html",
            "http://www.ligui.org/ligui/3537.html",
            "http://www.ligui.org/ligui/3579.html",
            "http://www.ligui.org/ligui/3534.html",
            "http://www.ligui.org/ligui/3595.html",
            "http://www.ligui.org/ligui/3630.html",
            "http://www.ligui.org/ligui/3639.html",
            "http://www.ligui.org/ligui/3740.html",
            "http://www.ligui.org/ligui/3662.html",
            "http://www.ligui.org/ligui/3734.html",
            "http://www.ligui.org/ligui/3713.html",
            "http://www.ligui.org/ligui/3710.html",
            "http://www.ligui.org/ligui/3707.html",
            "http://www.ligui.org/ligui/3752.html",
            "http://www.ligui.org/ligui/3746.html",
            "http://www.ligui.org/ligui/3755.html",
            "http://www.ligui.org/ligui/3761.html",
            "http://www.ligui.org/ligui/3765.html",
            "http://www.ligui.org/aiyouwu/525.html",
            "http://www.ligui.org/aiyouwu/576.html",
            "http://www.ligui.org/aiyouwu/440.html",
            "http://www.ligui.org/aiyouwu/467.html",
            "http://www.ligui.org/aiyouwu/380.html",
            "http://www.ligui.org/aiyouwu/391.html",
            "http://www.ligui.org/aiyouwu/360.html",
            "http://www.ligui.org/aiyouwu/373.html",
            "http://www.ligui.org/aiyouwu/334.html",
            "http://www.ligui.org/aiyouwu/213.html"};
    public static void main(String[] args) {
        for (int i = 0; i <urls.length; i++) {
            list.add(urls[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (str == null || "".equals(str)) {

            } else {
                int max=    getIndexFromUrl(pre+str);
                String tag = getPageName(pre+str);
                String cata=getCata(pre+str);

                URL="http://www.ligui.org/"+cata+"/"+tag+INDEX_PAGE+".html";
                System.out.println("max  = "+max);
                for(int j=2;j<=max;j++){
                    getPictureFromUrl(URL.replace(INDEX_PAGE,"_"+j));
                }
            }
        }
    }
    public static String getCata(String str){
        String s=str.substring(str.indexOf("org")+4,str.lastIndexOf("/"));
        return s;
    }
    public static void getUrlFromUrl(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            Elements links = document.select("a[href]");
            for (Element element : links) {
                String str = element.attr("href");
                if (str.contains("aiss") && str.contains("html")) {
                    list.add(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getIndexFromUrl(String url) {
        int max=0;
        try {
            String tag = getPageName(url);
            Document document = Jsoup.connect(url).get();
            Elements links = document.select("a[href]");
            for (Element element : links) {
                String str = element.attr("href");
                if (str.contains(tag) && str.contains("html")) {
                    String s = str.substring(str.indexOf(tag)+tag.length()+1, str.indexOf(".html"));
                    int i=Integer.valueOf(s);
                    if(i>max){
                        max=i;
                    }
                }
            }
            return max;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String getPageName(String url) {
        String s = url;
        String s1 = s.substring(s.lastIndexOf("/") + 1, s.indexOf(".html"));
        return s1;
    }

    public static String getPictureFromUrl(String url) {
        try{
            Document doc = Jsoup.connect(url).get();
            Element element=doc.getElementById(ID);
            Elements elements=element.getElementsByTag("img");
            for(Element element1 : elements) {
                String imgSrc=element1.attr("src"); //获取src属性的值
                System.out.println(imgSrc);
            }
        }catch (Exception e){
            //e.printStackTrace();
            System.out.println("url = "+url+" error");
        }
        return "";
    }

}
