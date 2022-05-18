package app;

public abstract class GameApp implements App{

	private String item = "";
	private int playTime = 0;

	public GameApp() {

	}

	public GameApp(String ga) {

		this.item = ga;
		System.out.println(item);
		
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getPlayTime() {
		return playTime;
	}

	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}

	protected abstract String play();

	public String start(String Str) {

		String _Str = Str + "さんと" + item + "でゲームを開始します" + play();
						

		return _Str;
	}

}