package Test1;

import java.util.LinkedList;
import java.util.List;

public class DuiLie {
	
	static LinkedList list1 = new LinkedList();
	static LinkedList list2 = new LinkedList();
	
	public static void main(String[] args) {
		DuiLie d = new DuiLie();
		d.put("aaa");
		d.put("bbb");
		d.put("ccc");
	}
	
	public void put(Object o ){
		list1.push(o);
	}
	
	public Object get(){
		while(isEmpty(list1)){
			list2.push(list1.pop());
		}
		if(!isEmpty(list2)){
			return list2.pop();
		}else{
			return "�Բ���û����Ϊ�գ�";
		}
	}
	//�ж�list�Ƿ�Ϊ��
	public boolean isEmpty(List list){
		if(list.size()<=0){
			return true; //��Ϊ��
		}else{
			return false;//Ϊ��
		}
		
	}
}
