package credentials;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckSum extends BaseCredential {

	public CheckSum(String credential) {
		super(credential);
	}

	@Override
	public boolean isValid() {
		String patternStr = "^[0-9a-fA-F]{4,8}";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(credential);
		return matcher.matches();
	}

}
