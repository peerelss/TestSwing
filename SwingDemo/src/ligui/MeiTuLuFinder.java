package ligui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kevin on 2017/8/23.
 */
public class MeiTuLuFinder {
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JTextArea textArea1;
    private JPanel jp1;

    public MeiTuLuFinder() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url=textField1.getText();
                url=url.substring(0,url.indexOf("1.jpg"));
                String page=textField2.getText();
                int pageInt=Integer.valueOf(page);
                for(int i=0;i<=pageInt;i++){
                    textArea1.append(url+i+".jpg"+"\n");
                }
                textArea1.append("\n\n");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MeiTuLuFinder");
        frame.setContentPane(new MeiTuLuFinder().jp1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
