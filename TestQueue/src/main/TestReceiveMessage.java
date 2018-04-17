package main;

import frame.MessageProducerGUI;
import main.manager.MessageManager;

import javax.swing.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by kevin on 2017/1/12.
 */
public class TestReceiveMessage {
    public static void main(String[] args){
        try{
            JFrame frame = new JFrame("MessageProducerGUI");
            frame.setContentPane(new MessageProducerGUI().jp1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(800, 600);
            frame.setVisible(true);
            while (true){
                String r=MessageManager.getInstance().blockingQueue.poll();
                if(r!=null){
                    System.out.println(" message = "+r);
                }

            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
