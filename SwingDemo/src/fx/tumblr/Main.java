package fx.tumblr;


public class Main {
    static String url="http://pics.dmm.co.jp/digital/video/snis00INDEX/snis00INDEXpl.jpg";
    public static void main(String[] args) {
        for(int i=1;i<1000;i++){
            String ind="";
            if(i<10){
                ind="00"+i;
            }else if(i<100){
                ind="0"+i;
            }else {
                ind=""+i;
            }
            System.out.println(url.replace("INDEX",ind));
        }
    }

}

