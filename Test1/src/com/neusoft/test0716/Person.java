package com.neusoft.test0716;
/**
 * 	�鿴Test6
 *   class ����{
 *		//����
 *		//�����Ա����
 *		int a = 10;
 *		//�����Ա����
 *		public void aa(){}
 *
 *
 *
 *   }
 */
//��    ��
public class Person {

//	�Ƿ��ж���
//	����	
//	����������ʽ  �ǳ�Ա����
	boolean duixiang = false;
	String name;

	
//	�Է���һ����Ϊ
//	��Ϊ����ɷ���	
//	�������ַ���   �ǳ�Ա����
	public void eat(){
		System.out.println("�Է�");
	}
	//˵��  ��Ϊ
	public void say(){
		System.out.println("��ã��ҽУ�"+name);
		if(duixiang==false){
			System.out.println("�����п󰡣���Ҫ����");
		}else{
			System.out.println("˫����");
		}
	}
	
}
