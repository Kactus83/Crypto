package Crypto;

public abstract class AbstractCipher {
    
    public abstract String encrypt(String plaintext);
    public abstract String decrypt(String ciphertext);
}
