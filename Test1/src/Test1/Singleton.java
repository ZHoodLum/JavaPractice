package Test1;


public class Singleton {
	//µ¥ÀýÄ£Ê½
	//ÀÁºº
	private Singleton(){};
	private static Singleton single = null;
	public static Singleton getInstance(){
		if(single == null){
			single = new Singleton();
		}
		return single;
	}
}
