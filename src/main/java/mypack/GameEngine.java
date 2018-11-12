package mypack;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameEngine {

    public List<ControlButtons> controlButtons;
    public List<List<GameButtons>> gameButtons;
    public JPanel panel;
    public int size;
    public boolean runGameBool;
    public boolean nearFarBool = true;

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
                gameButtons1.get(i).get(j).addGameSquare(i, j, GBC, panel);
                gameButtons1.get(i).get(j).setGameButtonBool(false);
                gameButtons1.get(i).get(j).setNextButtonBool(false);
            }
        }
    }


    public void tempoFast(){
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
        try
        {
            Thread.sleep(700);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public void changeTempo(){
        if (controlButtons.get(1).buttonBool){
            tempoFast();
        } else {
            tempoSlow();
        }
    }

    public void nearFarGame(){

        int sizeI = 0;
        int sizeJ = 0;
        int i = 0;
        int j = 0;
        if (controlButtons.get(2).buttonBool && nearFarBool) {
            sizeJ = gameButtons.size();
            for (List list : gameButtons) {
                sizeI = list.size();
                for (GameButtons but : gameButtons.get(i)) {

                    if ((i < (sizeI / 3)) || (i > sizeI * 2 / 3)) {
                        gameButtons.get(i).get(j).gameButton.setVisible(false);
                    }

                    if ((j < (sizeJ / 3)) || (j > sizeJ * 2 / 3)) {
                        gameButtons.get(i).get(j).gameButton.setVisible(false);
                    }

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
            nearFarBool = false;
        }

        if (!controlButtons.get(2).buttonBool && !nearFarBool) {
            sizeJ = gameButtons.size();
            for (List list : gameButtons) {
                sizeI = list.size();
                for (GameButtons but : gameButtons.get(i)) {
                    gameButtons.get(i).get(j).gameButton.setVisible(true);
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
            nearFarBool = true;
        }
    }

    public void clearGame(JPanel thisPanel1){

        Component[] componentList = thisPanel1.getComponents();
        for(Component c : componentList){
            thisPanel1.remove(c);
        }

        initialize(gameButtons);

        controlButtons.get(3).buttonBool = false;
    }

    public void nextStep() {

        int sizeI = 0;
        int sizeJ = 0;
        int aliveCells = 0;
        int i = 0;
        int j = 0;
        int x, y;
        int ix;
        int jy;

        sizeJ = gameButtons.size();
        for (List list : gameButtons) {
            sizeI = list.size();
            for (GameButtons but : gameButtons.get(i)) {
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
    }

    public void exitGame(){

        runGameBool = false;
        System.exit(0);
    }

    public void playGame(JPanel thisPanel1){

        if (controlButtons.get(3).buttonBool){

            controlButtons.get(0).setBool(false);
            controlButtons.get(0).setButtonText("START");

            try
            {
                Thread.sleep(400);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }

            clearGame(thisPanel1);
            controlButtons.get(3).setBool(false);
        }

        if (controlButtons.get(0).buttonBool){
            nextStep();

            try
            {
                Thread.sleep(200);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }

        nearFarGame();

        changeTempo();

        if (controlButtons.get(4).buttonBool){
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