package com.stockControl.components;

import javax.swing.JTextField;
import java.awt.Graphics;

public class RoundedTextField extends JTextField {

    public RoundedTextField() {
        super();
        setOpaque(false);
        setBorder(new RoundedBorder());
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1,
                20, 20);
        super.paintComponent(g);
    }
}
