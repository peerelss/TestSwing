package imagemanager.modelqueen.btsou;

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
 * Created by kevin on 2017/9/16.
 */
public class BtSouManage {
    public static String url = "http://www.btsou.biz/list/多摩豪/";//  time_d
    public static String mFileName = "多摩豪";
    public static OkHttpClient okHttpClient;

    public static void main(String[] args) {
        okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .build();
        OkHttpUtils.initClient(okHttpClient);
        for (int i = 1; i <=2; i++) {
            String result = getStringFromUrlByOK(url + i + "/time_d");
            if (result != null) {
                getMagnetFromUrl(result);
            }
        }
    }

    public static String getStringFromUrlByOK(String url) {
        System.out.println("url = "+url);
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

    public static void getMagnetFromUrl(String url) {
        try {
            Document document = Jsoup.parse(url);
            StringBuffer sb=new StringBuffer();

            Elements elements = document.getElementsByClass("T1");
            Elements elementsInfo = document.getElementsByClass("dInfo");
            Elements elementsDt = document.getElementsByTag("dt");
            int count=elements.size();
            for(int i=0;i<count;i++){
                Element es=elements.get(i).select("a").first();
                sb.append(es.text()+"\n");

                Elements esInfo=elementsInfo.get(i).select("a");
                for (Element element2 : esInfo) {
                    String href = element2.attr("href");
                    if (href.startsWith("magnet")) {
                        sb.append(href+"\n");
                    }
                }
                sb.append(elementsDt.get(i).text()+"\n");


                /*for (Element element : elements) {
                    Elements elements1 = element.select("a");
                    for (Element element2 : elements1) {
                        System.out.println(element2.text());
                    }
                    System.out.println();
                }
                for (Element element : elementsInfo) {
                    Elements elements1 = element.select("a");
                    for (Element element2 : elements1) {
                        String href = element2.attr("href");
                        if (href.startsWith("magnet")) {
                            System.out.println(href);
                        }

                    }
                    System.out.println();
                }

                for (Element element : elementsDt) {
                    System.out.println(element.text());
                    System.out.println();
                }*/


            }
            sb.append("\n");
            TumbrJsonUtil.putStringToTxt("btsou_"+mFileName,sb.toString());



        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error = " + url);
        }
    }
}
