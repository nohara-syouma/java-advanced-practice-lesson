package app;

public abstract class GameApp implements App{

	String item = "";

	public GameApp() {

	}

	public GameApp(String ga) {

		this.item = ga;
		System.out.println(item);

	}

	public abstract String play();

	public String start(String Str) {

		String _Str = Str + "さんと" + item + "でゲームを開始します" + play();

		return _Str;
	}

}