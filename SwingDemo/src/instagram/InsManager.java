package instagram;

import com.zhy.http.okhttp.OkHttpUtils;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import util.TumbrJsonUtil;
import util.ZipUtil2;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * Created by kevin on 2017/2/16.
 */
public class InsManager {
    public static void main(String[] args){
        String url="https://www.instagram.com/query/";
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 1080)))
                .build();
        OkHttpUtils.initClient(okHttpClient);
        try{
            Response response   =  OkHttpUtils
                    .post()
                    .url(url)
                    .addHeader("Host","www.instagram.com")
                    .addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:51.0) Gecko/20100101 Firefox/51.0")
                    .addHeader("Accept","*/*")
                    .addHeader("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                    .addHeader("X-CSRFToken","IzCrAzdL37gC1XfnQmrH27ZG15L97iZA")
                    .addHeader("X-Instagram-AJAX","1")
                    .addHeader("Content-Type","application/x-www-form-urlencoded")
                    .addHeader("X-Requested-With","XMLHttpRequest")
                    .addHeader("Referer","https://www.instagram.com/mspervology/")
                    .addHeader("Content-Length","559")
                    .addHeader("Cookie","csrftoken=IzCrAzdL37gC1XfnQmrH27ZG15L97iZA;" +
                            " mid=WE-CgwAEAAG5gZFY37XrEUtaovz3;" +
                            " fbm_124024574287414=base_domain=.instagram.com;" +
                            " sessionid=IGSCbc2b0f1ee7491beeaddf1483c1ddd32e03e91568d09ccd120e4119cb49be9de6%3A9MUB3ypBRcUQTZjaTzTCuweeai8lfrG1%3A%7B%22_auth_user_backend%22%3A%22accounts.backends.CaseInsensitiveModelBackend%22%2C%22_token_ver%22%3A2%2C%22asns%22%3A%7B%22time%22%3A1487211651%7D%2C%22last_refreshed%22%3A1487211651.4871318%2C%22_token%22%3A%223650320505%3Ac8bBRdn15sM0OPrPLe5201gXD79KJo0M%3A3e2ca2c66215509b61e6b3e3d984b80e7f4ff98cf4dca5276c31624ebc921ff7%22%2C%22_auth_user_hash%22%3A%22%22%2C%22_platform%22%3A4%2C%22_auth_user_id%22%3A3650320505%7D;" +
                            " ds_user_id=3650320505;" +
                            " ig_pr=1;" +
                            " ig_vw=2318;" +
                            " s_network=\"\";" +
                            " fbsr_124024574287414=YKSvuxN9-XGyd2YxYscJmxFUvDm_N1O5q8cOF8koGFs.eyJhbGdvcml0aG0iOiJITUFDLVNIQTI1NiIsImNvZGUiOiJBUUNTcy04MHg3OUxfdWtiWWJMLTFaQ2x3dGVKcXdSLTdsbF9hVzNBTVZLQWo3ZUUwQ2RvVFY0bW9PSDhPeTRxc3ZKelNxMDhQMVRibGZ1T3BaVXM2ODJzSGJLb2xaSHEyQ1dBYXZxMDh2VnNWZEVFRmtiZHF6eTZlTm9RT3YzM2FHejAycGw4cE13UU92Ul9BNUZlamhEQnQ1M0VjMWhGUi1iWE1SN1NHSmVTOTE4OEFTb0pmWHlpQ2VZdWQtMXZ1SjRuMnpfUENza3VlcG8tX1NCdnFZM1lxYmhROC1uazlsV3JCSU9FVzFoazBrSk5LZGlRazkyYmRvTUtLT0JjSzVDenpaSjlZQ2NDRXhUdlVpckU2YmF0aFVLdDlMRUo4SV9VM1EtZU5ZU2hMWDRBdGt6a1FGQWtuZ0V4aFVDYmJGXzlSOEtwbklJcUhkR1lkdkdleDVkayIsImlzc3VlZF9hdCI6MTQ4NzIzNjY4NywidXNlcl9pZCI6IjEwMDAwNzAwMTEwOTMzNyJ9")
                    .addHeader("Connection",
                            "keep-alive")
                  //  .addParams("q","ig_user(3305267982)+{+media.after(AQCL75mHFJ9qeAJCVzxv6Qylj_i4ZNeuq1uUu5ZGpDq9zHDbsPl_mGZbv4LW0Cpo3--Jujq9uqA3WthB-LIepDPiAB5NNjAsNkHbXyvvQC5a4csrFNiOAnSmoEoYaZLOo1Y,+12)+{++count,++nodes+{++++__typename,++++caption,++++code,++++comments+{++++++count++++},++++comments_disabled,++++date,++++dimensions+{++++++height,++++++width++++},++++display_src,++++id,++++is_video,++++likes+{++++++count++++},++++owner+{++++++id++++},++++thumbnail_src,++++video_views++},++page_info}+}")
                    .addParams("q","ig_user(3305267982)+{+media.after(1434303501533692296,+12)+{++count,++nodes+{++++__typename,++++caption,++++code,++++comments+{++++++count++++},++++comments_disabled,++++date,++++dimensions+{++++++height,++++++width++++},++++display_src,++++id,++++is_video,++++likes+{++++++count++++},++++owner+{++++++id++++},++++thumbnail_src,++++video_views++},++page_info}+}")
                    .addParams("ref","users::show")
                    .addParams("query_id","17849115430193904")


                    .build()
                    .execute();
            String html=response.body().string();
            System.out.println(html);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void getGet(){
        try{
            Response response   =  OkHttpUtils
                    .get()
                    .url("")
                    .addHeader("Cookie", "csrftoken=IzCrAzdL37gC1XfnQmrH27ZG15L97iZA;" +
                            " mid=WE-CgwAEAAG5gZFY37XrEUtaovz3;" +
                            " fbm_124024574287414=base_domain=.instagram.com;" +
                            " sessionid=IGSCbc2b0f1ee7491beeaddf1483c1ddd32e03e91568d09ccd120e4119cb49be9de6%3A9MUB3ypBRcUQTZjaTzTCuweeai8lfrG1%3A%7B%22_auth_user_backend%22%3A%22accounts.backends.CaseInsensitiveModelBackend%22%2C%22_token_ver%22%3A2%2C%22asns%22%3A%7B%22time%22%3A1487211651%7D%2C%22last_refreshed%22%3A1487211651.4871318%2C%22_token%22%3A%223650320505%3Ac8bBRdn15sM0OPrPLe5201gXD79KJo0M%3A3e2ca2c66215509b61e6b3e3d984b80e7f4ff98cf4dca5276c31624ebc921ff7%22%2C%22_auth_user_hash%22%3A%22%22%2C%22_platform%22%3A4%2C%22_auth_user_id%22%3A3650320505%7D;" +
                            " ds_user_id=3650320505;" +
                            " ig_pr=1;" +
                            " ig_vw=1906;" +
                            " s_network=\"\";" +
                            " fbsr_124024574287414=iJjThHYMiZ5H8sGpb7T3dCZ8PO7DfvHD-zq_5Z91amI.eyJhbGdvcml0aG0iOiJITUFDLVNIQTI1NiIsImNvZGUiOiJBUURnWlBUT3ZKUUNvbGpnUjhlX29ObTA5bWw4ZVlfZ3c5WmNrUEhfa3RPWk5nR1Y3Q0JKeExneHN6NnJacURqaWh0OFA1dG8zeW1QQjU0djVPMEVTQzN5bl92V2ZNa0FIdWs5clBaRW9RUG9hQmJEZmIxTFdoV2F0MVN0OTYxMjVDTXRVNk53S3d3N1JuLUdULUo4aklXWUs0Mkxqc25fSWFSeUdKcHZIRVNCLXpnUi1EMVFmUW4tVmwtV3hHR3lHYjlITXVqZHNWc1RTWkNJYkEyUDRJWjVrRUo3NDFPMzJpQjItMFBXYS1WTVFCU1V6dDlneGdiR0czaDlUR1BNNlBKWkVnV19NZFhfZm5xQVByaHFRT09Va0VHVDV2bjhRTFpJRWo5SXJzTTRReURueF9aWTBwRjM5VXNWNDIyM1lWcVNzQkNZOUVVM3QtSzE5WnlZSWQ5UCIsImlzc3VlZF9hdCI6MTQ4NzIxMTkwNiwidXNlcl9pZCI6IjEwMDAwNzAwMTEwOTMzNyJ9")
                    .addHeader("Accept",
                            "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                    .addHeader("Accept-Language",
                            "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                    .addHeader("Connection",
                            "keep-alive")
                    .addHeader("Host",
                            "www.instagram.com")
                    .addHeader("User-Agent",
                            "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:50.0) Gecko/20100101 Firefox/51.0")
                  /*  .addHeader("Accept-Encoding",
                            "gzip, deflate, br")*/
                    .addHeader("Referer",
                            "https://www.instagram.com/")
                    .addHeader("Accept-Charset",
                            "utf-8")
                    .addHeader("Upgrade-Insecure-Requests",
                            "1")
                    .addHeader("Cache-Control",
                            "max-age=0")
                    .build()
                    .execute();
            String html=response.body().string();
            System.out.println(html);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
