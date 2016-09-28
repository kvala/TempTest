package test;

public class TelphoneNumber {

	static final int PHONE_NUMBER_LENGTH = 7;

	public static void main(String[] args) {

	}

	public static void printTelephoneWords(int[] phoneNum) {
		char[] result = new char[PHONE_NUMBER_LENGTH];
		doPrintTelephoneWords(phoneNum, 0, result);
	}

	public static void doPrintTelephoneWords(int[] phoneNum, int curDigit, char[] result) {
		if (curDigit == PHONE_NUMBER_LENGTH) {
			System.out.println(new String(result));
			return;
		}

		for (int i = 1; i <= 3; i++) {
			result[curDigit] = getCharKey(phoneNum[curDigit], i);
			doPrintTelephoneWords(phoneNum, curDigit + 1, result);
			if (phoneNum[curDigit] == 0 || phoneNum[curDigit] == 1)
				return;
		}
	}

	public static char getCharKey(int telephoneKey, int place) {
		return 'a';
	}

	public static void printTelephoneWords2(int[] phoneNum) {
		char[] result = new char[PHONE_NUMBER_LENGTH];
		int i;

		for (i = 0; i < PHONE_NUMBER_LENGTH; ++i) {
			result[i] = getCharKey(phoneNum[i], 1);
		}

		System.out.println();

		for (i = PHONE_NUMBER_LENGTH - 1; i >= -1; i--) {
			if (i == -1) {
				return;
			}

			if (getCharKey(phoneNum[i], 3) == result[i] || phoneNum[i] == 0 || phoneNum[i] == 1) {
				result[i] = getCharKey(phoneNum[i], 1);
			} else if (getCharKey(phoneNum[i], 1) == result[i]) {
				result[i] = getCharKey(phoneNum[i], 2);
				break;
			} else if (getCharKey(phoneNum[i], 2) == result[i]) {
				result[i] = getCharKey(phoneNum[i], 3);
				break;
			}
		}

	}
}
