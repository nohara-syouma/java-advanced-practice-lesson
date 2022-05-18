package jp.co.axiz.app;

public class DartsGameApp extends GameApp{
	
	
	public DartsGameApp() {
		
	}
	
	public DartsGameApp(String da) {
		
		setItem(da);
		setPlayTime(10);
		
	}
	
	public String play() {
		
		return "10回投げて合計点を競います";
	}
	
	
	
}