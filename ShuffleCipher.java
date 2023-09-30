package FinalProject;

public class ShuffleCipher implements MessageEncoder, MessageDecoder{

	//field
	private int n;
	
	/**
	 * Default constructor for the class
	 * @param n takes in the shuffle value
	 */
	public ShuffleCipher(int n) {
		this.n = n;
	}
	
	/**
	 * This method encodes the string based on the shuffle value provided by the
	 * user. The method calls the messageEncoded method that is responsible for
	 * shuffling the String once. It then loops over to shuffle by the shuffle value.
	 * @param plainText takes in the String to be shuffled
	 * @return messageEncoded the encoded message
	 */
	@Override
	public String encode(String plainText) {
		String messageEncoded = plainText;
		int shuffle = n;
		for(int i = 0; i < shuffle; i++) {
			messageEncoded = shuffle(messageEncoded);
		}
		return messageEncoded;
	}
	/**
	 * This private method shuffles the text provided once. It divides the string in half,
	 * and takes every value alternatively by looping over every half. It then concatenates
	 * the text to a String variable.
	 * @param text takes in the string to be shuffled
	 * @return the shuffled string
	 */
	private String shuffle(String text) {
		String shuffledString = "";
		int mid = 0;
		if (text.length() % 2 == 0)
			mid = text.length() / 2;
		else {
			mid = (text.length() + 1) / 2;
		}
		String firstHalf = text.substring(0, mid);
		String secondHalf = text.substring(mid);
		for (int i = 0; i < firstHalf.length(); i++) {
			shuffledString += firstHalf.charAt(i);
			if (i < secondHalf.length()) {
				shuffledString += secondHalf.charAt(i);
			}
		}
		return shuffledString;
	}
	
	/**
	 * Decodes the string passed to the original text. This method calls the 
	 * originalString method that shuffles back the string one time and then 
	 * loops over to get the desired text.
	 * @param cipherText takes in the message to be decoded
	 * @return the decoded message
	 */
	@Override
	public String decode(String cipherText) {
		String decodedMessage = cipherText;
		int shuffle = n;
		for(int i = 0; i < shuffle; i++) {
			decodedMessage = originalString(decodedMessage);
		}
		return decodedMessage;
	}

	/**
	 * This private method takes in a message and reverse shuffles it once.
	 * it adds the character alternatively to variables that are then 
	 * concatenated
	 * @param text the message to be decoded
	 * @return the reverse shuffled string
	 */
	private String originalString(String text) {
		String firstHalf = "";
		String secondHalf = ""; 
		for(int i = 0; i < text.length(); i++) {
			if(i % 2 == 0)
				firstHalf += text.charAt(i);
			else
				secondHalf += text.charAt(i);
		}
		return firstHalf + secondHalf;
	}

}
