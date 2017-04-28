package cards;

import credentials.Amount;
import credentials.PromotionCode;
import credentials.TerminalID;
import credentials.Track2;

public class Track2Card extends BaseCard {

	private static final int TRACK2_CARD_WITH_PROM_CODE_LENGTH = 4;

	private Track2 track2;

	public Track2Card(String[] credentials) {
	
		terminalID = new TerminalID(credentials[0]);
		track2 = new Track2(credentials[1]);
		amount = new Amount(credentials[2]);

		if (credentials.length == TRACK2_CARD_WITH_PROM_CODE_LENGTH) {
			promoCode = new PromotionCode(credentials[3]);
			hasPromoCode = true;
		}

	}

	@Override
	public void validate() {
		
		if (!terminalID.isValid()) {
			System.out.println("Terminal ID not valid");
		}
		
		if (!track2.isValid()) {
			System.out.println("Track2 not valid");
		}
		
		if (!amount.isValid()) {
			System.out.println("Amount not valid");
		}
		
		if (hasPromoCode && !promoCode.isValid()) {
			System.out.println("Promotion code not valid");
		}
		
	}
}
