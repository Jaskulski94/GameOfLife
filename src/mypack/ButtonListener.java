package mypack;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    Game gamePanel;
    boolean bool1;
    JButton but;

    public ButtonListener(Game game1, boolean bool1, JButton but1) {
        this.gamePanel = game1;
        this.bool1 = bool1;
        this.but = but1;
    }

    public void actionPerformed(ActionEvent arg0) {

        bool1 ^= true;

        String currentText = but.getText();

        if (currentText.equals("START"))
            but.setText("STOP");
        else if (currentText.equals("STOP"))
            but.setText("START");
        else if (currentText.equals("SLOW"))
            but.setText("FAST");
        else if (currentText.equals("FAST"))
            but.setText("SLOW");
        else if (currentText.equals("NEAR"))
            but.setText("FAR");
        else if (currentText.equals("FAR"))
            but.setText("NEAR");
    }

}
