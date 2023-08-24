package Crypto;

public class CaesarCipher extends AbstractCipher {

    private int shift;

    public CaesarCipher(int shift) {
        this.shift = shift;
    }

    @Override
    public String encrypt(String data) {
        return shiftString(data, shift);
    }

    @Override
    public String decrypt(String data) {
        return shiftString(data, -shift);
    }

    private String shiftString(String data, int shiftValue) {
        StringBuilder result = new StringBuilder();

        for (char character : data.toCharArray()) {
            if (character >= 'A' && character <= 'Z') {
                result.append((char) ('A' + (character - 'A' + shiftValue + 26) % 26));
            } else if (character >= 'a' && character <= 'z') {
                result.append((char) ('a' + (character - 'a' + shiftValue + 26) % 26));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }
}
