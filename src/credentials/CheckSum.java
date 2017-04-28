package credentials;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckSum implements BaseCredential{

	private String checkSum;
	
	public CheckSum(String checkSum) {
		this.checkSum = checkSum;
	}
	
	@Override
	public boolean isValid() {
		String patternStr = "^[0-9a-fA-F]{4,8}";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(checkSum);
		return matcher.matches();
	}

}
