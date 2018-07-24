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
			return "对不起没返回为空！";
		}
	}
	//判断list是否为空
	public boolean isEmpty(List list){
		if(list.size()<=0){
			return true; //不为空
		}else{
			return false;//为空
		}
		
	}
}
