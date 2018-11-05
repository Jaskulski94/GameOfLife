package mypack;

import javax.swing.*;
import java.awt.*;

public class GameButtons {

    public int indexX;
    public int indexY;
    public JButton gameButton;

    public boolean gameButtonBool;

    public GameButtons() {
        init();
    }

    public void addGameSquare(int index1, int index2, GridBagConstraints GBC, JPanel thisPanel1) {
        indexX = index1;
        indexY = index2;
        gameButton = new JButton();
        gameButton.setBorderPainted(true);
        gameButton.setFocusPainted(false);
        gameButton.setBackground(Color.BLACK);
        gameButton.setContentAreaFilled(true);
        SquareListener gameButtonListener = new SquareListener(gameButtonBool, gameButton);
        gameButton.addActionListener(gameButtonListener);
        thisPanel1.add(gameButton, GBC);
    }

    public boolean getGameButtonBool() {
        return gameButtonBool;
    }

    public int getIndexX(){
        return indexX;
    }

    public int getIndexY(){
        return indexY;
    }


    public void setIndexX(int index1){
        indexX = index1;
    }

    public void setIndexY(int index1){
        indexY = index1;
    }

    public void init() {

    }

}
