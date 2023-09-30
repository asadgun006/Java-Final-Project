package FinalProject;

public interface MessageDecoder {
    /**
     * This method will decode the cypher text
     * @param cipherText the encoded message
     * @return the decoded text
     */
    public abstract String decode(String cipherText);
}
