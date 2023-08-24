package Crypto;

public class CaesarCipher extends AbstractCipher {
    
    private int shift;

    public CaesarCipher(int shift) {
        this.shift = shift;
    }

    @Override
    public String encrypt(String plaintext) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            char ch = plaintext.charAt(i);

            if (Character.isLetter(ch)) {
                char offset = Character.isUpperCase(ch) ? 'A' : 'a';
                encryptedText.append((char) ((ch - offset + shift) % 26 + offset));
            } else {
                encryptedText.append(ch);
            }
        }

        return encryptedText.toString();
    }

    @Override
    public String decrypt(String ciphertext) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i++) {
            char ch = ciphertext.charAt(i);

            if (Character.isLetter(ch)) {
                char offset = Character.isUpperCase(ch) ? 'A' : 'a';
                decryptedText.append((char) ((ch - offset - shift + 26) % 26 + offset));
            } else {
                decryptedText.append(ch);
            }
        }

        return decryptedText.toString();
    }
}
