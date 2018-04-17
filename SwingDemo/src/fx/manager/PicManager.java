package fx.manager;

import fx.net.NetListener;
import imagemanager.utils.OkHttpUtilKevin;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PicManager {
    private static PicManager instance;

    public static PicManager getInstance() {
        if (instance == null) {
            instance = new PicManager();
        }
        return instance;
    }

    private NetListener listener;
    private String dom;
    private int beginInt, endInt;

    public void init(String dom, int beginInt, int endInt, NetListener listener) {
        this.dom = dom;
        this.beginInt = beginInt;
        this.endInt = endInt;
        this.listener = listener;
        beginTask();
    }

    public void beginTask() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = beginInt; i <= endInt; i++) {
                    try {
                        String str = OkHttpUtilKevin.getStringFromUrl(dom+"/page/"+i);
                        //  System.out.println(str);
                        Document document = Jsoup.parse(str);
                        getPicUrlFromDocu(document);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    private void getPicUrlFromDocu(Document document) {
        Elements elements = document.getElementsByTag("img");
        for (Element element : elements) {
            String str = element.attr("src");
            if (str.contains("media")) {
                if (listener != null) {
                    listener.onSuccess(str);
                }
            }
        }
    }

}
