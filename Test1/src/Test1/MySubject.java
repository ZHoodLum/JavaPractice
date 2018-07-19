package Test1;

public class MySubject extends Subject{
	
	public String b="我是子类全局变量b";  
    @Override    
    public void operation() {    
        System.out.println(a);  
        System.out.println("this  a是:"+this.a);  
        System.out.println("super  a是:"+super.a);  
    }    
    
    
    @Override    
    public void operation1() {    
        String b="我是局部变量b";  
        System.out.println(b);  
        System.out.println("this  b是:"+this.b);  
        System.out.println("super  b是:"+super.b);  
    }    
      
    public static void main(String[] args) {  
        Subject sub=new MySubject();  
        sub.operation();    
        sub.operation1();    
          
    } 
}
