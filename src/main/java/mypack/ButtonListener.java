package mypack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    ControlButtons controlButtons;
    int index;

    public void changeButtonAndBool (int index1, String currentText1, String name1, String name2, ControlButtons controlButtons1){
        if (currentText1 == name1){
            controlButtons1.setButtonText(index, name2);
            controlButtons1.setBool(index, true);
        } else if (currentText1 == name2){
            controlButtons1.setButtonText(index, name1);
            controlButtons1.setBool(index, false);
        }
    }

    public void setTrueButtonAndBool (int index, String currentText1, String name1, ControlButtons controlButtons1){
        if (currentText1 == name1){
            controlButtons1.setBool(index, true);
        }
    }

    public ButtonListener(ControlButtons controlButtons1, int index1) {
        this.controlButtons = controlButtons1;
        this.index = index1;
    }

    public void actionPerformed(ActionEvent arg0) {

        String currentText = controlButtons.controlBut[index].getText();

        System.out.println(currentText);
        System.out.println(controlButtons.buttonBool[index]);

        changeButtonAndBool(0, currentText,"STOP", "START", controlButtons);
        changeButtonAndBool(1, currentText,"SLOW", "FAST", controlButtons);
        changeButtonAndBool(2, currentText,"NEAR", "FAR", controlButtons);

        setTrueButtonAndBool(3, currentText, "CLEAR", controlButtons);
        setTrueButtonAndBool(4, currentText, "EXIT", controlButtons);

        currentText = controlButtons.controlBut[index].getText();
        System.out.println(currentText);
        System.out.println(controlButtons.buttonBool[index]);

    }

}
