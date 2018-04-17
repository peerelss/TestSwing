package util;

/**
 * Created by kevin on 2017/3/27.
 */
public class Test {
    public static void main(String[] args){
        for(int i=1;i<=41;i++){
            System.out.println("http://mtl.ttsqgs.com/images/img/8768/"+i+".jpg");
        }
    }
    public static String getPageName(String url){
        String s="http://www.ligui.org/aiss/1099.html";
        String str=s.substring(s.indexOf("org")+4,s.lastIndexOf("/"));
        return str;
    }
}
