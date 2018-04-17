package imagemanager.modelqueen.enbte;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.TumbrJsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2017/12/17.
 */
public class EnbteMagnetManger {
    public static String url="http://www.enbte.com/Search/jewell+marceau/index.html";
    public static String file_name="marceau";
    public static List<String> strings=new ArrayList<>();
    public static void main(String[] args){
        for(int i=1;i<=5;i++){
            getMagnetFromUri(url.replace("index",i+""));
        }
        for(int i=0;i<strings.size();i++){
            getMagnetFromUri(strings.get(i));
        }
    }
    private static void getMagnetFromUri(String s_url){
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(s_url+"\n");
        try{
            Document document= Jsoup.connect(s_url).get();
            Elements elements=document.getElementsByTag("a");
            for(Element element:elements){
                String url=element.attr("href");
                if(url.contains("detail")){
                    url=url.replace(".html","").replace("/detail/","magnet:?xt=urn:btih:");
                    String title=element.attr("title").replace("<em>","").replace("</em>","");
                    System.out.println("url = "+url);
                    System.out.println("title = "+title);
                    stringBuffer.append(url+"\n");
                    stringBuffer.append(title+"\n");
                }

            }
            TumbrJsonUtil.putStringToTxt(file_name,stringBuffer.toString()+"\n\n");
        }catch (Exception e){
            System.out.println("error = "+s_url);
            strings.add(s_url);
        }

    }
}
