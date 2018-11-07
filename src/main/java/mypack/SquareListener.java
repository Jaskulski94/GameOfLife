package mypack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SquareListener implements ActionListener {

    boolean bool;
    JButton but;

    public SquareListener(boolean bool1, JButton but1) {
        this.bool = bool1;
        this.but = but1;
    }

    public void actionPerformed(ActionEvent arg0) {

        bool ^= true;

        if (bool == true)
            but.setBackground(Color.WHITE);
        else
            but.setBackground(Color.BLACK);

    }

}
