package Test1;

import java.io.Serializable;

public class Person implements Serializable{
//	protected String name = "Person";
//	int age = 0;
	
	
//	public static void main(String[] args) {
//		String s = null;
//		s.concat("abc");
//	}
		private String name;
	    private int age;
//	    transient int age;
	    
	    
	    public Person() {
	    }
	    public Person(String name) {
	        this.name = name;
	    }
	    public Person(String name, int age) {
	        this.setName(name);
	        this.setAge(age);
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String getName() {
	        return this.name;
	    }
	    public void setAge(int age) {
	        if (age > 0 && age < 140) {
	            this.age = age;
	        }
	    }
	    public int getAge() {
	        return this.age;
	    }
	    public void tell() {
	        System.out.println("ĞÕÃû£º" + this.getName() + "£¬ÄêÁä£º" + this.getAge());
	    }
}

