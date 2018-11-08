package mypack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SquareListener implements ActionListener {

    GameButtons gameButtons;

    public SquareListener(GameButtons gameButtons1) {
        this.gameButtons = gameButtons1;
    }

    public void actionPerformed(ActionEvent arg0) {

        /*gameButtons.changeGameButtonBull();

        if (gameButtons.gameButtonBool == true)
            gameButtons.gameButton.setBackground(Color.WHITE);
        else
            gameButtons.gameButton.setBackground(Color.BLACK);*/

        gameButtons.changeButAndBool();

    }

}
