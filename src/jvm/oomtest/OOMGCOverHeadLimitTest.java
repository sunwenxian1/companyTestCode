package jvm.oomtest;

import java.util.ArrayList;
import java.util.List;

//Java.lang.OutOfMemeoryError:GC overhead limit exceeded ģ��
public class OOMGCOverHeadLimitTest {

	   private byte[] load;
	   
	   public OOMGCOverHeadLimitTest(byte[] load) {
		this.load = load;
	}

	public static void main(String[] args) {
		List list = new ArrayList<>();
		while(true){//����java -Xms5M -Xmx5M ���ڴ�Ϊ5M
			
			list.add( new OOMGCOverHeadLimitTest(new byte[ (1024*3)]));
		}
	 }
}
