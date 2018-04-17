package fx.tumblr;

import java.io.File;

public class FileSelect {
    static String Path="F:\\tumblr_down\\dress2show";
    static int count=5000;
    public static void main(String[] args) {
        int c=1;
        try{
            File file=new File(Path);
            if(file.isDirectory()){
                File[] files=file.listFiles();
                int l=files.length;
                createNewFile(l/count);
                for(File file1:files){
                    c++;
                    int y=c/count;
                    String name=Path+"/"+y+"/"+file1.getName();
                    file1.renameTo(new File(name));
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
