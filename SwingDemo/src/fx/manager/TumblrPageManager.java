package fx.manager;

import fx.net.NetListener;
import util.TumbrJsonUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import imagemanager.modelqueen.tumblr.TumblrFindCurl;

public class TumblrPageManager {
    public static String S_name = "tumblr.html";
    private static TumblrPageManager instance;

    public static TumblrPageManager getInstance() {
        if (instance == null) {
            instance = new TumblrPageManager();
        }
        return instance;
    }

    private NetListener listener;
    private static String curl, dom, fileName;
    private int beginInt, endInt;
    Thread thread;
    public void init(String c, String d, String fileN, int b, int e, NetListener netListener) {
        this.curl = c;
        this.dom = d;
        this.fileName = fileN;
        this.beginInt = b;
        this.endInt = e;
        this.listener = netListener;
        TumblrFindCurl.setName(fileN);
        beginTask();
    }
    public void stopTask(){
        if(thread!=null){
            thread.interrupt();
        }
    }

    private void beginTask() {
         thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = beginInt; i <= endInt; i++) {
                    System.out.println(" index = " + i);
                    if (putString2Txt(i)) {
                        String result = TumbrJsonUtil.getStringFromTxt(S_name);
                        //  getPicFromJson(JSON.parseObject(result));
                        TumblrFindCurl.getPicFromString(result);
                        TumblrFindCurl.getPicFromStringS(result);
                    } else {
                        System.out.println("error = " + i);
                        break;
                    }
                }
            }
        });
        thread.start();
    }


    public static boolean putString2Txt(int i) {
        String s = "IPv4";
        String line = null;
        StringBuilder sb = new StringBuilder();
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec(curl.replace("INDEX_TUMBLR", i + ""));
            BufferedReader bufferedReader = new BufferedReader
                    (new InputStreamReader(process.getInputStream()));
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + "\n");
                if (line.contains(s)) {
                    System.out.println(line);
                }
            }
            return true;
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
            return false;
        }
    }
    public static void  putString2Txt(String url) {
        String s = "IPv4";
        String line = null;
        StringBuilder sb = new StringBuilder();
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec(url);
            BufferedReader bufferedReader = new BufferedReader
                    (new InputStreamReader(process.getInputStream()));
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + "\n");
                if (line.contains(s)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }
}
