package jvm.oomtest;

import java.util.ArrayList;
import java.util.List;

//Java.lang.OutOfMemeoryError:GC overhead limit exceeded 模拟
public class OOMGCOverHeadLimitTest {

	   private byte[] load;
	   
	   public OOMGCOverHeadLimitTest(byte[] load) {
		this.load = load;
	}

	public static void main(String[] args) {
		List list = new ArrayList<>();
		while(true){//调整java -Xms5M -Xmx5M 堆内存为5M
			
			list.add( new OOMGCOverHeadLimitTest(new byte[ (1024*3)]));
		}
	 }
}
