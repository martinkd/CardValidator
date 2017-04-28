package cards;

import credentials.Amount;
import credentials.CardNumber;
import credentials.CvvCode;
import credentials.ExpirationDate;
import credentials.PromotionCode;
import credentials.TerminalID;

public class RegularCard extends BaseCard{
	
	private static final int REGULAR_CARD_WITH_PROM_CODE_LENGTH = 6;

	private CardNumber cardNum;
	private ExpirationDate expDate;
	private CvvCode cvv;

	public RegularCard(String [] credentials) {
		
		terminalID = new TerminalID(credentials[0]);
		cardNum = new CardNumber(credentials[1]);
		expDate = new ExpirationDate(credentials[2]);
		cvv = new CvvCode(credentials[3]);
		amount = new Amount(credentials[4]);
		
		if (credentials.length == REGULAR_CARD_WITH_PROM_CODE_LENGTH) {
			promoCode = new PromotionCode(credentials[5]);
			hasPromoCode = true;
		}
		
	}

	@Override
	public void validate() {
		
		if (!terminalID.isValid()) {
			System.out.println("Terminal ID not valid");
		}
		
		if (!cardNum.isValid()) {
			System.out.println("Card Number not valid");
		}
		
		if (!expDate.isValid()) {
			System.out.println("Expiration date not valid");
		}
		
		if (!cvv.isValid()) {
			System.out.println("CVV code not valid");
		}
		
		if (!amount.isValid()) {
			System.out.println("Amount not valid");
		}
		
		if (hasPromoCode && !promoCode.isValid()) {
			System.out.println("Promotion code not valid");
		}
	}
	
}
