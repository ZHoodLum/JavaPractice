package Test1;

public class MySubject extends Subject{
	
	public String b="��������ȫ�ֱ���b";  
    @Override    
    public void operation() {    
        System.out.println(a);  
        System.out.println("this  a��:"+this.a);  
        System.out.println("super  a��:"+super.a);  
    }    
    
    
    @Override    
    public void operation1() {    
        String b="���Ǿֲ�����b";  
        System.out.println(b);  
        System.out.println("this  b��:"+this.b);  
        System.out.println("super  b��:"+super.b);  
    }    
      
    public static void main(String[] args) {  
        Subject sub=new MySubject();  
        sub.operation();    
        sub.operation1();    
          
    } 
}
