package credentials;

import java.util.Calendar;
import java.util.Date;

public class ExpirationDate extends BaseCredential {

	private static final int EXP_DATE_LENGTH = 4;

	public ExpirationDate(String credential) {
		super(credential);
	}

	@Override
	public boolean isValid() {

		if (credential.length() != EXP_DATE_LENGTH) {
			return false;
		}

		try {

			int date = Integer.parseInt(credential);

			if (!isValidYear(date)) {
				return false;
			}
			if (!isValidMonth(date)) {
				return false;
			}

		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	private boolean isValidYear(int date) {
		int year = date % 100;
		int currentYear = getCurrentYear();
		return year >= 0 && year <= 99 && year >= currentYear;
	}

	// return last two digits of the current year
	private int getCurrentYear() {
		return Calendar.getInstance().get(Calendar.YEAR) % 100;
	}

	private boolean isValidMonth(int date) {

		int expMonth = date / 100;

		if (expMonth < 1 || expMonth > 12) {

			return false;

		} else {

			int expYear = date % 100;
			int currentMonth = getCurrentMonth();

			if (expYear == getCurrentYear()) {
				return expMonth >= currentMonth;
			}

		}

		return true;

	}

	// return current month between 1 and 12;
	private int getCurrentMonth() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH) + 1;
	}

}
