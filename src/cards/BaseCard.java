package cards;

import credentials.Amount;
import credentials.PromotionCode;
import credentials.TerminalID;

public abstract class BaseCard {

	TerminalID terminalID;
	Amount amount;
	PromotionCode promoCode;
	boolean hasPromoCode;

	public abstract void validate();
}
