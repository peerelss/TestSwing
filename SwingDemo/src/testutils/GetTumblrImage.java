package testutils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.executor.ExecutorException;
import util.TumbrJsonUtil;

import java.io.IOException;

/**
 * Created by kevin.xie on 2016/12/6.
 */
public class GetTumblrImage {
    public static String fileName="bigpunisher2b__";
    public static void main(String[] args) {
        for(int i=1;i<=2;i++){
            requestByGetMethod(i*10);
        }
    }
    public static void getDirectHtml(int i){
        CloseableHttpClient httpClient = getHttpClient();
        HttpHost proxy=new HttpHost("127.0.0.1",1080);
        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
        try{
            HttpGet get = new HttpGet("http://"+fileName+".tumblr.com/page/"+i);
            CloseableHttpResponse httpResponse = null;
            //发送get请求
            httpResponse = httpClient.execute(get);
            httpResponse = httpClient.execute(get);
            try{
                //response实体
                HttpEntity entity = httpResponse.getEntity();
                if (null != entity){
               /*     System.out.println("响应状态码:"+ httpResponse.getStatusLine());
                    System.out.println("-------------------------------------------------");
                    System.out.println("响应内容:" + EntityUtils.toString(entity));
                    System.out.println("-------------------------------------------------");*/
                    TumbrJsonUtil.getImageUrlFromHtml(EntityUtils.toString(entity),null);
                    //    TumbrJsonUtil.putStringToTxt("strphose",EntityUtils.toString(entity));
                }
            }
            finally{
                httpResponse.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void requestByGetMethod(int i){
        if(TumbrJsonUtil.count==0){
            System.out.println("end ,and page = "+i);
            return;
        }
        System.out.println("page = "+i);
        //创建默认的httpClient实例
        CloseableHttpClient httpClient = getHttpClient();
        HttpHost proxy=new HttpHost("127.0.0.1",1080);
        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
        try {
            //用get方法发送http请求
            HttpGet get = new HttpGet("https://www.tumblr.com/svc/indash_blog/posts?tumblelog_name_or_id="+fileName+"&should_bypass_safemode=false&post_id=&limit=10&offset="+i);
            get.addHeader("Cookie",
                    "tmgioct=584bd56b034f640208077880; rxx=385763q1nus.jqrxs9b&v=1; _ga=GA1.2.1832574784.1481612290; " +
                            "__utma=189990958.1832574784.1481612290.1490574490.1490601407.86; " +
                            "__utmz=189990958.1490537805.84.64.utmcsr=higyaku-no-miki.tumblr.com|utmccn=(referral)|utmcmd=referral|utmcct=/; " +
                            "yx=42waufup4i6ii%26o%3D3%26f%3Dhy; pfp=JlHB8e0bK60LK5tnwLFsNGr9YSwV0Ql5ABXJfOny; pfs=xZbmxtAnGEoWwFss1Gl3iUMOkao; " +
                            "pfe=1497581149; pfu=240913938; language=%2Czh_CN; logged_in=1; __unam=b3ca5e5-15a9eb0f305-3c0fd655-2; " +
                            "anon_id=OLKJCYVSDANRWRHTTLEAOAWBUAOVPDVK; nts=false; devicePixelRatio=1; documentWidth=1389; __utmc=189990958; " +
                            "capture=plpyBzc1PHfGcNlXgWVZfctHg0; __utmb=189990958.0.10.1490601407");
            get.addHeader("Accept",
                    "application/json, text/javascript, */*; q=0.01");
            get.addHeader("Accept-Encoding",
                    "gzip, deflate, br");
            get.addHeader("Accept-Language",
                    "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
            get.addHeader("Connection",
                    "keep-alive");
            get.addHeader("Host",
                    "www.tumblr.com");
            get.addHeader("Referer",
                    "https://www.tumblr.com/dashboard/blog/bigpunisher2b");
            get.addHeader("Host",
                    "www.tumblr.com");
            get.addHeader("X-Requested-With",
                    "XMLHttpRequest");
            get.addHeader("User-Agent",
                    "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:50.0) Gecko/20100101 Firefox/50.0");
            get.addHeader("X-tumblr-form-key",
                    "plpyBzc1PHfGcNlXgWVZfctHg0");
            get.setConfig(config);

        //    System.out.println("执行get请求:...."+get.getURI());
            CloseableHttpResponse httpResponse = null;
            //发送get请求
            httpResponse = httpClient.execute(get);
            try{
                //response实体
                HttpEntity entity = httpResponse.getEntity();
                if (null != entity){
               /*     System.out.println("响应状态码:"+ httpResponse.getStatusLine());
                    System.out.println("-------------------------------------------------");
                    System.out.println("响应内容:" + EntityUtils.toString(entity));
                    System.out.println("-------------------------------------------------");*/
                    System.out.println(EntityUtils.toString(entity));
                    //TumbrJsonUtil.getImageUrlFromJson(EntityUtils.toString(entity),null);
                    //    TumbrJsonUtil.putStringToTxt("strphose",EntityUtils.toString(entity));
                }
            }
            finally{
                httpResponse.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try{
                closeHttpClient(httpClient);
            } catch (IOException e){
                e.printStackTrace();
            }
        }

    }
    private static CloseableHttpClient getHttpClient(){
        return HttpClients.createDefault();
    }

    private static void  closeHttpClient(CloseableHttpClient client) throws IOException{
        if (client != null){
            client.close();
        }
    }

}
