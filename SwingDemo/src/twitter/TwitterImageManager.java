package twitter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import conf.TwitterCurlConf;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.TumbrJsonUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by kevin on 2017/11/25.
 */
public class TwitterImageManager {
    public static String begin_string = "924565699736977408";
    public static String name="twitter_milky_cat";
    public static void main(String[] args) {
       while (true){
           if(!putString2Txt()){
               System.out.println("index = " + begin_string);
               break;
           }
           String result = TumbrJsonUtil.getStringFromTxt(TwitterCurlConf.FILENAME_TAG);
           if(!getStringByResult(result)){
               break;
           }
       }
    }

    public static void getPicUrlFromHtml(String html) {
        StringBuffer buffer=new StringBuffer();
        try {
            Document document = Jsoup.parse(html);
            Elements elements = document.getElementsByTag("img");
            for (Element element : elements) {
                String url = element.attr("src");
                if (!url.contains("bigger")) {
                    buffer=buffer.append("\n"+url);
                    System.out.println(url);
                }
            }
        } catch (Exception e) {

        }
        TumbrJsonUtil.putStringToTxt(name,buffer.toString()+"\n");
    }

    public static boolean getStringByResult(String result) {
        String s = "";
        try {
            JSONObject jsonObject = JSON.parseObject(result);
            String index = jsonObject.getString("min_position");
            System.out.println("index = " + index);
            begin_string = index;
            boolean isEnd = jsonObject.getBoolean("has_more_items");
            String html = jsonObject.getString("items_html");
            getPicUrlFromHtml(html);
            return isEnd;
        } catch (Exception e) {
            System.out.println("error");
            return false;
        }
    }

    public static boolean putString2Txt() {
        String s = "IPv4";
        String line = null;
        StringBuilder sb = new StringBuilder();
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec(TwitterCurlConf.MILKY_CAT_CURL.replace(TwitterCurlConf.TAG_INDEX_POSITION, begin_string));
            BufferedReader bufferedReader = new BufferedReader
                    (new InputStreamReader(process.getInputStream()));
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + "\n");
                if (line.contains(s)) {
                    System.out.println(line);
                }
            }
            return true;
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
            return false;
        }
    }
}
