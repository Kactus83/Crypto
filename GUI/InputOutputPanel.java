package GUI;

import Crypto.*;
import javax.swing.*;
import java.awt.*;

public class InputOutputPanel extends JPanel {
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;
    private JButton encryptButton;
    private JButton decryptButton;
    private CipherSelectionPanel cipherSelectionPanel;

    public InputOutputPanel(CipherSelectionPanel cipherSelectionPanel) {
        this.cipherSelectionPanel = cipherSelectionPanel;

        setLayout(new BorderLayout());
        
        inputTextArea = new JTextArea(10, 40);
        outputTextArea = new JTextArea(10, 40);
        encryptButton = new JButton("Crypter");
        decryptButton = new JButton("Décrypter");

        encryptButton.addActionListener(e -> encryptData());
        decryptButton.addActionListener(e -> decryptData());

        add(inputTextArea, BorderLayout.NORTH);
        add(outputTextArea, BorderLayout.SOUTH);
        add(encryptButton, BorderLayout.WEST);
        add(decryptButton, BorderLayout.EAST);
    }

    private void encryptData() {
        String inputText = inputTextArea.getText();
        AbstractCipher cipher = cipherSelectionPanel.getSelectedCipher();
        String encryptedText = cipher.encrypt(inputText);
        outputTextArea.setText(encryptedText);
    }

    private void decryptData() {
        String encryptedText = outputTextArea.getText();
        AbstractCipher cipher = cipherSelectionPanel.getSelectedCipher();
        String decryptedText = cipher.decrypt(encryptedText);
        inputTextArea.setText(decryptedText);
    }
}
