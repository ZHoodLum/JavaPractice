package Test1;

import java.util.Scanner;

public class trangle4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(;;){
			System.out.print("��������ֵ��");
			int a = sc.nextInt();

			int b = a/100;
			System.out.println("��λ��Ϊ��"+b);
			int c = (a/10)%10;
			System.out.println("ʮλ��Ϊ��"+c);
			int d = a%10;
			System.out.println("��λ��Ϊ��"+d);
			
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
