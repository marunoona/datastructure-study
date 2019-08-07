package datastructure.queue.pattern;

import java.util.concurrent.BlockingQueue;

public class MsgConsumer implements Runnable {

    private BlockingQueue<Message> queue;

    public MsgConsumer(BlockingQueue<Message> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            Message message;
            //exit확인 후 종료
            while((message = queue.take()).getMessage() != "exit"){
                Thread.sleep(1000);
                System.out.println("MsgConsumer : "+message.getMessage());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
