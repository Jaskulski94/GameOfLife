package mypack;

import javax.swing.*;
import java.awt.*;

public class GameButtons {

    public int indexX;
    public int indexY;
    public JButton gameButton;

    public boolean nextButtonBool;
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
        SquareListener gameButtonListener = new SquareListener(this);
        gameButton.addActionListener(gameButtonListener);
        thisPanel1.add(gameButton, GBC);
    }

    public boolean getGameButtonBool() {
        return gameButtonBool;
    }

    public void setGameButtonBool (boolean bool1){
        gameButtonBool = bool1;
    }

    public void changeGameButtonBull(){
        gameButtonBool ^= true;
    }

    public void changeButtonBackground(){

        if (gameButtonBool == true)
            gameButton.setBackground(Color.WHITE);
        else
            gameButton.setBackground(Color.BLACK);
    }

    public void changeButAndBool(){
        changeGameButtonBull();
        changeButtonBackground();
    }

    public void setNextButtonBool (boolean bool1){
        nextButtonBool = bool1;
    }

    public boolean getNextButtonBool (){
        return nextButtonBool;
    }

    public void init() {

    }

}
