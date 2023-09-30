package FinalProject;

public interface MessageEncoder {
    /**
     * The method that encodes text
     * @param plainText the text to encode
     * @return the encoded text
     */
    public abstract String encode(String plainText);
}
