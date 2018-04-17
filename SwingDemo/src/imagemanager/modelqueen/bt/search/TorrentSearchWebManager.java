package imagemanager.modelqueen.bt.search;

import imagemanager.utils.OkHttpUtilKevin;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.TumbrJsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2017/12/23.
 */
public class TorrentSearchWebManager {
    public static String url="http://torrentsearchweb.pw/Gwenmedia/index-2-0/";
    public static String file_name="TorrentSearchWebManager_"+"Gwenmedia";
    public static List<String> strings=new ArrayList<>();
    public static void main(String[] args){
        for(int i=1;i<=16;i++){
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
            String source= OkHttpUtilKevin.getStringFromUrl(url);
            if(!"".equals(source)){
                Document document= Jsoup.parse(source);
                Elements elements=document.getElementsByTag("a");
                for(Element element:elements){
                    String url=element.attr("href");
                    if(url.contains("magnet")){
                        System.out.println("url = "+url);
                        stringBuffer.append(url+"\n");
                    }

                }
                TumbrJsonUtil.putStringToTxt(file_name,stringBuffer.toString()+"\n\n");
            }else {
                System.out.println(" null ");
            }

        }catch (Exception e){
            System.out.println("error = "+s_url);
            strings.add(s_url);
        }

    }
}
