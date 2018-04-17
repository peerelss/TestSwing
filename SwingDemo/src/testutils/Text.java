package testutils;
/*
* E:\tumblr\marceau.txt
* E:\tumblr\milky_json1.txt
* E:\tumblr\christina_json1.txt
* E:\tumblr\bondagecafe_json1.txt
* E:\tumblr\latex_lucy_json1.txt
* E:\tumblr\latex+lucy_json1.txt
* E:\tumblr\Gwenmedia.txt
* E:\tumblr\latex_lucy.txt
* E:\tumblr\christinabound.txt
* E:\tumblr\bondagecafe.txt
* E:\tumblr\btexe66_ashley_json1.txt
* E:\tumblr\btexe66_Christina_json1.txt
* E:\tumblr\btexe66_latex_json1.txt
* E:\tumblr\btexe66_Gwenmedia_json1.txt
* E:\tumblr\btexe66_BondageCafe_json1.txt
* E:\tumblr\btexe66_Jewell_json1.txt
*
* */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Text {
    public static List<String> stringList = new ArrayList<>();
    public static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        stringList.add("E:\\tumblr\\marceau.txt");
        stringList.add("E:\\tumblr\\milky_json1.txt");
        stringList.add("E:\\tumblr\\christina_json1.txt");
        stringList.add("E:\\tumblr\\bondagecafe_json1.txt");
        stringList.add("E:\\tumblr\\latex_lucy_json1.txt");
        stringList.add("E:\\tumblr\\latex+lucy_json1.txt");
        stringList.add("E:\\tumblr\\Gwenmedia.txt");
        stringList.add("E:\\tumblr\\latex_lucy.txt");
        stringList.add("E:\\tumblr\\christinabound.txt");
        stringList.add("E:\\tumblr\\bondagecafe.txt");
        stringList.add("E:\\tumblr\\btexe66_ashley_json1.txt");
        stringList.add("E:\\tumblr\\btexe66_Christina_json1.txt");
        stringList.add("E:\\tumblr\\btexe66_latex_json1.txt");
        stringList.add("E:\\tumblr\\btexe66_Gwenmedia_json1.txt");
        stringList.add("E:\\tumblr\\btexe66_BondageCafe_json1.txt");
        stringList.add("E:\\tumblr\\btexe66_Jewell_json1.txt");
        for(int i=0;i<stringList.size();i++){
            getMagnetFromTxt(new File(stringList.get(i)));
        }
        for(int i=0;i<result.size();i++){
            System.out.println("magent = "+result.get(i));
        }
    }

    public static void getMagnetFromTxt(File file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                String str =  s;
                if (str != null && !str.equals("") && str.startsWith("magnet")) {
                  //  str = str.toUpperCase();
                    if(!result.contains(str)){
                        result.add(str);
                    }
                }

            }
            br.close();
        } catch (Exception e) {
            System.out.println("file name = "+file.getName());
            e.printStackTrace();
        }
    }
}
