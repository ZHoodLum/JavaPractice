package Test1;

import java.util.Random;

public class Test4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5,6,7,8,9};
		Random r = new Random();
		int s = r.nextInt(10)+1;
		System.out.println("随机："+s);
		
		if(isNum(s,a)){
			System.out.println("有");
		}else{
		 System.out.println("没有");
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
