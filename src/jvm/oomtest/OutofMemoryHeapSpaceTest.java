package jvm.oomtest;

public class OutofMemoryHeapSpaceTest {
   private byte[] load;
   
   public OutofMemoryHeapSpaceTest(byte[] load) {
	this.load = load;
}

public static void main(String[] args) {
	while(true){//����java -Xms5M -Xmx5M ���ڴ�Ϊ5M
		
		 new OutofMemoryHeapSpaceTest(new byte[1024*1024*10]);
	}
 }
}
