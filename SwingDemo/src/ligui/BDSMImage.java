package ligui;

import com.zhy.http.okhttp.OkHttpUtils;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * Created by kevin on 2017/9/6.
 */
public class BDSMImage {
    public static String URL="http://www.woaikb.com/home.php?mod=space&amp;uid=1&amp;do=album&amp;id=38";
    public static String url="https://www.baidu.com";

    public static void main(String[] args){
        try {
            /*OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                    .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                    .readTimeout(10000L, TimeUnit.MILLISECONDS)
                    .build();
            OkHttpUtils.initClient(okHttpClient);
            Response response = OkHttpUtils
                    .get()//
                    .url(URL)//
                    .build()//
                    .execute();
            String html=response.body().string();
            System.out.println(html);*/
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
