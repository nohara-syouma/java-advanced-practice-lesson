package app;


public class GameApp {

    public String item; 

   
    public GameApp() {
    }

    
    public GameApp(String _item) {
        item = _item;
    }

    
    public String start(String userName) {
        // アプリ開始を表す文字列を返却
        String startMessage = userName + "さんと" + item + "でゲームを開始します";

        return startMessage;
    }
}

