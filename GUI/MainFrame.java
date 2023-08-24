package GUI;

import Crypto.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {

    private JTextArea inputTextArea;
    private JTextArea outputTextArea;
    private JButton encryptButton;
    private JButton decryptButton;
    private JComboBox<String> cipherSelector;
    private CipherOptionPanel currentOptionPanel;
    private JPanel optionsPanel;
    private JPanel centerPanel;

    public MainFrame() {
        setTitle("Cryptographie");
        setSize(800, 600);
        setLayout(new BorderLayout());

        inputTextArea = new JTextArea(10, 40);
        outputTextArea = new JTextArea(10, 40);
        encryptButton = new JButton("Crypter");
        decryptButton = new JButton("Décrypter");
        cipherSelector = new JComboBox<>(new String[]{"César"});
        optionsPanel = new JPanel();
        centerPanel = new JPanel(new BorderLayout());

        // Gestion des événements des boutons
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encryptData();
            }
        });

        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decryptData();
            }
        });

        cipherSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCipherSelection();
            }
        });

        add(inputTextArea, BorderLayout.NORTH);
        add(outputTextArea, BorderLayout.SOUTH);
        add(encryptButton, BorderLayout.WEST);
        add(decryptButton, BorderLayout.EAST);

        centerPanel.add(cipherSelector, BorderLayout.NORTH);
        centerPanel.add(optionsPanel, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);
        
        handleCipherSelection();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void encryptData() {
        String inputText = inputTextArea.getText();
        int shiftValue = ((CaesarOptionPanel) currentOptionPanel).getShiftValue();
        AbstractCipherFactory factory = new CaesarCipherFactory(shiftValue);
        AbstractCipher cipher = factory.createCipher();
        String encryptedText = cipher.encrypt(inputText);
        outputTextArea.setText(encryptedText);
    }

    private void decryptData() {
        String encryptedText = outputTextArea.getText();
        int shiftValue = ((CaesarOptionPanel) currentOptionPanel).getShiftValue();
        AbstractCipherFactory factory = new CaesarCipherFactory(shiftValue);
        AbstractCipher cipher = factory.createCipher();
        String decryptedText = cipher.decrypt(encryptedText);
        inputTextArea.setText(decryptedText);
    }

    private void handleCipherSelection() {
        String selectedCipher = (String) cipherSelector.getSelectedItem();
        
        // Reset options panel
        optionsPanel.removeAll();

        if (selectedCipher.equals("César")) {
            currentOptionPanel = new CaesarCipherFactory(3).createOptionPanel();
            optionsPanel.add(currentOptionPanel);
        }
        // Vous pouvez ajouter plus de chiffrements ici...

        optionsPanel.revalidate();
        optionsPanel.repaint();
    }
}
