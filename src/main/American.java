public class American extends Human{
	
	public American() {
		
		
	}
	
	public American(String _name, String _language) {
		
		name = _name;
		language = _language;
	}
	
	public String returnBirthPlaceInfo() {
		
		// 出身地用の文字列
        String msg = "出身地：アメリカ。 アメリカの公用語は「英語」です。";

        // 作成した文字列を返却
        return msg;
	}
}