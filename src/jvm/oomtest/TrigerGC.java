package jvm.oomtest;

import java.util.concurrent.TimeUnit;

public class TrigerGC {
 //-Xms40m -Xmx40m -XX:+PrintGCDetails 
	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<3;i++){
			byte[] temp = new byte[1014*1024*8];
			
			TimeUnit.SECONDS.sleep(1);
		}
		for(int i=0;i<3;i++){
			byte[] temp = new byte[1014*1024*22];
			
			TimeUnit.SECONDS.sleep(1);
		}
		for(int i=0;i<3;i++){
			byte[] temp = new byte[1014*1024*8];
			
			TimeUnit.SECONDS.sleep(1);
		}
	}
}
