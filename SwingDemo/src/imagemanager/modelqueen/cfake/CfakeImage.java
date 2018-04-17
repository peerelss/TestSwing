package imagemanager.modelqueen.cfake;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.TumbrJsonUtil;

/**
 * Created by kevin on 2017/9/16.
 */
public class CfakeImage {
    public static String url="http://cfake.com/picture/Shemale/13/3";
    public static int[] ints={14,50};
    public static String mFileName="Art0407";// 7 10
    public static void main(String[] args){
        if(true){
            for(int i=0;i<=7;i++){
                getPicFromUrl(url+"/p"+(i*30));
                System.out.println(" i ="+i);
            }
        }else {
            for(int i=0;i<ints.length;i++){
                getPicFromUrl(url+"/p"+(ints[i]*30));
                System.out.println(" i ="+ints[i]);
            }
        }


    }

    public static void getPicFromUrl(String url){
        try{
            StringBuffer sb=new StringBuffer();
            Element element1= Jsoup.connect(url).get();
            Elements elements = element1.getElementsByTag("img");
            for (Element element : elements) {
                String imgSrc = element.attr("src"); //获取src属性的值
                if(imgSrc.endsWith("_cfake.jpg")) {
                    imgSrc="http://cfake.com"+imgSrc.replace("thumbs","photos");
                  //  System.out.println("http://cfake.com"+imgSrc.replace("thumbs","photos"));
                    sb.append(imgSrc+"\n");
                }
            }
            TumbrJsonUtil.putStringToTxt("cfake_"+mFileName,sb.toString()+"\n\n\n");
        }catch (Exception e){
            System.out.println("error = "+url);
            getPicFromUrl(url);
        }
    }

}
