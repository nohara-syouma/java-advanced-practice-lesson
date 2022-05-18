package jp.co.axiz.util;

import jp.co.axiz.app.App;
import jp.co.axiz.app.CardGameApp;
import jp.co.axiz.app.ClockApp;
import jp.co.axiz.app.DartsGameApp;
import jp.co.axiz.app.GameApp;

public class AppUtil {

	public static boolean isGameApp(App app) {

		if (app instanceof GameApp) {

			return true;
		} else {
			return false;
		}

	}

	public static boolean isCardGameApp(App app) {

		if (app instanceof CardGameApp) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean isDartsGameApp(App app) {

		if (app instanceof DartsGameApp) {
			return true;
		} else {
			return false;
		}

	}
	
	public static boolean isClockApp(App app) {

		if (app instanceof ClockApp) {
			return true;
		} else {
			return false;
		}

	}
	
	public static String getAppName(App app) {
		
		if(app instanceof CardGameApp) {
			
			return "ゲーム:カード";
			
		}else if(app instanceof DartsGameApp) {
			
			return "ゲーム:ダーツ";
		}else if(app instanceof ClockApp){
			return "時計";
		}
		return "";
	}

}
