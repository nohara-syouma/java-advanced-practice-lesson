package app;

public class DartsGameApp extends GameApp{
	
	
	public DartsGameApp() {
		
	}
	
	public DartsGameApp(String da) {
		
		item = da;
		
	}
	
	public String play() {
		
		return "10回投げて合計点を競います";
	}
	
	
	
}