package ligui;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kevin on 2017/8/23.
 */
public class LiGuiFinder {
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JTextArea textArea1;
    private JPanel jp1;

    public static String INDEX_PAGE="INDEX_PAGE";
    public static String URL="http://www.ligui.org/toutiaonvshen/8954"+INDEX_PAGE+".html";

    public static String ID="img_view";

    public static void main(String[] args) {
        JFrame frame = new JFrame("LiGuiFinder");
        frame.setContentPane(new LiGuiFinder().jp1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    public LiGuiFinder() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("listener");
                String url=textField1.getText();
                String index=textField2.getText();
                url=url.substring(0,url.indexOf(".html"));
                URL=url+INDEX_PAGE+".html";
                int i=Integer.valueOf(index);
                textArea1.setText("");
                getJpgFromUrl(URL.replace(INDEX_PAGE,""));
                for(int j=2;j<=i;j++){
                    getJpgFromUrl(URL.replace(INDEX_PAGE,"_"+j));
                }
                textArea1.append("end  "+"\n");
            }
        });
    }
    public  void getJpgFromUrl(String url){
        try{
            Document doc = Jsoup.connect(url).get();
            Element element=doc.getElementById(ID);
            Elements elements=element.getElementsByTag("img");
            for(Element element1 : elements) {
                String imgSrc=element1.attr("src"); //获取src属性的值
                System.out.println(imgSrc);
                textArea1.append(imgSrc+"\n");
            }
        }catch (Exception e){
            //e.printStackTrace();
            System.out.println("url = "+url+" error");
        }
    }
}
