package datastructure.queue.pattern;

import java.util.concurrent.BlockingQueue;

public class MsgProducer implements Runnable{

    private BlockingQueue<Message> queue;

    public MsgProducer(BlockingQueue<Message> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        // 메세지 삽입
        for(int i = 1; i <= 30; i++){
            Message message = new Message(i+"번 고객님 환영합니다.");
            try{
                Thread.sleep(1000);
                queue.put(message);
                System.out.println(i+"번 메세지를 생성하였습니다.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Message message = new Message("exit");
        try{
            queue.put(message);
            System.out.println("종료 문자열 삽입");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
