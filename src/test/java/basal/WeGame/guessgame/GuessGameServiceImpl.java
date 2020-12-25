package basal.WeGame.guessgame;

/**
 * @author：ZDY
 * @Date：Created in 2020/12/24
 * @Description:游戏进度
 */

public class GuessGameServiceImpl {
	//三位不知名的选手 选手状态就位
	GuessGamePlayerEntity yuxi = new GuessGamePlayerEntity();
	GuessGamePlayerEntity liqun = new GuessGamePlayerEntity();
	GuessGamePlayerEntity huazi = new GuessGamePlayerEntity();
	String sun = "";
	boolean flag = false;

	//游戏开始
	public void startGame() {
		//随机筛选的数字
		int targetNumber = (int) (Math.random() * 10);
		System.out.println("今天我王多鱼投一个数组，猜中的人我投他的项目,选手数字不可以重复噢.....");
		while(true) {
			//公布选手选中的数组
			int yuxiNum = yuxi.guess();
			System.out.println("玉溪大哥猜的数字是：" +  yuxiNum);

			int liqunNum = liqun.guess();
			System.out.println("利群大哥猜的数字是：" + liqunNum);

			int huaziNum = huazi.guess();
			System.out.println("华子大哥猜的数字是：" + huaziNum);

			if (yuxiNum == targetNumber) {
				sun = "yuxi";
				flag = true;
			}
			if (liqunNum == targetNumber) {
				sun = "liqun";
				flag = true;
			}
			if (huaziNum == targetNumber) {
				sun = "huazi";
				flag = true;
			}

			if(flag) {
				System.out.println("王多鱼宣布幸运数字是-----["+targetNumber+"]--------");
				System.out.println("今天的幸运儿是：?" + sun);
				System.out.println("Game is over!");
				break;
			}else {
				System.out.println("Player will have to try again!");
				System.out.println();
			}
		}
		
	}

}
