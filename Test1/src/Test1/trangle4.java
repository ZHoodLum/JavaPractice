package Test1;

import java.util.Scanner;

public class trangle4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(;;){
			System.out.print("请输入数值：");
			int a = sc.nextInt();

			int b = a/100;
			System.out.println("个位数为："+b);
			int c = (a/10)%10;
			System.out.println("十位数为："+c);
			int d = a%10;
			System.out.println("百位数为："+d);
			
			if(b==c){
				System.out.println(b+""+c);
			}else if(b==d){
				System.out.println(b+""+c+""+d);
			}else{
				System.out.println(b+""+c+""+d);
				System.out.println();
			}
			continue;
		}
	}

}
