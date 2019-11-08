package com.test;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		Node node1 = new Node(1, "1号", "我是1号");
		Node node2 = new Node(2, "2号", "我是2号");
		Node node3 = new Node(3, "3号", "我是3号");
		Node node4 = new Node(4, "4号", "我是4号");
		Node node5 = new Node(5, "5号", "我是5号");
		Node node6 = new Node(6, "6号", "我是6号");
		
		DoubleLinkedList dll = new DoubleLinkedList();
/*		dll.addNode(node2);
		dll.addNode(node1);
		dll.addNode(node3);
		dll.addNode(node4);
		dll.addNode(node5);*/
		
		dll.addNodeInOrder(node2);
		dll.addNodeInOrder(node1);
		dll.addNodeInOrder(node4);
		dll.addNodeInOrder(node6);
		dll.addNodeInOrder(node5);
		dll.addNodeInOrder(node3);
		
	/*	dll.list();
		System.out.println("-------------");
		//dll.selectNode(4);
		System.out.println("-------------");
		dll.delNode(4);
		System.out.println("-------------");
		
		Node newNode = new Node(6, "6号是我", "我是6号，我真的是6号");
		
		dll.updateNode(newNode);*/
/*		dll.list();
		reverseDll_1(dll);
		newDll.list();*/
		reverseDll_2(dll);
	}
	static DoubleLinkedList newDll = new DoubleLinkedList();
	public static void reverseDll_1(DoubleLinkedList dll){
		Node temp  = dll.head;
		
		while(true){
			if(temp.next==null){//temp为最后一个节点，取出该节点
				temp.pre.next = null;
				temp.pre = null;
				newDll.addNode(temp);
				if(dll.head.next!=null){
					reverseDll_1(dll);
				}
				break;
			}
			temp = temp.next;
		}
		
	}
	
	public static void reverseDll_2(DoubleLinkedList dll){
		Node temp = dll.head.next;
		Node temp1 = newDll.head;
		while(temp!=null){
			if(temp.next==null){
				temp.pre = null;
				temp1.next = temp;
				temp.pre = temp1;
				temp1 = temp1.next;
				break;
			}else{
				temp.next.pre = temp.pre;
				temp.pre.next = temp.next;
				temp1.next = temp;
				temp.pre = temp1;
				temp1 = temp1.next;
			}
			System.out.println(temp.toString());
			temp = temp.next;
		}
		reverseDll_2(newDll);
	}
}

class DoubleLinkedList{
  Node head  = new Node(0,"","");
	
	public void addNode(Node newNode){
		Node temp = head;
		while(true){
			if(null==temp.next){//最后一个节点
				
				temp.next = newNode;
				newNode.pre = temp;
				break;
			}
			temp  = temp.next;
		}
	}
	
   public void addNodeInOrder(Node newNode){
		Node temp = head;
		while(true){
			if(null==temp.next){//最后一个节点
				
				temp.next = newNode;
				newNode.pre = temp;
				break;
			}else{//不是最后一个节点，比较序号
				if(newNode.no<temp.next.no){
					Node tempNode = temp.next;
					tempNode.pre = null;
					
					newNode.next = tempNode;
					tempNode.pre = newNode;
					
					temp.next = newNode;
					newNode.pre = temp;
					break;
				}
			}
			temp  = temp.next;
		}
   }
	
   public void selectNode(int NodeNo){
	   Node temp = head.next;
	   while(true){
		   if(temp==null){
			   
			   break;
		   }else if(temp.no == NodeNo){
			   System.out.println(temp.toString());
			   break;
		   }
		   temp = temp.next;
	   }
   }
   
   public void delNode(int NodeNo){
	   Node temp = head.next;
	   while(true){
		   if(temp==null){
			   
			   break;
		   }else if(temp.no == NodeNo){
			   System.out.println("删除了"+temp.toString());
			   if(temp.next==null){//最后一个节点
				   temp.pre.next = null;
			   }else{
				   //不是最后一个节点
				   Node tempNode = temp.next;
				   tempNode.pre = null;
				   
				   temp.pre.next = tempNode;
				   tempNode.pre = temp.pre;
				   
				   temp = null;
			   }
			   break;
		   }
		   temp = temp.next;
	   }
   }
   
   
  public void updateNode(Node newNode){
	   Node temp = head.next;
	   while(true){
		   if(temp==null){
			   
			   break;
		   }else if(temp.no == newNode.no){
			   System.out.println("修改了"+temp.toString());
			   temp.name = newNode.name;
			   temp.nicName = newNode.nicName;
			   break;
		   }
		   temp = temp.next;
	   }
  }
	public void list(){
	Node temp  = head.next;
		while(true){
			if(temp==null){//最后一个节点
				
				break;
			}
			System.out.println(temp.toString());
			temp = temp.next;
		}
	}
}
class Node{
	public int no;
	public String name;
	public String nicName;
	public Node pre;
	public Node next;
	
	public Node(){
		
	}

	public Node(int no, String name, String nicName) {
		super();
		this.no = no;
		this.name = name;
		this.nicName = nicName;
	}

	@Override
	public String toString() {
		return "Node [name=" + name +  ", nicName=" + nicName
				+ ", no=" + no + "]";
	}
	
	
}