package com.neusoft.test0711;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		��������
		System.out.println("���ã�");
//		���Ըı�������б���
		byte a = 10;
		System.out.println(a);
//		���� ���� Դ��
		byte a1 = 127;
		a1= (byte) (a1+1);
//		���Ϊ1000 0000  ����-128 
		System.out.println(a1);
		
//		��λ����
		byte b = 1;
		System.out.println(b<<1);
		byte c = 127;
//		������λ�����ʱ��Java������Ὣbyte short��ΪInt���� >>  <<
		System.out.println(c>>1);
		
//		8���� 16����
		int d = 010;
		System.out.println(d);
//		��16��1
		int f = 0x10;
		System.out.println(f);
		
		int h = 10;
//		int h = 128; ���ʱ����byte��Χ
		byte i = 1;
//		�������� byte short int long
		i =(byte) h; //��Ҫ����ǿ������ת��  С������װ��Ķ���
					//int ����ǿ��ת��Ϊbyte����
//		h = i;
		System.out.println(i);
		
		
		
	}

}
