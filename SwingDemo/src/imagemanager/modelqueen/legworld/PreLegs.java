package imagemanager.modelqueen.legworld;

/**
 * Created by kevin on 2017/10/28.
 */
public class PreLegs {
    static String url="http://legsworld.net/UpdatesNew/Previews-1212x1644/index.jpg";
    public static void  main(String[] args){
        for(int i=1500;i<=5000;i++){
            System.out.println(url.replace("index",i+""));
        }
    }
}
