package com.neusoft.oraclejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class OracleTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û���:");
		String au = sc.next();
		System.out.println("����������:");
		String ap = sc.next();
		
//		java ʹ��jdbc����oralce���ݿ�
//		1.ע������   ps:Oracle��MySQLע������ʱ �ǲ�ͬ��
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		2.��������url  ��������  --> url username password    ps:��ͬ�����ݿ� ��ͬ�ĵ�ַ ���ݲ�ͬ
		
		//@����   ��  ��Զ�����ӻ򱾵����ӵ�ip��ַ     orcl
		String url="jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
		
		//����Oracle���û��� ����
		String username="scott";
		String password="tiger";
		
		//���� ps:�����쳣
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			System.out.println(con);
			
			//3.��ȡִ��sql����ƽ̨  1.statement�������sqlע�����⣩ 2.preparestatement   ps:���õ�һ�� 
//			ʹ��prepareStatement
			PreparedStatement pr = con.prepareStatement("select * from users where username = ? and password = ?");
			
			pr.setObject(1, au);
			pr.setObject(2, ap);
			
//			4.дִ�е�sql��� ������ɾ�Ĳ�
			//��ѯ
			ResultSet re = pr.executeQuery();
			
//			5.������  
			//���е�¼
			if(re.next()) {
				System.out.println("��½�ɹ���");
			}else {
				System.out.println("��½����");
			}
//			6.�ر�����
			pr.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
