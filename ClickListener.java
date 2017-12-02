
package clicker.ui;

import clicker.applicationlogic.Calculator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ClickListener implements ActionListener {

    private Calculator calc;
    private JLabel textField;
    
    public ClickListener(Calculator calc, JLabel textField) {
        this.calc = calc;
        this.textField = textField;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.calc.increase();
        this.textField.setText("" + this.calc.giveValue());
    }
    
}
