package com.neusoft.test0714;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class test28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList<String> lists = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String[][] st = new String[10][10];
		int i=0,j=0,k=0;
        for ( i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
                //生成随机数，复制给数组元素
                st[i][j] = sc.next();
            }
        }
        for(int m=0;m<2;m++){//控制行数
            for(int n=0;n<2;n++){//一行中有多少个元素（即多少列）
                System.out.print(st[m][n]+" ");
            }
            System.out.println();
        }
		
		
	}

}
