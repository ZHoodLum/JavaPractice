package com.exam.impl;

public class DukePerformer implements Performer{
	 private String name;  
	     public void setName(String name)  
	    {  
	         this.name=name;  
	     }  
	     public String getName()  
	     {  
	         return this.name;  
	     }  
	    @Override  
	    public void perform() {  
	        // TODO Auto-generated method stub  
	         System.out.println(this.name+" sing a song.");  
	     }  
}
