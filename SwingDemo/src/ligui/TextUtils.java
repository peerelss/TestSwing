package ligui;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by kevin on 2017/8/29.
 */
public class TextUtils {
    public static void main(String[] args){
        int i=1;
        try {
            BufferedReader fin = new BufferedReader( new FileReader("E:\\Users\\k550\\Documents\\bigpunisher2b.txt") );
            String ss=fin.readLine();
            while(ss!=null){
                if(ss.contains("jpg")||ss.contains("gif")) {
                    System.out.println(ss);
                    i++;
                    if(i%100==0){
                        System.out.println("\n\n\n");
                    }
                }
                ss=fin.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
