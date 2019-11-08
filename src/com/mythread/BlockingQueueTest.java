package com.mythread;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueTest {
	static DataQueue dq = new DataQueue(new ArrayBlockingQueue(1));
	
	public static void main(String[] args) {
		//for (int i = 1; i <=5; i++) {
			new Thread(()->{
				
				dq.porduct();
				
			}
			//,i+""
					).start();
			
	//	}
		//for (int i = 1; i <=5; i++) {
			new Thread(()->{
				
				System.out.println(dq.consumer());
				
			}
			//,i+""
			)
			.start();
			
		//}
	}
	
}

class DataQueue{
	BlockingQueue<String> blockingQueue = null;
	
	
	public DataQueue(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	volatile int mark = 1;
	int capacity = 5;
	int index;
	Lock lock = new ReentrantLock();
	Condition condition1 = lock.newCondition();
	Condition condition2 = lock.newCondition();
	public void porduct(){
		
		try {
			lock.lock();
			
			while(true){
				if(mark!=1){
					
					condition1.await();
				}
			blockingQueue.offer(UUID.randomUUID().toString().substring(0,5));
			TimeUnit.SECONDS.sleep(1);
			System.out.println("ÃÌº”ÕÍ≥…£°"+blockingQueue.toString());
			
			index++;
			if(capacity==index){
				mark = 2;
				condition2.signal();
				break;
			}
			mark = 2;
			condition2.signal();

		}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public String consumer() {
		
		String result = null;
		try {
			lock.lock();
			while(true){
				if(mark!=2){
					
					condition2.await();
					
				}
				result = blockingQueue.poll(1,TimeUnit.SECONDS);
				if(result==null){
					break;
				}else
				System.out.println(result);
				if(capacity==index){

					break;
				}
	         mark = 1;
	         condition1.signal();
	         
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		
		return result;
	}
}