package com.neusoft.test0716;

public class ChiJiSimulate {
	
	public static void main(String[] args) {
		ChiJiPerson jl = new ChiJiPerson();
		jl.name="����";
		ChiJiPerson wx = new ChiJiPerson();
		wx.name="����";
		ChiJiPerson cgz = new ChiJiPerson();
		cgz.name="�ܹ�ʩ";
		ChiJiPerson zy = new ChiJiPerson();
		zy.name="����";

		
		//�������� �ܹ�ʩ ���� ȺŹ���
		/**
		 * ���һ����  1
		 *  ���������һ���ˣ�2��3��4��
		 *  ��ֻʣ��һ���� ��ʾ���󼪴��� ����Լ���
		 */
		
		
		/**
		 * ����VSʣ��������
		 * ʵ�ֵ�  ֻʣ��һ���� ��ʾ���󼪴��� ����Լ���
		 */
		while(true){
			if(jl.huozhe==true){
				if(wx.huozhe==true){
					jl.hit(wx);
				}else if(cgz.huozhe==true){
					jl.hit(cgz);
				}else if(zy.huozhe==true){
					jl.hit(zy);
				}else{
					break;
				}
				if(jl.huozhe==true){
					wx.hit(jl);
				}else{
					break;
				}
				if(jl.huozhe==true){
					cgz.hit(jl);
				}else{
					break;
				}
				if(jl.huozhe==true){
					zy.hit(jl);
				}else{
					break;
				}
		}
		
		}
		
		
		
		
		
		
		
		
		//ģ��������� һ��
/*		wx.hit(jl);
		//ģ�⽯�ڴ�����  �ɺ�
		for(int i=0;i<=10;i++){
			jl.hit(wx);
			System.out.println();
			
		}
*/
	}
}
