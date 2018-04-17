package imagemanager.modelqueen.dmm;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.TumbrJsonUtil;

import java.util.jar.JarEntry;

/**
 * Created by kevin on 2017/11/2.
 */
public class Hxax{
    static String url="http://pics.dmm.co.jp/mono/movie/4bfindex/4bfindexpl.jpg";
    public static void main(String[] args){
        for(int i=1;i<=498;i++){
            String is=""+i;
            if(i<10){
                is="00"+i;
            }
            if(i>=10&&i<100){
                is="0"+i;
            }

            System.out.println(url.replace("index",is));
        }
    }
}
