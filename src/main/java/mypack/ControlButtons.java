package mypack;

import javax.swing.*;
import java.awt.*;

import lombok.*;


@Data
public class ControlButtons {

    public JButton controlBut;
    public ControlListener controlListener;
    public Boolean buttonBool;
    public String falseText;
    public String trueText;
    public Boolean nonSwitchButtonBool;

    public ControlButtons (){
    }

    public void setFalseAndTrueText (String falseText1, String trueText1){
        falseText = falseText1;
        trueText = trueText1;
        buttonBool = false;
        nonSwitchButtonBool = false;
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
        if (!(nonSwitchButtonBool)){
            if (getButtonBool()){
                controlBut.setText(falseText);
                setButtonBool(false);
            } else {
                controlBut.setText(trueText);
                setButtonBool(true);
            }
        } else {
            setButtonBool(true);
        }
    }


    public void setControlButtonText (String text1){
        controlBut.setText(text1);
    }
}
