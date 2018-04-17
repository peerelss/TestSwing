package main.manager;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by kevin on 2017/1/12.
 */
public class MessageManager {
    public static MessageManager getInstance() {
        return ourInstance;
    }
    private static MessageManager ourInstance = new MessageManager(new LinkedList<>());
    private MessageManager(Queue<String> objects) {
        this.blockingQueue=objects;
    }
    public Queue<String> blockingQueue;

}
