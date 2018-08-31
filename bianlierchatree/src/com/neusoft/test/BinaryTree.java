package com.neusoft.test;

import java.util.Stack;

public class BinaryTree {
	 public Node goujian() {//逆序建立
		    
		    Node dr = null;//new Node(null, null, null);
		    Node gr = null;//new Node(null, null, null);
		    Node gl = null;//new Node(null, null, null);		 
		    Node fr = null; //new Node(null, null, null);
		    Node fl = null;//new Node(null, null, null);		 
		    Node er = null;//new Node(null, null, null);
		    Node el = null;//new Node(null, null, null);		 	
		    Node hr = null;//new Node(null, null, null);
		    Node hl = null;//new Node(null, null, null);
	        Node H = new Node("H", hl, hr);  
	        Node G = new Node("G", gl, gr);  
	        Node F = new Node("F", fl, fr);  
	        Node E = new Node("E", el, er);  
	        Node D = new Node("D", H, dr);  
	        Node C = new Node("C", F, G);  
	        Node B = new Node("B", D, E);  
	        Node A = new Node("A", B, C);  
	        return A;    //从根节点开始
	    }
	 
	 public void firstOrderTraversal(Node node) {  //先序遍历  调用方法传进来的第一个根节点A
		 if (node != null) { 
	        System.out.println(node.getData());  //打印（根）节点
	          //使用递归进行遍历左孩子  
	        firstOrderTraversal(node.getLeftNode());  
	          //递归遍历右孩子  
	        firstOrderTraversal(node.getRightNode());  
		 }
	    }  
	    public void inOrderTraversal(Node node) {  //中序遍历  
	    	if (node != null) { 
		        inOrderTraversal(node.getLeftNode());  
		        System.out.println(node.getData());  //打印（根）节点
		        inOrderTraversal(node.getRightNode());  
	    	}
	    }
	    
	    
	    public void postOrderTraversal(Node node) {  //后序遍历  
	    	if (node != null) { 
	        	postOrderTraversal(node.getLeftNode());  
	        	postOrderTraversal(node.getRightNode());  
	            System.out.println(node.getData());  //打印（根）节点 
	    	}
	    }  
	 
	    
	    public void stackFirstOrderTraversal(Node node) {  //先序遍历  
	        Stack<Node> stack = new Stack<Node>();  
	         
	        if(node!=null){
	        	stack.push(node);
	        }
	        while (stack.size() > 0) {  
	        	node=stack.pop();
	        	System.out.println(node.getData());
	        	if(node.getRightNode()!=null){
	        		stack.push(node.getRightNode());
	        	}
	        	if(node.getLeftNode()!=null){
	        		stack.push(node.getLeftNode());
	        	}
	           
	        }  
	    }  
	      
	    public void stackInOrderTraversal(Node node) {  //中序遍历  
	        Stack<Node> stack = new Stack<Node>();  
	        if(node!=null){
	        while ( stack.size() > 0|| node != null) {//栈不为空或者node不为空时循环  
	            while (node != null) {  //扫描node下的所有左下节点进栈
	                stack.push(node);   //直接压栈  
	                node = node.getLeftNode();  
	            } 
	            if(stack.size()>0) {  
	                node = stack.pop(); //出栈并访问  
	                System.out.println(node.getData());
	                node = node.getRightNode(); 
	            }  
	        }
	        }
	    }  
	      
	    public void stackPostOrderTraversal(Node node) {   //后序遍历  
	        Stack<Node> stack = new Stack<Node>();
	        Node p=null;
	        boolean flag=false;
	       if(node!=null){
	    	   do{
	    		   while(node!=null){ //将node所有左下节点进栈
	    			   stack.push(node);
	    			   node=node.getLeftNode();
	    		   }
	    		   p=null;
	    		   flag=true;
	    		   while(stack.size()>0&&flag){
	    			   node=stack.peek();//仅查看
	    			   if(node.getRightNode()==p){//如果右孩子不存在或者右孩子已经被访问，访问之
	    				   System.out.println(node.getData());
	    				   stack.pop();
	    				   p=node;
	    			   }else{
	    				   node=node.getRightNode();
	    				   flag=false;
	    			   }
	    		   }
	    	   }while(stack.size()>0);
	    	   
	    	   
	    	   
	       }
	     
	    }
}
