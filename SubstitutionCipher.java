package FinalProject;

public class SubstitutionCipher implements MessageEncoder, MessageDecoder{

	//field
	private int shift;
	
	/**
	 * Default constructor for the class
	 * @param shift takes in the shift value for the String
	 */
	public SubstitutionCipher(int shift) {
		this.shift = shift;
	}
	
	/**
	 * This method is responsible for encoding the passed String based on the
	 * shift value. It shifts the letter by the shift value provided.
	 * @param plainText takes in the String for encoding
	 * @return text which is the encoded String
	 */
	@Override
	public String encode(String plainText) { 
		String text = "";
		String text2 = "";
		int count = shift;
		char ch;
		for (int i = count; i < plainText.length(); i++) {
			ch = plainText.charAt(i);
			text += ch;
		}
		for (int j = 0; j < count; j++) {
			ch = plainText.charAt(j);
			text2 += ch;
		}
		text += text2;
		return text;
	}

	/**
	 * This class is responsible for decoding the text to its original string.
	 * It does so by getting strings that are from either side of the shift
	 * value and concatenates to a string variable.
	 * @param cipherText takes in the already encoded String
	 * @return text this is the String decoded by the method
	 */
	@Override
	public String decode(String cipherText) {
		String text = "";
		String text2 = "";
		int count = shift;
		char ch;
		for(int i = (cipherText.length() - count); i < cipherText.length(); i++) {
			ch = cipherText.charAt(i);
			text += ch;
		}
		for (int j = 0; j < (cipherText.length() - count); j++) {
			ch = cipherText.charAt(j);
			text2 += ch;
		}
		text += text2;
		return text;
	}
	

	

}
