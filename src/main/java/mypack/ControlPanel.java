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
    private ControlButtonsEnum controlButtonsEnum;
    public List<ControlButtons> controlButtons;

    private void initializeControlButtons(){
        for (ControlButtonsEnum enum1 : controlButtonsEnum.values()){
            controlButtons.add(new ControlButtons());
            controlButtons.get(controlButtons.size() - 1).setFalseAndTrueText(enum1.getFalseText(), enum1.name());
            controlButtons.get(controlButtons.size() - 1).setButtonBool(false);
            if(enum1.getNonSwitchBool()){
                controlButtons.get(controlButtons.size() - 1).setNonSwitchButtonBool(true);
            } else {
                controlButtons.get(controlButtons.size() - 1).setNonSwitchButtonBool(false);
            }
        }
    }

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

        initializeControlButtons();

        for (ControlButtons button : controlButtons) {
            button.addButton(panelHeight, customFont, this);
        }
    }
}
