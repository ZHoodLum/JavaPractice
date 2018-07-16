package com.neusoft.test0716;

public class ChiJiSimulate {
	
	public static void main(String[] args) {
		ChiJiPerson jl = new ChiJiPerson();
		jl.name="蒋磊";
		ChiJiPerson wx = new ChiJiPerson();
		wx.name="王旭";
		ChiJiPerson cgz = new ChiJiPerson();
		cgz.name="曹广施";
		ChiJiPerson zy = new ChiJiPerson();
		zy.name="张寅";

		
		//蒋磊王旭 曹广施 张寅 群殴打架
		/**
		 * 随机一个人  1
		 *  蒋磊随机打一个人（2，3，4）
		 *  当只剩下一个人 提示：大吉大利 今晚吃鸡！
		 */
		
		
		/**
		 * 蒋磊VS剩下三个人
		 * 实现当  只剩下一个人 提示：大吉大利 今晚吃鸡！
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
		
		
		
		
		
		
		
		
		//模拟王旭打蒋磊 一下
/*		wx.hit(jl);
		//模拟蒋磊打王旭  成盒
		for(int i=0;i<=10;i++){
			jl.hit(wx);
			System.out.println();
			
		}
*/
	}
}
