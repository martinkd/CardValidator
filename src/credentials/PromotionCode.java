package credentials;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PromotionCode extends BaseCredential {

	public PromotionCode(String credential) {
		super(credential);
	}

	@Override
	public boolean isValid() {
		String patternStr = "^[0-9a-zA-Z]{1,12}";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(credential);
		return matcher.matches();
	}
}
