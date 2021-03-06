package concurrent.locks;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable {

	private List<Integer> sharedQueue;
    Lock lock;
    Condition producerCondition;
    Condition consumerCondition;
 
    public Consumer(List<Integer> sharedQueue, Lock lock,
           Condition producerCondition, Condition consumerCondition) {
        this.sharedQueue = sharedQueue;
        this.lock=lock;
        this.producerCondition=producerCondition;
        this.consumerCondition=consumerCondition;
    }
    
    
    @Override
    public void run() {
           for (int i = 1; i <= 10; i++) {   //produce 10 products.
         try {
           consume();
         } catch (InterruptedException e) {  e.printStackTrace();   }
        }
           
    }
    
    
    public void consume() throws InterruptedException {
        lock.lock();

        // if sharedQuey is empty consumer await until producer produces.
        if (sharedQueue.size() == 0) {
               consumerCondition.await();
        }


     /*If sharedQueue not empty consumer will consume
   * (by removing from sharedQueue) and signal the producer.
   */
        System.out.println("CONSUMED: " + sharedQueue.remove(0));
        producerCondition.signal();

        lock.unlock();

 }
    
}
