package mypack;

import javax.swing.*;
import java.awt.*;

import lombok.*;

@Data
public class GameButtons {

    public int indexX;
    public int indexY;
    public JButton gameButton;

    public Boolean nextButtonBool;
    public Boolean gameButtonBool;

    public GameButtons() {
        init();
    }

    public void addGameSquare(int index1, int index2, GridBagConstraints GBC, JPanel thisPanel1) {
        indexX = index1;
        indexY = index2;
        gameButton = new JButton();
    //    gameButton.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        gameButton.setBorderPainted(true);
        gameButton.setFocusPainted(false);
        gameButton.setBackground(Color.BLACK);
        gameButton.setContentAreaFilled(true);
        GameListener gameListener = new GameListener(this);
        gameButton.addActionListener(gameListener);
        thisPanel1.add(gameButton, GBC);
    }

    public void changeGameButtonBull(){
        gameButtonBool ^= true;
    }

    public void changeButtonBackground(){

        if (gameButtonBool)
            gameButton.setBackground(Color.WHITE);
        else
            gameButton.setBackground(Color.BLACK);
    }

    public void changeButAndBool(){
        changeGameButtonBull();
        changeButtonBackground();
    }

    public void init() {

    }

}
