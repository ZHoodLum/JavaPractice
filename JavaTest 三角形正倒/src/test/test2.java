package test;

import java.util.Scanner;

public class test2 {
	public static void main(String[] args) {
		//��������
		int line=6;//��������
        for(int i=0;i<line;i++){
	        for(int j=0;j<i;j++){
	            System.out.print(" ");
	        }
	        //��ӡ*�ĸ���
	        for( int j=0;j<2*(line-i)-1;j++){
	            System.out.print("*");
	        }
	        //��ӡ��*�ǵû���
	        System.out.println();
        }
        

        //��ӡһ��
        //��ӡ�ϰ벿��
        for(int i=0;i<line;i++){
            //��ӡi���ո�
	        for(int j=0;j<line-1-i;j++){
	                System.out.print(" ");
	            }
	            //��ӡ*�ĸ���
	        for( int j=0;j<2*i+1;j++){
	            System.out.print("*");
	        }
	                //��ӡ��* �ǵû���
	            System.out.println();
        } 
		
		
		//����̨����
//		   System.out.print("��ӡһ���������������Σ��ױ߳�Ϊ����������ڻ����������������");  
//		    Scanner in=new Scanner(System.in);  
//		    int m=in.nextInt();  
//		    int n=(m-1)/2;  
//		    String A=" ";  
//		    String B="*";  
//		    for(int i=0;i<=n;i++){  
//		        for(int j=0;j<=i;j++){  
//		            System.out.print(A);  
//		        }  
//		        for(int j=0;j<=2*n-2*i;j++){  
//		            System.out.print(B);  
//		        }  
//		        System.out.println();  
//		    }
	}
}
