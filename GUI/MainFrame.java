package GUI;

import javax.swing.*;
import Crypto.*;

public class MainFrame extends JFrame {

    private JTextArea inputTextArea;
    private JComboBox<String> cipherSelector;
    private JButton encryptButton;
    private JButton decryptButton;

    public MainFrame() {
        setTitle("Chiffrement");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        inputTextArea = new JTextArea();
        inputTextArea.setBounds(10, 10, 470, 150);
        add(inputTextArea);

        cipherSelector = new JComboBox<>(new String[]{"César", "XOR"}); // Autres méthodes ici
        cipherSelector.setBounds(10, 170, 100, 25);
        add(cipherSelector);

        encryptButton = new JButton("Chiffrer");
        encryptButton.setBounds(120, 170, 100, 25);
        encryptButton.addActionListener(e -> encryptData());
        add(encryptButton);

        decryptButton = new JButton("Déchiffrer");
        decryptButton.setBounds(230, 170, 100, 25);
        decryptButton.addActionListener(e -> decryptData());
        add(decryptButton);
    }

    private void encryptData() {
        String plaintext = inputTextArea.getText();
        AbstractCipher cipher;

        switch (cipherSelector.getSelectedItem().toString()) {
            case "César":
                cipher = new CaesarCipher(3); 
                inputTextArea.setText(cipher.encrypt(plaintext));
                break;
            case "XOR":
                // Implementer le XOR ici 
                break;
            // Autres cas pour d'autres algorithmes
        }
    }

    private void decryptData() {
        String ciphertext = inputTextArea.getText();
        AbstractCipher cipher;

        switch (cipherSelector.getSelectedItem().toString()) {
            case "César":
                cipher = new CaesarCipher(3); 
                inputTextArea.setText(cipher.decrypt(ciphertext));
                break;
            case "XOR":
                // Implementer le XOR ici 
                break;
            // Autres cas pour d'autres algorithmes
        }
    }
}

