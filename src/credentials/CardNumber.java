package credentials;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardNumber implements BaseCredential{
	
	private String cardNum;
	
	public CardNumber(String cardNum) {
		this.cardNum = cardNum;
	}
	
	@Override
	public boolean isValid() {
		String patternStr = "^[0-9]{12,18}";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(cardNum);
		return matcher.matches();
	}

}
