package mypack;

import javax.swing.*;
import java.awt.*;

/**
 * @author Jakub Jaskulski
 * @version 1.0
 * @since 29.10.18
 *
 *        Panel with Game itself.
 *
 */

public class GamePanel extends JPanel {


    ControlButtons controlButtons;
    GameButtons[][] gameButtons;
    GameEngine gameEngine;


    public GamePanel(ControlButtons controlButtons1, GameButtons[][] gameButtons1, GameEngine gameEngine1) {
        this.controlButtons = controlButtons1;
        this.gameButtons = gameButtons1;
        this.gameEngine = gameEngine1;
        init();
    }

    public void init() {

        GridBagLayout layout1 = new GridBagLayout();
        this.setLayout(layout1);

        this.setBackground(Color.WHITE);

    }
}
