package clicker.ui;

import clicker.applicationlogic.Calculator;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    private Calculator calc;
    
    public UserInterface(Calculator calc) {
        this.calc = calc;
    }

    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);
        
        JLabel countField = new JLabel("" + this.calc.giveValue());
        JButton clickButton = new JButton("Click!");
        
        ClickListener listener = new ClickListener(this.calc, countField);
        clickButton.addActionListener(listener);
        
        container.add(countField, BorderLayout.WEST);
        container.add(clickButton, BorderLayout.SOUTH);
    }

    public JFrame getFrame() {
        return frame;
    }
}
