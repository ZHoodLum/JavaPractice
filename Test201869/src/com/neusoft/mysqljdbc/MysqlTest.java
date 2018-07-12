package com.neusoft.mysqljdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlTest {

	public static void main(String[] args) {
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
			int row = statement.executeUpdate("insert into sort values(8,'����','99','�䰡')");
			
//			5.������
			System.out.println("row"+row);
			
//			6.�ر�����
			statement.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
