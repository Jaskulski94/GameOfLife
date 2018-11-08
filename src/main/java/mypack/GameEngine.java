package mypack;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameEngine {

    public List<ControlButtons> controlButtons;
    public List<List<GameButtons>> gameButtons;
    public JPanel panel;
    public int size;
    public boolean runGameBool;

    public GameEngine(int size1, List<ControlButtons> controlButtons1, List<List<GameButtons>> gameButtons1, JPanel thisPanel1, boolean runGameBool1) {
        this.size = size1;

        this.controlButtons = controlButtons1;
        this.gameButtons = gameButtons1;
        this.panel = thisPanel1;

        this.runGameBool = runGameBool1;
        init();
    }

    public void initialize(List<List<GameButtons>> gameButtons1){

        GridBagConstraints GBC = new GridBagConstraints();
        GBC.weightx = 1;
        GBC.weighty = 1;
        GBC.fill = GridBagConstraints.BOTH;

        for (int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                GBC.gridx = i;
                GBC.gridy = j;
         //       gameButtons1.get(i).get(j) = new GameButtons();
                gameButtons1.get(i).get(j).addGameSquare(i, j, GBC, panel);
                gameButtons1.get(i).get(j).setIndexX(i);
                gameButtons1.get(i).get(j).setIndexY(j);
                int x = gameButtons1.get(i).get(j).getIndexX();
                int y = gameButtons1.get(i).get(j).getIndexY();

        //        System.out.println(x + " " + y);
            }
        }
    //    System.out.println("Game has been initialized");
    }


    public void tempoFast(){
   //     System.out.println("funkcja tempoFast");

        try
        {
            Thread.sleep(400);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public void tempoSlow(){
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
   //     System.out.println("funkcja nearFarGame "+String.valueOf(controlButtons.get(2).buttonBool));
    }

    public void clearGame(JPanel thisPanel1){
    //    System.out.println("\nZaczynamy czyszczenie");
        Component[] componentList = thisPanel1.getComponents();
        for(Component c : componentList){
            thisPanel1.remove(c);
        }
    //    System.out.println("Wyczyszczone");

        initialize(gameButtons);
    //    System.out.println("Zainicjalizowano nowe buttony");

    //    System.out.println("wartosc clearGame "+String.valueOf(controlButtons.get(3).buttonBool));

        controlButtons.get(3).buttonBool = false;
    //    System.out.println("clearBool zmieniony na: "+String.valueOf(controlButtons.get(3).buttonBool)+"\n");

    }

    public void nextStep() {
    //    System.out.println("funkcja nextStep " + String.valueOf(controlButtons.get(0).buttonBool));
        int sizeI = 0;
        int sizeJ = 0;
        int aliveCells = 0;
        int i = 0;
        int j = 0;
        int x, y; //= 0;
        int ix = 0;
        int jy = 0;
        for (List list : gameButtons) {
            sizeJ = gameButtons.size();
            for (GameButtons but : gameButtons.get(i)) {
                sizeI = list.size();
                for (x = -1; x <= 1; x++) {
                    for (y = -1; y <= 1; y++) {
                        if (!((x == 0) && (y == 0))) {
                            ix = i + x;
                            jy = j+ y;
                            if ((ix >= 0) && (jy >= 0) && (ix < sizeI) && (jy < sizeJ)){
                                if (gameButtons.get(ix).get(jy).getGameButtonBool()) {
                                    aliveCells++;
                                }
                            }
                        }
                    }
                }
                gameButtons.get(i).get(j).setNextButtonBool(false);
                if ((gameButtons.get(i).get(j).gameButtonBool == false) && (aliveCells == 3)){
                    gameButtons.get(i).get(j).setNextButtonBool(true);
                }
                if ((gameButtons.get(i).get(j).gameButtonBool == true) && ((aliveCells == 2) || (aliveCells == 3))){
                    gameButtons.get(i).get(j).setNextButtonBool(true);
                }

                if (aliveCells != 0){
        //            System.out.println("alive cells = "+aliveCells);
                }
                aliveCells = 0;
                i++;
                if (i >= sizeI){
                    i = 0;
                }
            }
            j++;
            if (j >= sizeJ) {
                j = 0;
            }
        }
  //      System.out.println("krok zakonczony");

        for (List list : gameButtons) {
            for (GameButtons but : gameButtons.get(i)) {

                if (gameButtons.get(i).get(j).getNextButtonBool() == true) {
                    gameButtons.get(i).get(j).setGameButtonBool(true);
                } else {
                    gameButtons.get(i).get(j).setGameButtonBool(false);
                }

                gameButtons.get(i).get(j).changeButtonBackground();

                gameButtons.get(i).get(j).setNextButtonBool(false);

                i++;
                if (i >= sizeI) {
                    i = 0;
                }

            }
            j++;
            if (j >= sizeJ) {
                j = 0;
            }

        }


        /*for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                //    String color = String.valueOf(squareButton1[i][j].getBackground());
                System.out.println(String.valueOf(gameButtons.get(i).get(j).getGameButtonBool()));
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
        }*/
    }

    public void exitGame(){
   //     System.out.println("funkcja exitGame " + String.valueOf(controlButtons.get(4).buttonBool));
        runGameBool = false;
        System.exit(0);
    }

    public void playGame(JPanel thisPanel1){
        if (controlButtons.get(3).buttonBool == true){
   //         System.out.println("funkcja clear "+String.valueOf(controlButtons.get(3).buttonBool));
            clearGame(thisPanel1);
            controlButtons.get(3).setBool(false);
        }

        if (controlButtons.get(1).buttonBool == true){
            tempoFast();
        } else {
            tempoSlow();
        }

        if (controlButtons.get(2).buttonBool == true){
            nearFarGame();
        }

        if (controlButtons.get(0).buttonBool == true){
            nextStep();
            thisPanel1.repaint();
        }

        if (controlButtons.get(4).buttonBool == true){
            exitGame();
        }

    }

    public void runGame(JPanel thisPanel1){
        while(runGameBool){
            playGame(thisPanel1);
        }
    }

    public void init() {
    }
}