package Test1;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("请输入第一个城市：");
		String city1 = s.nextLine();
		
		System.out.println("请输入第二个城市：");
		String city2 = s.nextLine();
		
		if(city1.compareTo(city2)>0){
			System.out.println("第一个城市"+city1+" "+city2);
		}else{
			System.out.println("第一个城市"+city2+" "+city1);
		}
	}
}
