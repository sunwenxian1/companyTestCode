package jvm.oomtest;

public class stackOverFlowTest {
// private static int i = 0;
 
	public static void main(String[] args) {
		//������ȵ��ã��ݹ���ɸô��� -Xss:64 ���������ջ Ϊ64k��С
		//	while(true){
				
				
				invo();
			//}
			
	}
	
	private static void invo(){
		
		invo();
	}
}
