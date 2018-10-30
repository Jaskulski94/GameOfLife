package mypack;

import javax.swing.*;
import java.awt.*;

/**
 * @author Jakub Jaskulski
 * @version 1.0
 * @since 29.10.18
 *
 *        Panel with title.
 *
 */

public class Title extends JPanel {

    private Scheme newScheme;

    public Title(Scheme scheme1) {
        this.newScheme = scheme1;
        init();
    }

    public void init() {

        Font customFontBig = newScheme.getCustomFont();
        customFontBig = customFontBig.deriveFont(94f);

        int panelWidth = newScheme.getFrameWidth();
        int panelHeight = newScheme.getFrameHeight();
        panelHeight /= 10;

        this.setSize(panelWidth, panelHeight);

        JLabel titleLabel = new JLabel("GAME OF LIFE", JLabel.CENTER);
        titleLabel.setFont(customFontBig);
        this.add(titleLabel);
        titleLabel.setForeground(Color.WHITE);
        this.setBackground(Color.BLACK);
    }
}
