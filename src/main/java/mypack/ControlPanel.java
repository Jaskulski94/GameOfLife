package mypack;

import javax.swing.*;
import java.awt.*;

import java.util.List;

/**
 * @author Jakub Jaskulski
 * @version 1.0
 * @since 29.10.18
 *
 *        Panel with buttons.
 *
 */

public class ControlPanel extends JPanel {

    private Scheme newScheme;

    public List<ControlButtons> controlButtons;

    public ControlPanel(Scheme scheme1, List<ControlButtons> controlButtons1) {
        this.newScheme = scheme1;
        this.controlButtons = controlButtons1;

        init();
        }

    public void init() {

        Font customFont = newScheme.getCustomFont();
        customFont = customFont.deriveFont(24f);

        this.setLayout(new FlowLayout());
        this.setBackground(Color.BLACK);

        int panelHeight = newScheme.getFrameHeight();
        panelHeight *= 0.2;

        for (ControlButtons button : controlButtons) {
            button.addButton(panelHeight, customFont, this);
        }
    }
}
