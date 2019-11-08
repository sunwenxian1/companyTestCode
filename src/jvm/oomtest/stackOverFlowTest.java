package jvm.oomtest;

public class stackOverFlowTest {
// private static int i = 0;
 
	public static void main(String[] args) {
		//方法深度调用，递归造成该错误 -Xss:64 调整虚拟机栈 为64k大小
		//	while(true){
				
				
				invo();
			//}
			
	}
	
	private static void invo(){
		
		invo();
	}
}
