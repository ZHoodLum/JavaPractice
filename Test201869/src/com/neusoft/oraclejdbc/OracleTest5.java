package com.neusoft.oraclejdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleTest5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con=OracleTest5Util.getConnection();//ʹ�ù����� ������ ʡ���� 1 2�̶��Ĳ���
			//ִ�в�ѯ sort ����Ϣ
		PreparedStatement prestatement;
		try {
			prestatement = con.prepareStatement("select * from users where username = ? and password= ? ");
		
		prestatement.setObject(1,"a" );
		prestatement.setObject(2,"1" );
		
		ResultSet resultSet=prestatement.executeQuery();
		
//		int row=statement.executeUpdate("insert into sort values(11,'�紵��',998, '���������ĵ紵��')");
		
		//5.������     resultSet.next()----> true   false
//		while(resultSet.next()){     
//			//���д�1��ʼ
//			System.out.println(resultSet.getString(2)  +"  "+ resultSet.getString(3));
//		
//		} 
		//6.�ر�����
	
		if(resultSet.next()){
			System.out.println("��½�ɹ���");
		}else{
			System.out.println("��¼ʧ���û������������");
		}
		
	
		OracleTest5Util.closeConnection(prestatement, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
