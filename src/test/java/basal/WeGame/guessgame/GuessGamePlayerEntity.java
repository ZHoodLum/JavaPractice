package basal.WeGame.guessgame;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/24
 * @Description:
 */



public class GuessGamePlayerEntity {
	//比赛进行次数
	int number = 0;
	
	public int guess() {
		//选手没有嘴巴  捐给需要的人吧  系统随机生成
		number = (int) (Math.random() * 10);
//		System.out.println("猜的数字是：" + number);
		return number;
	}
}

