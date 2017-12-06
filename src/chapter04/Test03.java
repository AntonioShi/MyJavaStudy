package chapter04;

class NoThisSoundException extends Exception{
	public NoThisSoundException() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public NoThisSoundException(String messqge){
		super(messqge);
	}
}

class Player{
	public void play(int index) throws NoThisSoundException {
		if (index > 10) {
			NoThisSoundException exc = new NoThisSoundException("您播放的歌曲不存在");
			throw exc;
		}
	}
}

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player player = new Player();
		try {
			player.play(13);
		} catch (NoThisSoundException e) {
			System.out.println("异常信息为： "+e.getMessage());
		}
	}

}
