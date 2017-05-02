package credentials;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardNumber extends BaseCredential {

	public CardNumber(String credential) {
		super(credential);
	}

	@Override
	public boolean isValid() {
		String patternStr = "^[0-9]{12,18}";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(credential);
		return matcher.matches();
	}

}
