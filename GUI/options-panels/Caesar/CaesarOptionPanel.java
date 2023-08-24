package GUI;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CaesarOptionPanel extends CipherOptionPanel {
    
    private JSlider shiftSlider;
    private JLabel valueLabel;

    public CaesarOptionPanel() {
        add(new JLabel("Décalage :"));
        
        shiftSlider = new JSlider(1, 25, 3); // valeurs min, max, et initiale
        valueLabel = new JLabel(String.valueOf(shiftSlider.getValue())); // Affiche la valeur initiale

        // Ajouter un ChangeListener au JSlider pour mettre à jour le JLabel
        shiftSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                valueLabel.setText(String.valueOf(shiftSlider.getValue()));
            }
        });

        add(shiftSlider);
        add(valueLabel);  // Ajouter le JLabel après le JSlider
    }

    public int getShiftValue() {
        return shiftSlider.getValue();
    }
}
