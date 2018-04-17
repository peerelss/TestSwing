package com.kevin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String url="https://image.jukujo-club.com/image/INDEX/movie_main.jpg";
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=0;i<=7171;i++){
            stringBuffer.append(url.replace("INDEX", i + "")+"\n");
            if(i%1000==0){
                stringBuffer.append("\n\n\n\n");
            }
        }
      //  TumbrJsonUtil.putStringToTxt(name, stringBuffer.toString() + "\n\n");
    }
}
