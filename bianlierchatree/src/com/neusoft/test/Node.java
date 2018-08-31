package com.neusoft.test;

public class Node {
	private String data;  //当前节点
    private Node leftNode;  //左子树 ，左孩子节点
    private Node rightNode;  //右子树 ，右孩子节点
    public Node(String data, Node leftNode, Node rightNode){  
        this.data = data;  
        this.leftNode = leftNode;  
        this.rightNode = rightNode;  
    }  
  
    public String getData() {  
        return data;  
    }  
    public void setData(String data) {  
        this.data = data;  
    }  
    public Node getLeftNode() {  
        return leftNode;  
    }  
    public void setLeftNode(Node leftNode) {  
        this.leftNode = leftNode;  
    }  
    public Node getRightNode() {  
        return rightNode;  
    }  
    public void setRightNode(Node rightNode) {  
        this.rightNode = rightNode;  
    }  
}
