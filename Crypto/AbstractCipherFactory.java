package Crypto;

import GUI.CipherOptionPanel;

public abstract class AbstractCipherFactory {
    
    public abstract AbstractCipher createCipher();
    public abstract CipherOptionPanel createOptionPanel();
}
