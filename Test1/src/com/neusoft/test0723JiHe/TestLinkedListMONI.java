package com.neusoft.test0723JiHe;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TestLinkedListMONI {
	public static void main(String[] args) {
		/**
		 * 有序 可重复  list家族  
		 */
		Test4LinkedList t = new Test4LinkedList();
		t.put("aaa");
		t.put("bbb");
		t.put("ccc");
	}
 	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node){
        
        stack1.push(node);
    }
    
    public int pop(){
        
        if(stack2.empty()){
            while(!stack1.empty())
                stack2.push(stack1.pop());
        }
        
        return stack2.pop();
    }
}
