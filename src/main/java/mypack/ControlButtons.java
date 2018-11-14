package mypack;

import javax.swing.*;
import java.awt.*;

import lombok.*;

@Data
public class ControlButtons {
    
    JButton controlBut;
    ControlListener controlListener;
    boolean buttonBool;
    String falseText;
    String trueText;
    boolean nonSwitchButtonbull;

    public ControlButtons (){
    }

    public void setFalseAndTrueText (String falseText1, String trueText1){
        falseText = falseText1;
        trueText = trueText1;
        buttonBool = false;
        nonSwitchButtonbull = false;
    }

    public void addButton (int panelHeight1, Font customFont1, JPanel thisPanel1) {
        controlBut = new JButton(falseText);
        controlBut.setBorderPainted(false);
        controlBut.setFocusPainted(false);
        controlBut.setBackground(Color.WHITE);
        controlBut.setForeground(Color.BLACK);
        controlBut.setPreferredSize(new Dimension(panelHeight1, panelHeight1/2));
        controlBut.setFont(customFont1);

        controlListener = new ControlListener(this);
        controlBut.addActionListener(controlListener);
        thisPanel1.add(controlBut);
    }

    public void changeButtonAndBool (){
        if (!(nonSwitchButtonbull)){
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

    public void setNonSwitchButtonbull (boolean bool1){
        nonSwitchButtonbull = bool1;
    }

    public void setTrueText (String text1){

        trueText = text1;
    }

    public String getTrueText (){

        return trueText;
    }

    public void setFalseText (String text1){

        falseText = text1;
    }

/*
    public String getFalseText (){
        return falseText;
    }
*/

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
