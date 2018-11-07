package mypack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    ControlButtons controlButtons;

    public void changeButtonAndBool (String currentText1, String name1, String name2, ControlButtons controlButtons1){
        if (currentText1 == name1){
            controlButtons1.setButtonText(name2);
            controlButtons1.setBool(true);
        } else if (currentText1 == name2){
            controlButtons1.setButtonText(name1);
            controlButtons1.setBool(false);
        }
    }

    public void setTrueButtonAndBool (String currentText1, String name1, ControlButtons controlButtons1){
        if (currentText1 == name1){
            controlButtons1.setBool(true);
        }
    }

    public ButtonListener(ControlButtons controlButtons1) {
        this.controlButtons = controlButtons1;
    }

    public void actionPerformed(ActionEvent arg0) {

        String currentText = controlButtons.controlBut.getText();

        System.out.println(currentText);
        System.out.println(controlButtons.buttonBool);

        changeButtonAndBool(currentText,"STOP", "START", controlButtons);
        changeButtonAndBool(currentText,"SLOW", "FAST", controlButtons);
        changeButtonAndBool(currentText,"NEAR", "FAR", controlButtons);

        setTrueButtonAndBool(currentText, "CLEAR", controlButtons);
        setTrueButtonAndBool(currentText, "EXIT", controlButtons);

        currentText = controlButtons.controlBut.getText();
        System.out.println(currentText);
        System.out.println(controlButtons.buttonBool);

    }

}
