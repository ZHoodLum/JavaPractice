package com.neusoft.oraclejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleTest2 {

	public static void main(String[] args) {
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
			
			//3.��ȡִ��sql����ƽ̨  1.statement�������sqlע�����⣩ 2.prestatement   ps:���õ�һ��
			Statement statement=con.createStatement();
			
//			4.дִ�е�sql��� ������ɾ�Ĳ�
//			statement.executeQuery("select * from sort");
			//���
//			int row = statement.executeUpdate("insert into sort values(1,'����','99','�䰡')");
			//��ѯ
			ResultSet re = statement.executeQuery("select * from sort");
			
//			5.������  
			//���
//			System.out.println("re"+re);
			//��ѯ����
			while(re.next()) {
				System.out.println(re.getInt("sid")+" "+
						re.getString("sname")+" "+
						re.getString("sprice")+" "+
						re.getString("sintroduce")
						);
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
