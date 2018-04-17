package imagemanager.utils;

import okhttp3.*;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by kevin on 2017/11/2.
 */
public class OkHttpUtilKevin {
    public static  OkHttpClient okHttpClientProxy  = new OkHttpClient.Builder()
            .connectTimeout(10000L, TimeUnit.MILLISECONDS)
            .readTimeout(10000L, TimeUnit.MILLISECONDS)
            .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 1080)))
            .build();
    public static  OkHttpClient okHttpClientTumblr = new OkHttpClient.Builder()
            .connectTimeout(10000L, TimeUnit.MILLISECONDS)
            .readTimeout(10000L, TimeUnit.MILLISECONDS)
            .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 1080)))
            .build();
    public static  OkHttpClient okHttpClient = new OkHttpClient.Builder()
        //    .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 1080)))
            .connectTimeout(10000L, TimeUnit.MILLISECONDS)
            .readTimeout(10000L, TimeUnit.MILLISECONDS)
            .build();
    public static String getStringFromUrlWithProxyTumblr(String url){
        try{
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Cookie","tmgioct=584bd56b034f640208077880; rxx=385763q1nus.jqrxs9b&v=1; _ga=GA1.2.1832574784.1481612290; __utma=189990958.1832574784.1481612290.1510180122.1510229997.445; __utmz=189990958.1510229997.445.309.utmcsr=wanimal1983.org|utmccn=(referral)|utmcmd=referral|utmcct=/; language=\"%\"2Czh_CN; logged_in=1; __unam=b3ca5e5-15a9eb0f305-3c0fd655-15; __gads=ID=a1906275c1c2a486:T=1502222538:S=ALNI_MaL0wtvXC0ZLF2bPKCAXTxpnlSRug; _gid=GA1.2.1800290940.1509860406; pfx=71df701c497aac7d36c80e041ecd805932d7c171a56c2bdf6a06e54f7e475828\"%\"230\"%\"234144413537; __utmc=189990958; __utmb=189990958.0.10.1510229997")
                    .build();
            Response response = okHttpClientTumblr.newCall(request).execute();
            return response.body().string();
        }catch (Exception e){
            System.out.println("error = "+url);
        }
        return "";
    }
    public static String getStringFromUrlWithProxy(String url){
        try{
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = okHttpClientProxy.newCall(request).execute();
            return response.body().string();
        }catch (Exception e){
            System.out.println("error = "+url);
        }
        return "";
    }
    public static String getStringFromUrl(String url){
        try{
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();
        }catch (Exception e){
            System.out.println("error = "+url);
        }
        return "";
    }


}
