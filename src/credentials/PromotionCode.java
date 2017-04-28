package credentials;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PromotionCode implements BaseCredential{
	
	private String promoCode;

	public PromotionCode(String promCode) {
		this.promoCode = promCode;
	}

	@Override
	public boolean isValid() {
		String patternStr = "^[0-9a-zA-Z]{1,12}";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(promoCode);
		return matcher.matches();
	}
}
