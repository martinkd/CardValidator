package credentials;

public class Track2 extends BaseCredential {

	private CardNumber cardNum;
	private ExpirationDate expDate;
	private CheckSum checkSum;

	private static final int EXP_DATE_AND_CHECK_SUM_MIN_LENTH = 8;

	public Track2(String credential) {
		super(credential);
	}

	private boolean splitTrack2() {

		String[] track2Split = credential.split("=");

		cardNum = new CardNumber(track2Split[0]);
		String expDateAndCheckSum = track2Split[1];

		if (expDateAndCheckSum.length() >= EXP_DATE_AND_CHECK_SUM_MIN_LENTH) {
			expDate = new ExpirationDate(expDateAndCheckSum.substring(0, 4));
			checkSum = new CheckSum(expDateAndCheckSum.substring(4));
			return true;
		}
		return false;

	}

	@Override
	public boolean isValid() {
		return splitTrack2() && cardNum.isValid() && expDate.isValid() && checkSum.isValid();
	}
}
