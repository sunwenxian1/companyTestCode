package com.mythread;

import java.util.concurrent.*;  
import java.util.Date;  
import java.util.HashMap;
import java.util.List;  
import java.util.ArrayList;  
import java.util.Map;


  
/** 
* �з���ֵ���߳� 
*/  
@SuppressWarnings("unchecked")  
public class Test {  
public static void main(String[] args) throws ExecutionException,  
    InterruptedException {  
   System.out.println("----����ʼ����----");  
   Date date1 = new Date();  
  
   int taskSize = 3;  
   // ����һ���̳߳�  
   ExecutorService pool = Executors.newFixedThreadPool(taskSize);  
   // ��������з���ֵ������  
   List<Future> list = new ArrayList<Future>();  
   for (int i = 1; i <= taskSize; i++) {  
	   MyCallable c = new MyCallable(i + " ");  
    c.methodName=i+"";
    // ִ�����񲢻�ȡFuture����  
    Future f = pool.submit(c);  
    // System.out.println(">>>" + f.get().toString());  
    list.add(f);  
   }  
   // �ر��̳߳�  
   pool.shutdown();  
  
   // ��ȡ���в�����������н��  
   for (Future f : list) {  
    // ��Future�����ϻ�ȡ����ķ���ֵ�������������̨  
    System.out.println(">>>" + f.get());  
   }  
  
   Date date2 = new Date();  
   System.out.println("----�����������----����������ʱ�䡾"  
     + (date2.getTime() - date1.getTime()) + "���롿");  
}  
}  
  
class MyCallable implements Callable<Object> {  
private String taskNum;  
  
MyCallable(String taskNum) {  
   this.taskNum = taskNum;  
}  
public String methodName;

@SuppressWarnings("unchecked")
@Override
public Object call() {
  if("1".equals(methodName)){
	  
	 // ncfCallInAgMonitor.getAgentData();
	  System.out.println("1");
	  
	  return 121;
  }else if("2".equals(methodName)){
	  System.out.println("2");
	  List l = new ArrayList<String>();
	  l.add("2");
	  l.add("3");
	  l.add("4");
	  return l;
  }else if("3".equals(methodName)){
	  System.out.println("3");
	 Map m = new HashMap();
	 m.put(1, "123");
	 m.put(2, "456");
	 return m;
  }
 return null;
} 
}