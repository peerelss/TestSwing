package fx.just;

import fx.manager.TumblrPageManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.TumbrJsonUtil;
//https://justpicsplease.com/photos/pantyhoseinnylons/5?_=1519535258457
public class TestJust {
    public static String S_name="l.html";
    public static long String_id=1519535*1000000+258452;
    static String url="curl \"https://justpicsplease.com/photos/pantyhoseinnylons/INDEX\" -o l.html -H \"Accept: text/html, */*; q=0.01\" --compressed -H \"Accept-Language: en-US,en;q=0.5\" -H \"Connection: keep-alive\" -H \"Cookie: is_mobile=0; check=true; __atuvc=2\"%\"7C9; __atuvs=5a92589656a6c5ff001; __atssc=google\"%\"3B1; _ga=GA1.2.168042942.1519540380; _gid=GA1.2.234836417.1519540380; _gat=1; organic_search=0; session_id=1148587494; added=1\" -H \"Host: justpicsplease.com\" -H \"Referer: https://justpicsplease.com/photos/legsworld\" -H \"User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:59.0) Gecko/20100101 Firefox/59.0\" -H \"X-Requested-With: XMLHttpRequest\"";
    public static void main(String[] arg){
        for(int i=1;i<10000;i++){
            System.out.println(" running = "+i);
            TumblrPageManager.putString2Txt(url.replace("INDEX",createId(i)));
            txt2String();
        }
     //   TumblrPageManager.putString2Txt(url);

    }
    public static String createId(int i){
        String s=i+"?_"+(String_id+i);
        return s;
    }
    public static void txt2String(){
        String re="";
        StringBuffer sb=new StringBuffer();
        String result = TumbrJsonUtil.getStringFromTxt(S_name);
        try{
            Document document= Jsoup.parse(result);
            Elements elements=document.getElementsByTag("a");
            for(Element element:elements){
                String url=element.attr("href");
                if(url.contains("http://tgp.pantyhoseinnylons.com")){
                    sb.append("\n"+url);
                    System.out.println(url);
                }

            }
            TumbrJsonUtil.putStringToTxt("pantyhoseinnylons.txt", sb.toString() + "\n\n");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
