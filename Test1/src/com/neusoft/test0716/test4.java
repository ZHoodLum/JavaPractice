package com.neusoft.test0716;

import java.util.Arrays;
import java.util.TreeSet;

public class test4 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.ð������
		//2.���벻����5λ�� ʵ������ ���
		//3. 1/2+2/3+3/4+.......99/100=?����
		
		//4. int[] a={12,34,54,33,31,67,33,98,31,87};
		// ��������b ��ȥ�غ��a���� ������b������
		//a����������������
		int[] a={12,34,54,33,31,67,33,98,31,87};
		int[] c=new int[a.length]; //{0,0,0.....}
		//    {12,34,54,33,31,67,0}
		//i=0  12 
		//i=1  12,34
		//i=2  12,34,54
		//i=3  12,34,54,33
		//....
		//i=5  12,34,54,33,31,67
		//i=6  12,34,54,33,31,67,33==>0
		//i=6   12 ~33    34 ~33   54~33 [33~33]���ñȽ� break;
 		  
		for(int i=0;i<a.length;i++){
			boolean flag=false;  //��������ظ� true , ���ظ�false   
		     
			for(int j=0;j<i;j++){  //���ƱȽϴ���
			   if(a[i]==a[j]){  //�������ظ�
				   flag=true;
				   break;
			   }else{
				   flag=false;
			   }
			}
			
			if(flag==true){
				c[i]=0;
			}else{
				c[i]=a[i];//��ֵ
			}
			
		}
		
		for(int n:c){
			System.out.print(n+",");
		}
		
		//b�����ж೤
		int blen=0;
		for(int i=0;i<c.length;i++){
			if(c[i]!=0){
				blen++;
			}
		}
		System.out.println();
		System.out.println(blen);
		
		//����b����
		int[] b=new int[blen];
		int j=0;
		//��c���� ������b���鵱��   ������0;
		for(int i=0;i<c.length;i++){
			
			if(c[i]==0){
				
			}else{
				b[j]=c[i];
				j++;
			}
			
		}
		// ����b����
		for(int n:b){
			System.out.print(n+",");
		}
		
		
	}

//		TreeSet ts = new TreeSet();
//		for(String s:a) {
//		    ts.add(s);
//		}
//		String[] array = (String[])ts.toArray(new String[]{});
//		System.out.println(Arrays.toString(array));
//		//���鿽��
//		String[] b = new String[1];
//		System.arraycopy(a, 0, b, 0, a.length);
//		
//		for(String n:b){
//			System.out.print(n);
//		}


}
