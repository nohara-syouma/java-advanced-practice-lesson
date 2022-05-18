package app;

public class CardGameApp extends GameApp {

	public CardGameApp() {

	}

	public CardGameApp(String ca) {
		
		setItem(ca);
		setPlayTime(5);
	}

	protected String play() {

		return "ババ抜きを行います。";

	}
}