package credentials;

public abstract class BaseCredential {

	String credential;
	
	public BaseCredential(String credential) {
		this.credential = credential;
	}
	
	abstract boolean isValid();
	
}
