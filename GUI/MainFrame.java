package GUI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private InputOutputPanel inputOutputPanel;
    private CipherSelectionPanel cipherSelectionPanel;

    public MainFrame() {
        setTitle("Cryptographie");
        setSize(800, 600);
        setLayout(new BorderLayout());

        cipherSelectionPanel = new CipherSelectionPanel();
        inputOutputPanel = new InputOutputPanel(cipherSelectionPanel);

        add(inputOutputPanel, BorderLayout.CENTER);
        add(cipherSelectionPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
