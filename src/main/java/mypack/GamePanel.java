package mypack;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Jakub Jaskulski
 * @version 1.0
 * @since 29.10.18
 *
 *        Panel with Game itself.
 *
 */

public class GamePanel extends JPanel {


    List<ControlButtons> controlButtons;
    List<List<GameButtons>> gameButtons;
    GameEngine gameEngine;


    public GamePanel(List<ControlButtons> controlButtons1, List<List<GameButtons>> gameButtons1, GameEngine gameEngine1) {
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
