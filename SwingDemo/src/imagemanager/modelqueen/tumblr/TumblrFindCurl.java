package imagemanager.modelqueen.tumblr;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import imagemanager.utils.OkHttpUtilKevin;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.TumbrJsonUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by kevin on 2017/11/7.
 */
public class TumblrFindCurl {
    public static String S_name = "tumblr.json";
    public static String url = "https://thekorrektivlens.tumblr.com/page/index";
    public static String urlD = "https://thekorrektivlens.tumblr.com";
    public static String name = "00000118_7772" + "lady_b";

    public static void setName(String n){
        name=n;
    }

    public static boolean putString2Txt1(int i) {
        String s = "IPv4";
        String line = null;
        StringBuilder sb = new StringBuilder();
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec(Conf.TUMBLR_LADYB2.replace("INDEX_TUMBLRRR", i + ""));
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

    public static void main(String[] args) {
        for (int i =7772; i <= 20000; i++) {
            System.out.println(" index = " + i*10);
            if (putString2Txt1(i)) {
                String result = TumbrJsonUtil.getStringFromTxt(S_name);
                getPicFromJson(JSON.parseObject(result));
              //     getPicFromString(result);
               //   getPicFromStringS(result);
            } else {
                System.out.println("error = " + i);
                break;
            }
        }
      /*  String str=TumbrJsonUtil.getStringFromTxt("D:\\private\\jpg4/tumblr.html");
        JSONObject jsonObject= JSON.parseObject(str);
        getPicFromJson(jsonObject);*/
    }

    public static void getPicFromJson(JSONObject jsonObject) {
        StringBuffer stringBuffer = new StringBuffer();
        //     System.out.println("re = "+jsonObject.toJSONString());
        JSONObject reJson = jsonObject.getJSONObject("response");
        JSONArray postAr = reJson.getJSONArray("posts");
        for (int i = 0; i < postAr.size(); i++) {
            JSONArray pAr = postAr.getJSONObject(i).getJSONArray("photos");
            if (pAr != null) {
                for (int j = 0; j < pAr.size(); j++) {
                    JSONObject oJs = pAr.getJSONObject(j).getJSONObject("original_size");
                    String url = oJs.getString("url");
                    stringBuffer.append(url + "\n");
                    System.out.println("url = " + url);
                }
            }
        }
        TumbrJsonUtil.putStringToTxt(name, stringBuffer.toString() + "\n\n");
    }

    public static void getPicFromF(String result) {
        String re = OkHttpUtilKevin.getStringFromUrlWithProxy(result);
        getPicFromStringS(re);
    }

    public static void getPicFromStringS(String result) {
        StringBuffer sb = new StringBuffer();
        Document document = Jsoup.parse(result);
        Elements elements = document.getElementsByTag("img");
        for (Element element : elements) {
            String s = element.attr("src");
            if (null != s && !"".equals(s)) {
                if (s.endsWith(".jpg") || s.endsWith("gif") || s.endsWith("png")) {
                    if (!s.contains("avatar")&&!s.contains("like")&&!s.contains("reblog")&&!s.contains("blank")) {
                        s = TumbrJsonUtil.formatString(s);
                        sb.append(s + "\n");
                        System.out.println(s);
                    }
                }

            }
        }
        TumbrJsonUtil.putStringToTxt(name, sb.toString() + "\n\n");
    }

    public static void getPicFromString(String result) {
        StringBuffer sb = new StringBuffer();
        Document document = Jsoup.parse(result);
        Elements elements = document.getElementsByTag("iframe");
        for (Element element : elements) {
            String s = element.attr("src");
            if (null != s && !"".equals(s) && s.contains("photoset")) {
                getPicFromF(urlD + s);
                System.out.println(s);
            }
        }
        TumbrJsonUtil.putStringToTxt(name, sb.toString() + "\n\n");
    }

    public static boolean putString2Txt(int i) {
        String s = "IPv4";
        String line = null;
        StringBuilder sb = new StringBuilder();
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec(Conf.TUMBLR_LADYB2.replace("INDEX_TUMBLR", i  + ""));
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
