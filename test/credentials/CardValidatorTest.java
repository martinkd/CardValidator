package credentials;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import credentials.Amount;
import credentials.CardNumber;
import credentials.CheckSum;
import credentials.CvvCode;
import credentials.ExpirationDate;
import credentials.PromotionCode;
import credentials.TerminalID;

public class CardValidatorTest {

	@Test
	public void TerminalIDTest() {
		
		TerminalID termID = new TerminalID("00002859");
		assertTrue("should pass the test", termID.isValid());
		
		termID = new TerminalID("");
		assertFalse("should not let 0 chars", termID.isValid());
		
		termID = new TerminalID("a1");
		assertTrue("should pass less than 8 chars", termID.isValid());
		
		termID = new TerminalID("1234sad/");
		assertFalse("not alphanumeric chars", termID.isValid());
		
		termID = new TerminalID("00002859/");
		assertFalse("more than 8 characters", termID.isValid());
		
	}
	
	@Test
	public void CardNumberTest() {
		
		CardNumber cardNum = new CardNumber("012345678912");
		assertTrue("should pass 12 numbers", cardNum.isValid());
		
		cardNum = new CardNumber("012345678912345678");
		assertTrue("should pass 18 numbers", cardNum.isValid());
		
		cardNum = new CardNumber("01234567891");
		assertFalse("should not pass less than 12 numbers", cardNum.isValid());
		
		cardNum = new CardNumber("0123456789123456789");
		assertFalse("should not pass more than 18 numbers", cardNum.isValid());
		
		cardNum = new CardNumber("");
		assertFalse("should not pass more than 0 numbers", cardNum.isValid());

		cardNum = new CardNumber("asdfghjk123");
		assertFalse("should not pass other chars", cardNum.isValid());
	}
	
	@Test
	public void ExpirationDateTest() {
		
		ExpirationDate expDate = new ExpirationDate("0220");
		assertTrue("should pass valid date", expDate.isValid());
		
		expDate = new ExpirationDate("0512");
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
		
		cvv = new CvvCode("12345");
		assertFalse("should pass more than 4 digits", cvv.isValid());
		
		cvv = new CvvCode("asdf");
		assertFalse("should fail other chars", cvv.isValid());
	}
	
	@Test
	public void AmountTest() {
		
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
	public void PromotionCodeTest() {
		
		PromotionCode promoCode = new PromotionCode("0123456789as");
		assertTrue("should pass valid promo code", promoCode.isValid());
		
		promoCode = new PromotionCode("0123456789asd");
		assertFalse("should fail more than 12 alphanumeric chars", promoCode.isValid());
		
		promoCode = new PromotionCode("asdf,.asd");
		assertFalse("should fail other chars", promoCode.isValid());
	}
	
	@Test
	public void CheckSumTest() {
		
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
	}
	
}
