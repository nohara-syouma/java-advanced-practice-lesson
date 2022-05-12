public class Japanese extends Human{
	
	public Japanese() {
		
		
	}
	
	public Japanese(String _name, String _language) {
		
		name = _name;
		language = _language;
		
	}
	
	public String returnBirthPlaceInfo() {
        // 出身地用の文字列
        String msg = "出身地:日本。 日本の公用語は「日本語」です。";

        // 作成した文字列を返却
        return msg;
    }
}