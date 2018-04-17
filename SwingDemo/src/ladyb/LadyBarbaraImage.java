package ladyb;

import java.io.File;

/**
 * Created by kevin on 2017/11/19.
 */
public class LadyBarbaraImage {
    public static String url="E:/dmm/ladyb2";
    public static void main(String[] args){
        try{
            File file=new File(url);
            if(file.isDirectory()){
                for(File file1:file.listFiles()){
                    String fileName=file1.getAbsolutePath();
                    if(!fileName.endsWith(".jpg")){
                        file1.renameTo(new File(fileName+".jpg"));
                    }
                }
            }
        }catch (Exception e){

        }
    }
}
