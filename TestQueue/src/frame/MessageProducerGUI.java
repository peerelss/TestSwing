package frame;

import main.manager.MessageManager;
import sun.plugin2.message.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by kevin on 2017/1/12.
 */
public class MessageProducerGUI {
    private JTextField textField1;
    private JTextArea textArea1;
    private JScrollPane jsp1;
    public JPanel jp1;
    private JButton initButton;
    private JButton sendButton;
    private JButton secondButton;
    private final static BlockingQueue<String> queue=new LinkedBlockingQueue<String>();

    public MessageProducerGUI() {

        initButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true){
                            try{
                                String s=queue.take();
                                System.out.println("message = "+s);
                                SwingUtilities.invokeLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        textArea1.append(s);
                                    }
                                });
                            }catch (Exception e1){
                                e1.printStackTrace();
                            }
                        }
                    }
                }).start();

            }
        });
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queue.add(textField1.getText());
            }
        });
        secondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        JFrame frame=new JFrame("Another Frame");
                        JPanel panel = new JPanel();
                        JTextArea textArea = new JTextArea();

                        panel.setLayout(new GridLayout());
                        textArea.setText("test");
                        //当TextArea里的内容过长时生成滚动条
                        panel.add(new JScrollPane(textArea));
                        frame.add(panel);

                        frame.setSize(200,200);
                        frame.setVisible(true);
                        queue.add("ss");
                    }
                }).start();

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MessageProducerGUI");
        frame.setContentPane(new MessageProducerGUI().jp1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setVisible(true);

    }
}
