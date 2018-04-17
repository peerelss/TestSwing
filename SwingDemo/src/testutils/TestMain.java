package testutils;

import com.test.domain.User;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import okhttp3.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import util.TumbrJsonUtil;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by kevin on 2016/12/14.
 */
public class TestMain {
    public static void main(String[] args){
        String urlHead="https://www.tumblr.com/svc/indash_blog/posts?tumblelog_name_or_id=bigpunisher2b&post_id=&limit=10&offset=";
        for(int i=0;i<100;i++){
            testTumblrJson(urlHead+i*10);
        }

    //    testMybatis();
    }
    public static void testTumblrJson(String url){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 1080)))
                .build();
        OkHttpUtils.initClient(okHttpClient);
        try{
            Response response   =  OkHttpUtils
                    .get()
                    .url(url)
                    .addHeader("Cookie", "tmgioct=584bd56b034f640208077880; rxx=385763q1nus.jqrxs9b&v=1; _ga=GA1.2.1832574784.1481612290;" +
                            " __utma=189990958.1832574784.1481612290.1481612291.1481612291.1; __utmb=189990958.0.10.1481612291;" +
                            " __utmc=189990958; __utmz=189990958.1481612291.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none);" +
                            " yx=42waufup4i6ii%26o%3D3%26f%3Dhy; devicePixelRatio=1; documentWidth=1412;" +
                            " anon_id=LZLCEVYSNUXYFMUEEEDPKJOAOLWVNKSA; pfp=rl9LFif9q4AX8nFVLqULAZJRJkskdPMYH2RjbBqN;" +
                            " pfs=MEo0yq0n8Zh68Hib8SzvGx3d4; pfe=1489388660; pfu=240913938; language=%2Czh_CN; logged_in=1; nts=false")
                    .addHeader("Accept",
                            "application/json, text/javascript, */*; q=0.01")
                    .addHeader("Accept-Language",
                            "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                    .addHeader("Connection",
                            "keep-alive")
                    .addHeader("Host",
                            "www.tumblr.com")
                    .addHeader("Referer",
                            "https://www.tumblr.com/dashboard/blog/bigpunisher2b")
                    .addHeader("Host",
                            "www.tumblr.com")
                    .addHeader("X-Requested-With",
                            "XMLHttpRequest")
                    .addHeader("User-Agent",
                            "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:50.0) Gecko/20100101 Firefox/50.0")
                    .addHeader("X-tumblr-form-key",
                            "wWoV0Es0Ij4n2gGAFJldazDnMk")
                    .build()
                    .execute();
            String html=response.body().string();
            TumbrJsonUtil.getImageUrlFromJson(html,null);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void testMybatis(){
        String resource = "conf.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = TestMain.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "com.test.mapping.userMapper.getUser";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        User user = session.selectOne(statement, 1);
        System.out.println(user);
    }
}
