package com.neusoft.mysqljdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MysqlTest3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û���:");
		String au = sc.next();
		System.out.println("����������:");
		String ap = sc.next();
		
		// TODO Auto-generated method stub
//		java ʹ��jdbc����mysql���ݿ�
//		1.ע������   ps:Oracle��MySQLע������ʱ �ǲ�ͬ��
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		2.��������url  ��������  --> url username password    ps:��ͬ�����ݿ� ��ͬ�ĵ�ַ ���ݲ�ͬ
		
		//@����   ��  ��Զ�����ӻ򱾵����ӵ�ip��ַ     orcl
		String url="jdbc:mysql://localhost:3306/db8";
//		String url="jdbc:mysql://127.0.0.1:3306/db8";
		
		//����mysql���û��� ����
		String username="root";
		String password="root";
		
		//���� ps:�����쳣
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			System.out.println(con);
			
//			3.��ȡִ��sql����ƽ̨  1.statement�������sqlע�����⣩ 2.prestatement   ps:���õ�һ��
			Statement statement=con.createStatement();
			
//			4.дִ�е�sql��� ������ɾ�Ĳ�
//			statement.executeQuery("select * from sort");
			//���
//			int row = statement.executeUpdate("insert into sort values(1,'����','99','�䰡')");
			
			//��ѯ ��¼
			ResultSet re = statement.executeQuery("select * from users where username = '"+au+"' and password = '"+ap+"' ");
			
//			5.������  
			//���
//			System.out.println("re"+re);
			//��ѯ����
//			while(re.next()) {
//				System.out.println(re.getInt("id")+" "+
//						re.getString("username")+" "+
//						re.getString("password")
//						);
//			}
			//���е�¼
			if(re.next()) {
				System.out.println("��½�ɹ���");
			}else {
				System.out.println("��½����");
			}
			
			
			
//			6.�ر�����
			statement.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
