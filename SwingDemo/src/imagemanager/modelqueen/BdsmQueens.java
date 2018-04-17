package imagemanager.modelqueen;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kevin on 2017/9/1.
 */
public class BdsmQueens {
    public static String URL = "http://bdsmqueens.com/sites/bondage-bob-pictures-1.html";
    public static String PIC_URL = "http://img.bdsmqueens.com/galleries/";
    public static String FileName = "D:/bdsmqueen/bound-honeys-pictures.txt";
    public static List<String> ERROR_LIST_HTML = new ArrayList<>();
    public static List<String> ERROR_LIST_PIC = new ArrayList<>();
    public static int count_html = 2, count_pic = 2;

    public static void main(String[] args) {
        String webUrl="http://bdsmqueens.com/models/S/sandra-silvers-pictures-1.html";
        for (int i = 1; i <=8; i++) {

            String url = webUrl.replace(("1.html"),"") + i + ".html";
            System.out.println(" page = " + url);
            createFile(url);
            getHTMLUrl2(url);

        }

        if (count_pic > 0) {
            count_pic--;
            for (String str : ERROR_LIST_PIC) {
                getPicUrl2(str);
                System.out.println(str);
            }
        }
        for(int i=0;i<errorUrl.length;i++){
            getPicUrl2(errorUrl[i]);
            System.out.println(" index = "+i);

        }
    }

    public static void createFile(String url) {
        if (url.contains("models")) {
            FileName = "D:/bdsmqueen/" + url.substring(url.indexOf("models") + 9, url.lastIndexOf(".html") - 2) + ".txt";
        }
        if (url.contains("sites")) {
            FileName = "D:/bdsmqueen/" + url.substring(url.indexOf("sites") + 6, url.lastIndexOf(".html") - 2) + ".txt";
        }
    }

    public static void getHTMLUrl2(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.getElementsByClass("newsthumb");
            for (Element element : elements) {
                Elements elements1 = element.getElementsByTag("a");
                for (Element element1 : elements1) {
                    String picUrl = element1.attr("href");
                    if (picUrl.contains("gallery")) {
                        //   System.out.println(picUrl);
                        getPicUrl2(picUrl);
                    }
                }
            }
        } catch (Exception e) {
            ERROR_LIST_HTML.add(url);
            //    e.printStackTrace();
        }
    }

    //在文本后追加写入数据
    public static void writeStirng2File(String fileName, String content) {
        FileWriter writer = null;
        try {
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            writer = new FileWriter(fileName, true);
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void getPicUrl2(String url) {
        StringBuffer sb = new StringBuffer();
        sb.append("\n\n\n\n").append(getTimeNow() + "\n");
        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.getElementsByTag("img");
            for (Element element : elements) {
                String imgSrc = element.attr("src"); //获取src属性的值
                if (imgSrc.contains("galleries")) {
                    String result = imgSrc.replace("t.jpg", ".jpg");
                    sb.append(result + "\n");
                    //  System.out.println(result);
                }
            }
            writeStirng2File(FileName, sb.toString());
        } catch (Exception e) {
            System.out.println(" error  " + url);
            if(count_pic==2) {
                ERROR_LIST_PIC.add(url);
            }          //   e.printStackTrace();
        }
    }

    public static void getHTMLUrl(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.getElementsByTag("img");
            for (Element element : elements) {
                String imgSrc = element.attr("src"); //获取src属性的值
                if (imgSrc.contains("galleries")) {
                    //  System.out.println(imgSrc);
                    getPICURL(imgSrc);
                }


            }
        } catch (Exception e) {
            System.out.println(" error  " + url);
            e.printStackTrace();
        }
    }

    public static void getPICURL(String url) {
        // http://img.bdsmqueens.com/galleries/22050/02t.jpg
        if (url.contains("galleries")) {
            String tag = url.substring(url.indexOf("galleries") + 10, url.lastIndexOf("/"));
            createPICUrl(tag);
        }
    }

    public static void createPICUrl(String tag) {
        for (int i = 1; i <= 11; i++) {
            if (i < 10) {
                System.out.println(PIC_URL + tag + "/0" + i + ".jpg");
            } else {
                System.out.println(PIC_URL + tag + "/" + i + ".jpg");
            }

        }
    }

    public static String getTimeNow() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String str = df.format(new Date());// new Date()为获取当前系统时间
        return str;
    }

    static String[] errorUrl = {
    };
}
