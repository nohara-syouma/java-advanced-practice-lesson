package app;

public class CardGameApp extends GameApp {
	
	
	public CardGameApp() {
		
    }
	
	
	public CardGameApp(String _item) {
		
		 item = _item;
		
    }
	
	public String start(String userName) {
        // アプリ開始を表す文字列を返却
        String startMessage = userName + "さんと" + item + "でゲームを開始します";

        return startMessage;
	
	}
	
}