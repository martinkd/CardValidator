package credentials;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TerminalID implements BaseCredential{

	private String terminalID;
	
	public TerminalID(String terminalID) {
		this.terminalID = terminalID;
	}
	
	@Override
	public boolean isValid() {
		String patternStr = "^[0-9a-zA-Z]{1,8}";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(terminalID);
		return matcher.matches();
	}
	
}
