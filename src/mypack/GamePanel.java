package mypack;

import javax.swing.*;
import java.awt.*;

/**
 * @author Jakub Jaskulski
 * @version 1.0
 * @since 29.10.18
 *
 *        Panel with Game itself.
 *
 */

public class GamePanel extends JPanel {

    private Scheme newScheme;

    /*public JButton[][] squareButton1;
    public boolean[][] squareBool1;*/

   /* boolean startBool = false;
    boolean slowBool = false;
    boolean nearBool = false;
    boolean clearBool = false;*/

    ControlButtons controlButtons;
    GameButtons[][] gameButtons;
    GameEngine gameEngine;

   // boolean[] controlBools;

    boolean gameRunBool;

    int size;


 /*   public void addGameSquare(JButton but1, boolean bool1, GridBagConstraints GBC, JPanel thisPanel1){
        but1 = new JButton();
        but1.setBorderPainted(true);
        but1.setFocusPainted(false);
        but1.setBackground(Color.BLACK);
        but1.setContentAreaFilled(true);
        SquareListener squareLis = new SquareListener(bool1, but1);
        but1.addActionListener(squareLis);
        thisPanel1.add(but1, GBC);
    }

    public void initialize(int size, JPanel thisPanel1){
        int gameSize = size;

        squareButton1 = new JButton[gameSize][gameSize];
        squareBool1 = new boolean[gameSize+2][gameSize+2];

        int widthSize = squareButton1[0].length;
        int HeightSize = squareButton1[1].length;
        GridBagConstraints GBC = new GridBagConstraints();
        GBC.weightx = 1;
        GBC.weighty = 1;
        GBC.fill = GridBagConstraints.BOTH;

        for (int i=0; i<widthSize; i++){
            for(int j=0; j<HeightSize; j++){
               GBC.gridx = i;
               GBC.gridy = j;
               addGameSquare(squareButton1[i][j], squareBool1[i+1][j+1], GBC, thisPanel1);
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
            this.remove(c);
        }
        System.out.println("Wyczyszczone");

        initialize(size, thisPanel1);
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
                System.out.println(String.valueOf(squareBool1[i][j]));
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        if (!((x == 0) && (y == 0))) {
                        //    if (squareBool1[i + x][j + y]) {
                                aliveCells++;
                        //    }
                        }
                    }
                }
                *//*if (aliveCells != 0)
                System.out.println("amount of alive neighbours: "+aliveCells);*//*
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
    //        System.out.println("tempoFastBool weszlo");
        } else {
            tempoSlow();
   //         System.out.println("tempoSlowBool weszlo");
        }

        if (controlButtons.buttonBool[2] == true){
            nearFarGame();
    //        System.out.println("nearBool weszlo");
        }

        if (controlButtons.buttonBool[0] == true){
            nextStep();
  //          System.out.println("nextStepBool cos robi");
        }

    }

    public void runGame(JPanel thisPanel1){

        System.out.println("runGame cos robi");

        gameRunBool = true;
        while(gameRunBool){
            playGame(thisPanel1);
        }
    }*/

    public GamePanel(Scheme scheme1, ControlButtons controlButtons1, GameButtons[][] gameButtons1, GameEngine gameEngine1) {
        this.newScheme = scheme1;
        this.controlButtons = controlButtons1;
    //    this.gameButtons = gameButtons1;
        this.gameEngine = gameEngine1;
        init();
    }

    public void init() {

        GridBagLayout layout1 = new GridBagLayout();
        this.setLayout(layout1);

        this.setBackground(Color.WHITE);

        boolean runGameBool = true;
     //   gameEngine.runGame(runGameBool, 5, gameButtons, this);

        size = 5;
     //   gameEngine.initialize(size, gameButtons, this);

        gameButtons = new GameButtons[size][size];

        runGameBool = true;
        GameEngine gameEngine = new GameEngine(size, controlButtons, gameButtons, this);
        gameEngine.runGame(runGameBool, size, gameButtons, this);

        /*squareBool1[1][1] = true;
        System.out.println(String.valueOf(squareBool1[1][1]));*/

    }
}
