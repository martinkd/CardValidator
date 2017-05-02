package credentials;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CvvCode extends BaseCredential {

	public CvvCode(String credential) {
		super(credential);
	}

	@Override
	public boolean isValid() {
		String patternStr = "^[0-9]{3,4}";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(credential);
		return matcher.matches();
	}

}
