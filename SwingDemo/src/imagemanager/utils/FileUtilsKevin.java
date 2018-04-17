package imagemanager.utils;

import java.io.File;

public class FileUtilsKevin {
    public static String FILE_PATH="D:\\down\\nylon";
    public static void main(String[] args){
        try{
            File file=new File(FILE_PATH);
            if(file.exists()&&file.isDirectory()){
                File[] files=file.listFiles();
                for(int i=0;i<files.length;i++){
                    File file1=files[i];
                    if(file1.getName().endsWith("jpg_orig")){
                        file1.renameTo(new File(file1.getAbsolutePath().replace("jpg_orig","jpg")));
                    }
                }
            }
        }catch (Exception e){

        }
    }

}
