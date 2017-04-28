package credentials;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CvvCode implements BaseCredential{
	
	private String cvv;
	
	public CvvCode(String cvv) {
		this.cvv = cvv;
	}

	@Override
	public boolean isValid() {
		String patternStr = "^[0-9]{3,4}";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(cvv);
		return matcher.matches();
	}
	
}
