package datastructure.queue.pattern;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerMain {
    public static void main(String[] args) {
        //queue 기본 사이즈 30
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(20);

        MsgProducer msgProducer = new MsgProducer(queue);
        MsgConsumer msgConsumer = new MsgConsumer(queue);

        //생산자 큐에 메세지 생산 시작
        new Thread(msgProducer).start();
        //소비자 큐로부터 메세지 소비 시작
        new Thread(msgConsumer).start();
        System.out.println("Producer and Consumer 테스트 시작");
    }
}
