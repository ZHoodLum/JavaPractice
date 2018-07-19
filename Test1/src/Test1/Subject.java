package Test1;

public class Subject {
	public String a="我是父类全局变量a";  
     
    public String b="我是父类全局变量b";  
      
    public void operation(){  
        System.out.println("我是父类方法");  
    };   
    public void operation1(){  
        System.out.println("我是父类方法");  
    }; 
    
//    private int c=99999;
//    private int d=66666;
//    
//    public Subject(int c,int d){
//    	System.out.println("我是局部变量："+c);
//    	System.out.println("我是局部变量："+d);
//    	
//    	System.out.println("我是成员变量："+this.c);
//    	System.out.println("我是成员变量："+this.c);
//    	
//    	int f = c+this.c;
//    	int g = d+this.d;
//    	System.out.println("我是局部+成员变量："+f);
//    	System.out.println("我是局部+成员变量："+g);
//    	
//    }
//    public static void main(String[] args) {
//		Subject s = new Subject(1, 5);
//		
//	}
}
