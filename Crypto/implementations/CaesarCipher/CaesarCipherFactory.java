package Crypto;

import GUI.CipherOptionPanel;
import GUI.CaesarOptionPanel;

public class CaesarCipherFactory extends AbstractCipherFactory {
    private int shift;

    public CaesarCipherFactory(int shift) {
        this.shift = shift;
    }
    
    @Override
    public AbstractCipher createCipher() {
        return new CaesarCipher(shift);
    }

    @Override
    public CipherOptionPanel createOptionPanel() {
        return new CaesarOptionPanel();
    }
}
