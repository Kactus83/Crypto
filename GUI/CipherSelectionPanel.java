package GUI;

import Crypto.*;
import javax.swing.*;
import java.awt.*;

public class CipherSelectionPanel extends JPanel {
    private JComboBox<String> cipherSelector;
    private CipherOptionPanel currentOptionPanel;
    private JPanel optionsPanel;

    public CipherSelectionPanel() {
        setLayout(new BorderLayout());
        
        cipherSelector = new JComboBox<>(new String[]{"César"});
        optionsPanel = new JPanel();

        cipherSelector.addActionListener(e -> handleCipherSelection());

        add(cipherSelector, BorderLayout.NORTH);
        add(optionsPanel, BorderLayout.CENTER);

        handleCipherSelection();
    }

    public AbstractCipher getSelectedCipher() {
        String selectedCipher = (String) cipherSelector.getSelectedItem();
        if (selectedCipher.equals("César")) {
            int shiftValue = ((CaesarOptionPanel) currentOptionPanel).getShiftValue();
            AbstractCipherFactory factory = new CaesarCipherFactory(shiftValue);
            return factory.createCipher();
        }
        // Ajouter d'autres ciphers ici si nécessaire
        return null;
    }

    private void handleCipherSelection() {
        String selectedCipher = (String) cipherSelector.getSelectedItem();
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
