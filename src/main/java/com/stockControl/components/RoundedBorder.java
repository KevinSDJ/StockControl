package com.stockControl.components;

import javax.swing.border.AbstractBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

public class RoundedBorder extends AbstractBorder {

    @Override
    public void paintBorder(Component c, Graphics g,
            int x, int y,
            int width, int height) {
        Color oldColor = new Color(0,0,0,0);

        g.setColor(Color.black);
        g.drawRoundRect(x, y, width - 1, height - 1,
                20, 20);

        g.setColor(oldColor);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(4, 10, 4, 10);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.top = insets.right = insets.bottom = 4;
        return insets;
    }

}
