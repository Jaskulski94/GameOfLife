package mypack;

import javax.swing.*;
import java.awt.*;

import lombok.*;

@Data public class ControlButtons {


    JButton controlBut;
    ButtonListener buttonListener;
    boolean buttonBool;
    String falseText;
    String trueText;

    public ControlButtons (){
    }

    public void setFalseAndTrueText (String falseText1, String trueText1){
        falseText = falseText1;
        trueText = trueText1;
        buttonBool = false;
    }

    public void addButton (int panelHeight1, Font customFont1, JPanel thisPanel1) {
        controlBut = new JButton(falseText);
        controlBut.setBorderPainted(false);
        controlBut.setFocusPainted(false);
        controlBut.setBackground(Color.WHITE);
        controlBut.setForeground(Color.BLACK);
        controlBut.setPreferredSize(new Dimension(panelHeight1, panelHeight1/2));
        controlBut.setFont(customFont1);

        buttonListener = new ButtonListener(this);
        controlBut.addActionListener(buttonListener);
        thisPanel1.add(controlBut);
    }

    public void changeButtonAndBool (){
        if (!((controlBut.getText() == "CLEAR") || (controlBut.getText() == "EXIT"))){
            if (getBool()){
                controlBut.setText(falseText);
                setBool(false);
            } else {
                controlBut.setText(trueText);
                setBool(true);
            }
        } else {
            setBool(true);
        }
    }

    public void setBool (boolean bool1){

        buttonBool = bool1;
    }

    public boolean getBool (){

        return buttonBool;
    }

    public void setButtonText (String text1){

        controlBut.setText(text1);
    }
}
