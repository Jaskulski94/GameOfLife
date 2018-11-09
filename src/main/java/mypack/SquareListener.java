package mypack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SquareListener implements ActionListener {

    GameButtons gameButtons;

    public SquareListener(GameButtons gameButtons1) {
        this.gameButtons = gameButtons1;
    }

    public void actionPerformed(ActionEvent arg0) {

        gameButtons.changeButAndBool();

    }

}
