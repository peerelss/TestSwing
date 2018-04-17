package fx.tumblr;

import java.io.File;

public class FileRemove {
    static String Path="F:\\seamless";
    public static void main(String[] args) {
        int c=1;
        try{
            File file=new File(Path);
            if(file.isDirectory()){
                File[] files=file.listFiles();
                for(File file1:files){
                    if(file1.isDirectory()){

                    }else {
                        String s=file1.getName();
                        if(s.endsWith(".jpg")||s.endsWith(".gif")||s.endsWith(".png")){

                        }else {
                            file1.delete();
                        }
                    }
                }
            }
        }catch (Exception e){

        }
    }

    public static void createNewFile(int size){
        for(int i=0;i<=size;i++){
            File file=new File(Path+"/"+i);
            if(!file.exists()){
                file.mkdirs();
            }
        }
    }
}
