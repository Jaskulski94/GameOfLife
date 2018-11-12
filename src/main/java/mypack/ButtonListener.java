package mypack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    ControlButtons controlButtons;

    public ButtonListener(ControlButtons controlButtons1) {
        this.controlButtons = controlButtons1;
    }

    public void actionPerformed(ActionEvent arg0) {

        controlButtons.changeButtonAndBool();

    }

}
