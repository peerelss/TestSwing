package imagemanager.modelqueen.bt.search;

import imagemanager.utils.OkHttpUtilKevin;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.TumbrJsonUtil;

import java.util.ArrayList;
import java.util.List;
///DD06C4FBB6D67591E32B82ED34D4FEC285B48D9A.html

/**
 * Created by kevin on 2017/12/23.
 */
public class StoreBtManager {
    public static String url = "https://www.btexe66.com/search/slimewave_ctime_INDEX.html";
    public static String file_name="btexe66_"+"slimewave";
    public static List<String> strings=new ArrayList<>();
    public static void main(String[] args) {
        for(int i=1;i<=38;i++){
            getMagnetFromUrl(url.replace("INDEX",i+""));
        }
    //    getMagnetFromUrl(url);
        for(int i=0;i<strings.size();i++){
            getMagnetFromUrl(strings.get(i));
        }
    }

    public static void getMagnetFromUrl(String url) {
        StringBuffer sb=new StringBuffer();
        try {
        //    String source = OkHttpUtilKevin.getStringFromUrl(url);
            sb.append(url+"\n");
            Document document = Jsoup.connect(url).get();
            Elements elements = document.getElementsByTag("a");
            for (Element element : elements) {
                String magnetUrl = element.attr("href");
                if(magnetUrl.length()==46){
                    String title=element.html().replace("<span class=\"highlight\">","").replace("</span>","");
                    magnetUrl=magnetUrl.replace("/","magnet:?xt=urn:btih:").replace(".html","");
                    System.out.println(magnetUrl+  "  "+title);
                    sb.append(title+"\n"+magnetUrl+"\n");
                }
            }
            TumbrJsonUtil.putStringToTxt(file_name,sb.toString()+"\n\n");
        } catch (Exception e) {
            System.out.println("error = "+url);
            strings.add(url);
        }
    }
}
