package app;

public class CardGameApp extends GameApp{
	
	public CardGameApp() {
		
	}
	
	public CardGameApp(String ca) {
		
		item = ca;
	}
	
	public String play() {
		
		return "ババ抜きを行います。";
		
	}
}