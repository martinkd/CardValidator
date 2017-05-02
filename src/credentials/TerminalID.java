package credentials;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TerminalID extends BaseCredential {

	public TerminalID(String credential) {
		super(credential);
	}

	@Override
	public boolean isValid() {
		String patternStr = "^[0-9a-zA-Z]{1,8}";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(credential);
		return matcher.matches();
	}

}
