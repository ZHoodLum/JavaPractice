 package com.neusoft.test0717;

public class CC {
	
	
	/**
	 * ���� ��֮Ϊ�вι��췽��
	 * ��Ҫ�����вεķ���  ��Ҫ��newʱ  д��new(����[ʵ��])
	 */
	public CC(int a){
		
		//��Ա�����빹�췽����ͬ�������־ֲ��������Ա����ͬ�������� ʹ��this.���
		this.a = a;
		System.out.println("������int+CC��"+a);
	}
	
	//�޲ι��췽��
	public CC(){
		/**
		 * �ڹ��������� ���Ե�����ͨ����
		 * �ڹ��������� �����������ص�  ������ʹ��this(����)���������������Ͳ�ͬ������Ҳ��ͬ
		 * thisҪд�ڵ�һ��
		 */
		this("aaaaaaa");
		CC("aaaaa");
		System.out.println("�������޲ι��췽����");
	}
	public CC(String a){
		System.out.println("������String���췽��+CC��"+a);
	}
	public void CC(String a){
		System.out.println("������String��Ա����+CC��"+a);
	}
	public void cc(){
		System.out.println("����ֵ����Ϊ�յ�CC����������");
	}
	
	
	int a=10;
	
	public void method1(int a){
		/**
		 * �β��е�A Ҳ�Ǿֲ�����
		 */
		System.out.println("���Ƿ���1  a="+a);
	}
	public void method2(){
		int a=5;
		System.out.println("���Ƿ���2  a="+a);
	}
	public void method3(){
		System.out.println("���Ƿ���3  a="+a);
	}
	public void method4(){
		/**
		 * �����A�ǳ�Ա������A    
		 * ��Ϊû�д��¶���������͵�Aֵ
		 * ����ֱ��ʹ�õĳ�Ա������int a��
		 */
		a=16;
		System.out.println("���Ƿ���4  a="+a);
	}
	
	public void method5(int a){
		/**
		 * ʹ��this�����ֳ�Ա������ֲ������е�A
		 * ����this.a ָ����ǳ�Ա����
		 */
		this.a = a;
		System.out.println("���Ƿ���5  a="+a);
	}
	
}
