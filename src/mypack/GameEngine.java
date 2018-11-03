package mypack;

import javax.swing.*;
import java.awt.*;

public class GameEngine {

    public ControlButtons controlButtons;
    public GameButtons[][] gameButtons;
    public JPanel panel;
    public int size;

    public GameEngine(int size1, ControlButtons controlButtons1, GameButtons[][] gameButtons1, JPanel thisPanel1) {
        this.size = size1;

        this.controlButtons = controlButtons1;
        this.gameButtons = gameButtons1;
        this.panel = thisPanel1;
        init();
    }


 /*   public void initialize(int size, GameButtons[][] gameButtons1, JPanel thisPanel1){
   //     int gameSize = size;

        gameButtons1 = new GameButtons[size][size];

        *//*int widthSize = gameButtons1[0].length;
        int HeightSize = gameButtons1[1].length;*//*

        GridBagConstraints GBC = new GridBagConstraints();
        GBC.weightx = 1;
        GBC.weighty = 1;
        GBC.fill = GridBagConstraints.BOTH;

        for (int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                GBC.gridx = i;
                GBC.gridy = j;
                gameButtons1[i][j].addGameSquare(i, j, GBC, thisPanel1);
            }
        }
        System.out.println("Game has been initialized");
    }*/

    public void initialize(){
     //   gameButtons = new GameButtons[size][size];

        GridBagConstraints GBC = new GridBagConstraints();
        GBC.weightx = 1;
        GBC.weighty = 1;
        GBC.fill = GridBagConstraints.BOTH;

        for (int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                GBC.gridx = i;
                GBC.gridy = j;
                gameButtons[i][j] = new GameButtons();
                gameButtons[i][j].addGameSquare(i, j, GBC, panel);
                gameButtons[i][j].setIndexX(i);
                gameButtons[i][j].setIndexY(j);
                int x = gameButtons[i][j].getIndexX();
                int y = gameButtons[i][j].getIndexY();

                System.out.println(x + " " + y);
            }
        }
        System.out.println("Game has been initialized");
    }


    public void tempoFast(){
        System.out.println("funkcja tempoFast");

        try
        {
            Thread.sleep(200);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public void tempoSlow(){
        //     System.out.println("funkcja tempoSlow");

        try
        {
            Thread.sleep(1200);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public void nearFarGame(){
        System.out.println("funkcja nearFarGame "+String.valueOf(controlButtons.buttonBool[2]));
    }

    public void clearGame(JPanel thisPanel1){
        System.out.println("\nZaczynamy czyszczenie");
        Component[] componentList = thisPanel1.getComponents();
        for(Component c : componentList){
            thisPanel1.remove(c);
        }
        System.out.println("Wyczyszczone");

        initialize();
        System.out.println("Zainicjalizowano nowe buttony");

        System.out.println("wartosc clearGame "+String.valueOf(controlButtons.buttonBool[3]));
        //clearBool = false;
        controlButtons.buttonBool[3] = false;
        System.out.println("clearBool zmieniony na: "+String.valueOf(controlButtons.buttonBool[3])+"\n");

    }

    public void nextStep() {
        System.out.println("funkcja nextStep " + String.valueOf(controlButtons.buttonBool[0]));

        int aliveCells = 0;
        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                //    String color = String.valueOf(squareButton1[i][j].getBackground());
                System.out.println(String.valueOf(gameButtons[i][j].getGameButtonBool()));
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        if (!((x == 0) && (y == 0))) {
                            //    if (squareBool1[i + x][j + y]) {
                            aliveCells++;
                            //    }
                        }
                    }
                }
                /*if (aliveCells != 0)
                System.out.println("amount of alive neighbours: "+aliveCells);*/
                aliveCells = 0;
            }
        }
    }

    public void playGame(JPanel thisPanel1){
        if (controlButtons.buttonBool[3] == true){
            System.out.println("funkcja clear "+String.valueOf(controlButtons.buttonBool[3]));
            clearGame(thisPanel1);
            controlButtons.setBool(3,false);
        }

        if (controlButtons.buttonBool[1] == true){
            tempoFast();
        } else {
            tempoSlow();
        }

        if (controlButtons.buttonBool[2] == true){
            nearFarGame();
        }

        if (controlButtons.buttonBool[0] == true){
            nextStep();
        }

    }

    public void runGame(boolean gameRunBool1, int size1, GameButtons[][] gameButtons1, JPanel thisPanel1){

        initialize();

        /*while(gameRunBool1){
            playGame(thisPanel1);
        }*/
    }

    public void init() {
    //    size = 5;
    }
}