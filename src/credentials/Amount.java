package credentials;

public class Amount implements BaseCredential{
	
	private String amount;
	
	public Amount(String amount) {
		this.amount = amount;
	}

	@Override
	public boolean isValid() {
		
		try {
			double amountDigit = Double.parseDouble(amount);
			return amountDigit > 0;
		} catch (NumberFormatException e) {
			return false;
		}
		
	}
}
