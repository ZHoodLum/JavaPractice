package Test1;

import java.util.Random;

public class Test4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5,6,7,8,9};
		Random r = new Random();
		int s = r.nextInt(10)+1;
		System.out.println("�����"+s);
		
		if(isNum(s,a)){
			System.out.println("��");
		}else{
		 System.out.println("û��");
		}
	
	}
	public static boolean isNum(int search,int[] data){
		for(int x = 0 ; x<data.length;x++){
			if(data[x]==search){
				return true;
			}
		}
		return false;
		
	}
}
