package mypack;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    Game gamePanel;
    boolean bool;
    JButton but;

    public void changeButtonAndBool (String currentText1, String name1, String name2, JButton but1, boolean bool1){
        if (currentText1 == name1){
            but1.setText(name2);
            bool1 = true;
        } else if (currentText1 == name2){
            but1.setText(name1);
            bool1 = false;
        }

    }

    public ButtonListener(Game game1, boolean bool1, JButton but1) {
        this.gamePanel = game1;
        this.bool = bool1;
        this.but = but1;
    }

    public void actionPerformed(ActionEvent arg0) {

/*        String currentText = but.getText();

        changeButtonAndBool(currentText,"STOP", "START", but, bool);
        changeButtonAndBool(currentText,"SLOW", "FAST", but, bool);
        changeButtonAndBool(currentText,"NEAR", "FAR", but, bool);

        if (currentText.equals("CLEAR")) {
            gamePanel.setClearBool(true);
        }*/


        String currentText = but.getText();

        if (currentText.equals("START")) {
            but.setText("STOP");
            gamePanel.setStartBool(true);
        } else if (currentText.equals("STOP")) {
            but.setText("START");
            gamePanel.setStartBool(false);
        }

        if (currentText.equals("SLOW")) {
            but.setText("FAST");
            gamePanel.setSlowBool(true);
        } else if (currentText.equals("FAST")) {
            but.setText("SLOW");
            gamePanel.setSlowBool(false);
        }

        if (currentText.equals("NEAR")) {
            but.setText("FAR");
            gamePanel.setNearBool(true);
        } else if (currentText.equals("FAR")) {
            but.setText("NEAR");
            gamePanel.setNearBool(false);
        }

        if (currentText.equals("CLEAR")) {
            gamePanel.setClearBool(true);
        }

    //    System.out.println(but.getText());
    //    System.out.println(String.valueOf(bool1));

    }

}
