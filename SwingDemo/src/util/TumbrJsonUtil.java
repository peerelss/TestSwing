package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import model.TumblrImagesManager;
import net.NetRequest;
import org.apache.http.util.TextUtils;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.util.NodeList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by kevin.xie on 2016/12/6.
 */
public class TumbrJsonUtil {
    static Logger log = Logger.getLogger(TumbrJsonUtil.class.getName());
    private static String result = "";
    private static ArrayList<String> strs = new ArrayList<>();
    public static int count = 1;

    public static void main(String[] args) {
        putStringToTxt("text", "test");
    }

    public static void getImageUrlFromJson(String json, NetRequest net) {
        result = "";
        count = 0;
        if (TextUtils.isEmpty(json)) {
            json = getStringFromTxt("E:/tumblr/strumpfhose-pumpesjson.txt");
        }
        try {
            JSONObject jsonObject = JSON.parseObject(json);
            //    System.out.println(json.toString());
            JSONObject response = jsonObject.getJSONObject("response");
            JSONArray posts = response.getJSONArray("posts");
            for (Object o : posts) {
                getPhotosFromO(o.toString());
            }
            //   System.out.println(result);
            if (!TextUtils.isEmpty(TumblrImagesManager.getInstance().getsFileName()) && !TextUtils.isEmpty(result)) {
                putStringToTxt(TumblrImagesManager.getInstance().getsFileName(), result + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getPhotosFromO(String o) {
        JSONObject post = JSON.parseObject(o.toString());
        if (post.containsKey("photos")) {
            JSONArray photos = post.getJSONArray("photos");
            for (Object ob : photos) {
                getPhotoFromAlt(ob.toString());
            }
        } else {
            count = 0;
            return;
        }
        if (post.containsKey("photoset_photos")) {
            JSONArray photosets = post.getJSONArray("photoset_photos");
            for (Object obs : photosets) {
                JSONObject js = JSON.parseObject(obs.toString());
                String jsStr = js.get("high_res").toString();
                if (!TextUtils.isEmpty(jsStr)) {
                    getTumblrImageUrl(jsStr);
                }

            }
        }
    }

    public static void getTumblrImageUrl(String jsStr) {
        result = result + jsStr + "\n";
        count++;
    }

    public static void getPhotoFromAlt(String alt) {
        JSONObject js = JSON.parseObject(alt);
        JSONObject jsS = js.getJSONObject("original_size");
        String jsStr = jsS.get("url").toString();
        getTumblrImageUrl(jsStr);
    }

    public static String getStringFromTxt(String file) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();

    }

    public static List<String> getStringsFromTxt(String file) {
        List<String> strings = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                if (!"".equals(s)) {
                    strings.add(System.lineSeparator() + s);
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return strings;
    }

    public static void putStringToTxt(String name, String content) {
        //   log.info(content);
        FileWriter fw = null;
        content = formatString(content);
        try {
            //如果文件存在，则追加内容；如果文件不存在，则创建文件
            File f = new File("E:/tumblr");
            if (!f.exists()) {
                f.mkdir();
            }
            File file = new File(f, name + "_json1.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(content);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String findTumblr(String str) {
        return str.substring(str.lastIndexOf("com") + 4, str.lastIndexOf("tumblr") - 1);
    }

    public static void getImageUrlFromHtml(String html, NetRequest net) {
        // use htmlparser 解析 html
        try {
            Parser parser = new Parser(html);
            parser.setEncoding(parser.getEncoding());
            NodeFilter filter = new NodeClassFilter(ImageTag.class);
            NodeList list = parser.extractAllNodesThatMatch(filter);
            String resultStr = "";
            for (int i = 0; i < list.size(); i++) {
                ImageTag node = (ImageTag) list.elementAt(i);
                if (node.getImageURL().length() < 200) {
                    String str = node.getImageURL();
                    if (!str.contains("avatar")) {
                        resultStr = resultStr + str + "\n";
                        log.info(resultStr);
                    }
                }
            }
            if (TextUtils.isEmpty(resultStr)) {
                net.onOver();
                return;
            }
            putStringToTxt(TumblrImagesManager.getInstance().getsFileName(), resultStr);
            //从框架中解析
            NodeFilter iframeFilter = new NodeFilter() {
                public boolean accept(Node node) {
                    if (node.getText().startsWith("iframe id=\"photo")) {
                        return true;
                    } else {
                        return false;
                    }
                }
            };
            String frameResult = "";
            Parser parser1 = new Parser(html);
            NodeList nodeFrameList = parser1.extractAllNodesThatMatch(iframeFilter);
            for (int i = 0; i < nodeFrameList.size(); i++) {
                Node node = nodeFrameList.elementAt(i);
                String[] urlPic = node.getText().split(" ");
                for (int j = 0; j < urlPic.length; j++) {
                    if (urlPic[j].contains("src")) {
                        //   getTumblr(urlPic[j].substring(5, urlPic[j].length() - 1));
                        frameResult = frameResult + "," + urlPic[j].substring(5, urlPic[j].length() - 1);
                    }
                }
            }
            if (null != net) {
                net.onOperaSuccess(frameResult);
            }

        } catch (Exception e) {
            e.printStackTrace();
            net.onOperaFailure();
        }
    }

    public static String formatString(String result) {
        result = result.replace("400.jpg", "1280.jpg")
                .replace("540.jpg", "1280.jpg")
                .replace("250.jpg", "1280.jpg")
                .replace("500.jpg", "1280.jpg")
                .replace("250.gif", "540.gif")
                .replace("400.gif", "540.gif")
                .replace("500.gif", "540.gif");
        return result;
    }
}
