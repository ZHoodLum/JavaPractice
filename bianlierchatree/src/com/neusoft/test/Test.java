package com.neusoft.test;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		digui();
		normal();
	     
	}
	public static void digui(){
		   BinaryTree tree = new BinaryTree();  
	        Node root = tree.goujian();  
	        System.out.println("先序遍历");  
	        tree.firstOrderTraversal(root);  
	        System.out.println();  
	        System.out.println("中序遍历");  
	        tree.inOrderTraversal(root);  
	        System.out.println();  
	        System.out.println("后序遍历");  
	        tree.postOrderTraversal(root);  
	        System.out.println(); 
	}
	public static void normal(){
		 BinaryTree tree = new BinaryTree();  
	        Node root = tree.goujian();  
	        System.out.println("先序遍历");  
	        tree.stackFirstOrderTraversal(root);  
	        System.out.println();  
	        System.out.println("中序遍历");  
	        tree.stackInOrderTraversal(root);  
	        System.out.println();  
	        System.out.println("后序遍历");  
	        tree.stackPostOrderTraversal(root);  
	        System.out.println(); 
	}

}
