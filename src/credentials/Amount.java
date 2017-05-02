package credentials;

public class Amount extends BaseCredential {

	public Amount(String credential) {
		super(credential);
	}

	@Override
	public boolean isValid() {

		try {
			double amountDigit = Double.parseDouble(credential);
			return amountDigit > 0;
		} catch (NumberFormatException e) {
			return false;
		}

	}
}
