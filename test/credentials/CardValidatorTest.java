package credentials;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CardValidatorTest {

	@Test
	public void terminalIDTest() {
		
		TerminalID termID = new TerminalID("00002859");
		assertTrue("should pass valid terminal ID", termID.isValid());
		
		termID = new TerminalID("");
		assertFalse("should fail 0 chars", termID.isValid());
		
		termID = new TerminalID("a1");
		assertTrue("should pass less than 8 alphanumeric chars", termID.isValid());
		
		termID = new TerminalID("00as2859a");
		assertFalse("should fail more than 8 alphanumeric chars", termID.isValid());
		
		termID = new TerminalID("1234sad/");
		assertFalse("should fail not alphanumeric chars", termID.isValid());
	}
	
	@Test
	public void cardNumberTest() {
		
		CardNumber cardNum = new CardNumber("012345678912");
		assertTrue("should pass 12 numbers", cardNum.isValid());
		
		cardNum = new CardNumber("012345678912345678");
		assertTrue("should pass 18 numbers", cardNum.isValid());
		
		cardNum = new CardNumber("01234567891");
		assertFalse("should fail less than 12 numbers", cardNum.isValid());
		
		cardNum = new CardNumber("0123456789123456789");
		assertFalse("should fail more than 18 numbers", cardNum.isValid());
		
		cardNum = new CardNumber("");
		assertFalse("should fail 0 numbers", cardNum.isValid());

		cardNum = new CardNumber("asdfghjk123");
		assertFalse("should fail other chars than digits", cardNum.isValid());
	}
	
	@Test
	public void expirationDateTest() {
		
		ExpirationDate expDate = new ExpirationDate("0220");
		assertTrue("should pass valid date", expDate.isValid());
		
		// current date for this test is 05.02.2017
		expDate = new ExpirationDate("0517");
		assertTrue("should pass last month of the current year", expDate.isValid());
		
		// current date for this test is 28.04.2017
		expDate = new ExpirationDate("0317");
		assertFalse("should fail expired month of the current year", expDate.isValid());
		
		expDate = new ExpirationDate("0412");
		assertFalse("should fail expired date", expDate.isValid());
		
		expDate = new ExpirationDate("220");
		assertFalse("should fail less than 4 digits", expDate.isValid());
		
		expDate = new ExpirationDate("022018");
		assertFalse("should fail more than 4 digits", expDate.isValid());
		
		expDate = new ExpirationDate("asdf");
		assertFalse("should fail other than digits chars", expDate.isValid());
		
		expDate = new ExpirationDate("");
		assertFalse("should fail less than 0 digits", expDate.isValid());
		
		expDate = new ExpirationDate("1320");
		assertFalse("should fail fake month", expDate.isValid());
		
		expDate = new ExpirationDate("0020");
		assertFalse("should fail fake month", expDate.isValid());

	}
	
	@Test
	public void cvvCodeTest() {
		
		CvvCode cvv = new CvvCode("358");
		assertTrue("should pass 3 digits", cvv.isValid());
		
		cvv = new CvvCode("3581");
		assertTrue("should pass 4 digits", cvv.isValid());
		
		cvv = new CvvCode("");
		assertFalse("should fail 0 digits", cvv.isValid());
		
		cvv = new CvvCode("12345");
		assertFalse("should fail more than 4 digits", cvv.isValid());
		
		cvv = new CvvCode("12");
		assertFalse("should fail less than 3 digits", cvv.isValid());
		
		cvv = new CvvCode("asdf");
		assertFalse("should fail other chars", cvv.isValid());
		
		cvv = new CvvCode("12df");
		assertFalse("should fail other chars", cvv.isValid());
	}
	
	@Test
	public void amountTest() {
		
		Amount amount = new Amount("123.58");
		assertTrue("should pass valid amount", amount.isValid());
		
		amount = new Amount("0");
		assertFalse("should fail 0 amount", amount.isValid());
		
		amount = new Amount("-123");
		assertFalse("should fail negative amount", amount.isValid());
		
		amount = new Amount("asd");
		assertFalse("should fail other chars", amount.isValid());
	}
	
	@Test
	public void promotionCodeTest() {
		
		PromotionCode promoCode = new PromotionCode("0123456789as");
		assertTrue("should pass valid promo code", promoCode.isValid());
		
		promoCode = new PromotionCode("0123asd");
		assertTrue("should pass with up to 12 alphanumeric chars", promoCode.isValid());
		
		promoCode = new PromotionCode("0123456789asd");
		assertFalse("should fail more than 12 alphanumeric chars", promoCode.isValid());
		
		promoCode = new PromotionCode("asdf,.asd");
		assertFalse("should fail other chars", promoCode.isValid());
		
		promoCode = new PromotionCode("");
		assertFalse("should fail empty promo code", promoCode.isValid());
	}
	
	@Test
	public void checkSumTest() {
		
		CheckSum checkSum = new CheckSum("123a");
		assertTrue("should pass valid checksum", checkSum.isValid());
		
		checkSum = new CheckSum("1234aBCd");
		assertTrue("should pass valid checksum", checkSum.isValid());
		
		checkSum = new CheckSum("123");
		assertFalse("should fail less than 4 hex", checkSum.isValid());
		
		checkSum = new CheckSum("12345678a");
		assertFalse("should fail more than than 8 hex", checkSum.isValid());
		
		checkSum = new CheckSum("123alN");
		assertFalse("should fail not hex digits", checkSum.isValid());
		
		checkSum = new CheckSum("");
		assertFalse("should fail with empty checksum", checkSum.isValid());
	}
	
}
