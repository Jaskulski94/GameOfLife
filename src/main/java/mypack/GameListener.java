package mypack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameListener implements ActionListener {

    GameButtons gameButtons;

    public GameListener(GameButtons gameButtons1) {
        this.gameButtons = gameButtons1;
    }

    public void actionPerformed(ActionEvent arg0) {

        gameButtons.changeButAndBool();

    }

}
