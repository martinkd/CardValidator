package validator;

import java.util.Arrays;
import java.util.Scanner;

import cards.BaseCard;
import cards.RegularCard;
import cards.Track2Card;

public class CardValidator {

	private static final int MIN_CREDENTIALS = 3;
	
	private BaseCard card;
	
	public static void main(String[] args) {
		
		String cardInfo = CardValidator.readInput();
		CardValidator cv = new CardValidator();
		cv.validate(cardInfo);
	}
	
	public static String readInput() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter card information:");
		String cardInfo = input.nextLine();
		input.close();
		return cardInfo;
	}

	public void validate(String cardInfo) {
		
		if(setCredentials(cardInfo)) {
			card.validate();
		}
		
	}

	private boolean setCredentials(String cardInfo) {

		String[] credentials = cardInfo.split("~");
		
		if (credentials.length < MIN_CREDENTIALS) {
			System.out.println("Not enough credentials");
			return false;
		}

		if (isRegularCard(credentials[1])) {
			
			card =  new RegularCard(credentials);
			
		} else {
			
			card = new Track2Card(credentials);
			
		}

		return true;
	}

	private boolean isRegularCard(String secondCredential) {
		char[] cardNumArray = secondCredential.toCharArray();
		for (char c : cardNumArray) {
			if (c == '=') {
				return false;
			}
		}
		return true;
	}
}
