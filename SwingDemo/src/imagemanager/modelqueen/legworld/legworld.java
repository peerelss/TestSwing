package imagemanager.modelqueen.legworld;

/**
 * Created by kevin on 2017/9/21.
 */
public class legworld {
    public static String URL = "http://legsworld.net/Wechselbilder/Zufallstitel1000x667/net/month_day.jpg";

    public static void main(String[] args) {
        for(int i=0;i<=12;i++){
            String month="";
            if(i<=9){
                month="0"+i;
            }else {
                month=""+i;
            }
            for(int j=0;j<=31;j++){
                String str="";
                if(j<=9){
                    str="0"+j;

                }else {
                    str=""+j;
                }
                System.out.println(URL.replace("month_day",month+"/"+str));
            }
        }

    }
}
