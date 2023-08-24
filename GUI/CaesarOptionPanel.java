package GUI;

import javax.swing.JLabel;
import javax.swing.JSlider;

public class CaesarOptionPanel extends CipherOptionPanel {
    
    private JSlider shiftSlider;

    public CaesarOptionPanel() {
        add(new JLabel("Décalage :"));
        
        shiftSlider = new JSlider(1, 25, 3); // valeurs min, max, et initiale
        add(shiftSlider);
    }

    public int getShiftValue() {
        return shiftSlider.getValue();
    }
}
