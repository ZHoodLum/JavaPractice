package Test1;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("�������һ�����У�");
		String city1 = s.nextLine();
		
		System.out.println("������ڶ������У�");
		String city2 = s.nextLine();
		
		if(city1.compareTo(city2)>0){
			System.out.println("��һ������"+city1+" "+city2);
		}else{
			System.out.println("��һ������"+city2+" "+city1);
		}
	}
}
