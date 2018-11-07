package mypack;

import javax.swing.*;
import java.awt.*;

import lombok.*;

@Data public class ControlButtons {


    JButton controlBut;
    ButtonListener buttonListener;
    String buttonText;
    boolean buttonBool;

    public ControlButtons (String name1){

        buttonText = name1;
        buttonBool = false;
    }

    public void addButton (int panelHeight1, Font customFont1, JPanel thisPanel1) {
        controlBut = new JButton(buttonText);
        controlBut.setBorderPainted(false);
        controlBut.setFocusPainted(false);
        controlBut.setBackground(Color.WHITE);
        controlBut.setForeground(Color.BLACK);
        controlBut.setPreferredSize(new Dimension(panelHeight1, panelHeight1));
        controlBut.setFont(customFont1);

        buttonListener = new ButtonListener(this);
        controlBut.addActionListener(buttonListener);
        thisPanel1.add(controlBut);
    }

    public void setBool (boolean bool1){
        buttonBool = bool1;
    }

    public void setButtonText (String text1){
        controlBut.setText(text1);
    }
}
