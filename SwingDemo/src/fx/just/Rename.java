package fx.just;

import java.io.File;

public class Rename {
    public static void main(String[] args){
        String url="E:\\down\\ashley";
        try{
            File file=new File(url);
            if(file.isDirectory()){
                File[] files=file.listFiles();
                for(File file1:files){
                    String name=file1.getAbsolutePath();
                    if(!name.endsWith(".jpg")){
                        name=name+".jpg";
                        file1.renameTo(new File(name));
                    }
                }
            }
        }catch (Exception e){

        }
    }
}
