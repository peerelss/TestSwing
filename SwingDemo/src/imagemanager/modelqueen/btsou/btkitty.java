package imagemanager.modelqueen.btsou;

import com.mysql.jdbc.log.Log;
import com.zhy.http.okhttp.OkHttpUtils;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.TumbrJsonUtil;

import java.util.concurrent.TimeUnit;

/**
 * Created by kevin on 2017/10/15.
 */
public class btkitty {
    public static String url = "http://btkitty.pet/search/y8gvLU7NTytJTMrPBwA/index/0/0.html";//  time_d
    public static String mFileName = "house_of_taboo";
    public static OkHttpClient okHttpClient;

    public static void main(String[] args) {
        okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .build();
        OkHttpUtils.initClient(okHttpClient);
        for (int i = 1; i <=100; i++) {
            String result = getStringFromUrlByOK(url.replace("index",""+i));
            getMegnetFromString(result);
        }
     //   String result = TumbrJsonUtil.getStringFromTxt("D:/soft/btkitty.txt");
    //    getMegnetFromString(result);

    }

    private static void getMegnetFromString(String result) {
        try {
            Document document = Jsoup.parse(result);
            Elements elements = document.getElementsByClass("option");
            StringBuffer sb=new StringBuffer();
            for (Element element : elements) {
                {
                    Elements elements1 = element.getElementsByTag("a");
                    for (Element element1 : elements1) {
                        System.out.println(element1.attr("href"));
                        sb.append(element1.attr("href")+"\n");
                    }

                }
                {
                    Elements elements1 = element.getElementsByTag("b");
                    System.out.println(" e " +elements1.get(1).text());
                    sb.append(elements1.get(1).text()+"\n");

                }
            }
            TumbrJsonUtil.putStringToTxt(mFileName,sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getStringFromUrlByOK(String url) {
        System.out.println("url = " + url);
        try {
            Response response = OkHttpUtils
                    .get()//
                    .url(url)//
                    .build()//
                    .execute();
            String html = response.body().string();
            return html;
        } catch (Exception e) {
            System.out.println("error = " + url);
            return null;
        }

    }
}
