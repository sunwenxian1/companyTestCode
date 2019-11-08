package jvm.oomtest;

import java.util.concurrent.TimeUnit;

public class OOMCreateThreadTest {
	
	
 public static void main(String[] args) {
	 int j = 0;
	 try {
		 for (int i = 0; ; i++) {
			 j++;
			 new Thread(new Runnable() {
				 @Override
				 public void run() {
					 try {
						 TimeUnit.SECONDS.sleep(3);
					 } catch (InterruptedException e) {
						 // TODO Auto-generated catch block
						 e.printStackTrace();
					 }
				 }
			 }).start();
		 }
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		System.out.println(j);
	}
}
 
}
