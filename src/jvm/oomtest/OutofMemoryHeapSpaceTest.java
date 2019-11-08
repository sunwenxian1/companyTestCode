package jvm.oomtest;

public class OutofMemoryHeapSpaceTest {
   private byte[] load;
   
   public OutofMemoryHeapSpaceTest(byte[] load) {
	this.load = load;
}

public static void main(String[] args) {
	while(true){//调整java -Xms5M -Xmx5M 堆内存为5M
		
		 new OutofMemoryHeapSpaceTest(new byte[1024*1024*10]);
	}
 }
}
