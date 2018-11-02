package mypack;

import javax.swing.*;
import java.awt.*;

public class ControlButtons {

    int numberOfButton;
    int index[];
    JButton[] controlBut;
    ButtonListener[] buttonListener;
    String[] buttonText;
    boolean[] buttonBool;

    public ControlButtons (String[] names1){
        numberOfButton = names1.length;
        index = new int [numberOfButton];
        buttonText = new String [numberOfButton];
        buttonBool = new boolean[numberOfButton];
        for (int i=0; i<numberOfButton; i++){
            index[i] = i;
            buttonText[i] = names1[i];
        }
        controlBut = new JButton[numberOfButton];
        buttonListener = new ButtonListener[numberOfButton];
    }

    public void addButton (int index1, int panelHeight1, Font customFont1, JPanel thisPanel1) {
        controlBut[index1] = new JButton(buttonText[index1]);
        controlBut[index1].setBorderPainted(false);
        controlBut[index1].setFocusPainted(false);
        controlBut[index1].setBackground(Color.WHITE);
        controlBut[index1].setForeground(Color.BLACK);
        controlBut[index1].setPreferredSize(new Dimension(panelHeight1, panelHeight1));
        controlBut[index1].setFont(customFont1);

        buttonListener[index1] = new ButtonListener(this, index[index1]);
        controlBut[index1].addActionListener(buttonListener[index1]);
        thisPanel1.add(controlBut[index1]);
    }

    public void setBool (int index1, boolean bool1){
        buttonBool[index1] = bool1;
    }

    public void setButtonText (int index1, String text1){
        controlBut[index1].setText(text1);
    }
}
