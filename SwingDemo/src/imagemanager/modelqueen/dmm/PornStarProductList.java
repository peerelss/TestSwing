package imagemanager.modelqueen.dmm;

import imagemanager.utils.OkHttpUtilKevin;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.TumbrJsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2017/11/2.
 */
public class PornStarProductList {
    public static String url="http://unblockdmm.com/browse.php?u=http%3A%2F%2Fwww.dmm.co.jp%2Frental%2F-%2Flist%2F%3D%2Farticle%3Dseries%2Fid%3D209738%2F&b=0";
    static String name="bf_1202";

    public static void main(String[] args){
        List<String> list=new ArrayList<>();
        for(int i=1;i<=1;i++){
            String result = OkHttpUtilKevin.getStringFromUrlWithProxy(url.replace("index",i+""));
         //   String result= TumbrJsonUtil.getStringFromTxt("E:/dmm/julia.txt");// 2 3 5 7 10 18 25
            System.out.println("current index = "+i);
            if(result==null||"".equals(result)){
                list.add(i+"");
            }else {
                getPicFromString(result);
            }

        }
        for(int i=0;i<list.size();i++){
            String result = OkHttpUtilKevin.getStringFromUrlWithProxy(url.replace("index",list.get(i)));
            //   String result= TumbrJsonUtil.getStringFromTxt("E:/dmm/julia.txt");// 2 3 5 7 10 18 25
            System.out.println("current error index = "+list.get(i));
            getPicFromString(result);
        }
    }
    public static void getPicFromString(String result){
        StringBuffer sb=new StringBuffer();
        Document document= Jsoup.parse(result);
        Elements elements=document.getElementsByTag("img");
        for(Element element:elements){
            String s=element.attr("src");
            if(null!=s&&!"".equals(s)){
                if(s.endsWith("pt.jpg")){
                    s=s.replace("pt.jpg","pl.jpg");
                    sb.append(s+"\n");
                    System.out.println(s);
                }

            }
        }
        TumbrJsonUtil.putStringToTxt(name,sb.toString()+"\n\n");

    }

}
