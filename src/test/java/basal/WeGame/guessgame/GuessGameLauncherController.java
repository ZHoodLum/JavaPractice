package basal.WeGame.guessgame;
/**
 * @author：ZDY
 * @Date：Created in 2020/12/24
 * @Description:裁判员
 * GuessGameServiceImpl.java  游戏进度
 * GuessGamePlayerEntity.java   选手  发言选数字
 * GuessGameLauncherController.java 裁判  监督游戏进度 情况
 */

public class GuessGameLauncherController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuessGameServiceImpl game = new GuessGameServiceImpl();
		System.out.println("游戏开始");
		game.startGame();
	}

}
