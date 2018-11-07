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

public class TitlePanel extends JPanel {

    private Scheme newScheme;

    public void printWord(String word, Font customFont){
        JLabel titleLabel = new JLabel(word, JLabel.CENTER);
        titleLabel.setFont(customFont);
        titleLabel.setForeground(Color.WHITE);
        this.add(titleLabel);
    }

    public TitlePanel(Scheme scheme1) {
        this.newScheme = scheme1;
        init();
    }

    public void init() {

        Font customFontBig = newScheme.getCustomFont();
        customFontBig = customFontBig.deriveFont(94f);

        int panelWidth = newScheme.getFrameWidth();
        int panelHeight = newScheme.getFrameHeight();
        panelHeight /= 12;
        Dimension dim = new Dimension(panelWidth, panelHeight);

        this.setMinimumSize(dim);

        printWord("GAME ", customFontBig);
        printWord("OF ", customFontBig);
        printWord("LIFE ", customFontBig);

        this.setBackground(Color.BLACK);

    }
}
