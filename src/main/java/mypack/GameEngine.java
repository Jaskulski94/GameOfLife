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
    public boolean closerFurtherBool = true;

    int sizeI = 0;
    int sizeJ = 0;
    int aliveCells = 0;
    int i = 0;
    int j = 0;
    int x, y;
    int ix;
    int jy;

    public GameEngine(int size1, List<ControlButtons> controlButtons1, List<List<GameButtons>> gameButtons1, JPanel thisPanel1, boolean runGameBool1) {
        this.size = size1;

        this.controlButtons = controlButtons1;
        this.gameButtons = gameButtons1;
        this.panel = thisPanel1;

        this.runGameBool = runGameBool1;
        init();
    }

    public void refresh (){
        panel.setVisible(false);
        panel.setVisible(true);
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
        refresh();
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

    public void closer(){
        sizeI = 0;
        sizeJ = 0;
        i = 0;
        j = 0;
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
    }

    public void further(){
        sizeI = 0;
        sizeJ = 0;
        i = 0;
        j = 0;
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
        closerFurtherBool = true;
    }

    public void closerFurtherGame(){
        sizeI = 0;
        sizeJ = 0;
        i = 0;
        j = 0;
        if (controlButtons.get(2).buttonBool && closerFurtherBool) {
            closer();
            closerFurtherBool = false;
        }

        if (!controlButtons.get(2).buttonBool && !closerFurtherBool) {
            further();
            closerFurtherBool = true;
        }
    }

    public void clearGame(){

        Component[] componentList = panel.getComponents();
        for(Component c : componentList){
            panel.remove(c);
        }

        initialize(gameButtons);
        closerFurtherBool = false;
        controlButtons.get(2).setBool(false);
        controlButtons.get(2).controlBut.setText(controlButtons.get(2).getFalseText());
        closerFurtherGame();

        controlButtons.get(3).buttonBool = false;

        refresh();
    }

    public void nextStep() {

        sizeI = 0;
        sizeJ = 0;
        aliveCells = 0;
        i = 0;
        j = 0;
        x = 0;
        y = 0;
        ix = 0;
        jy = 0;

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
                if (!(gameButtons.get(i).get(j).gameButtonBool) && (aliveCells == 3)){
                    gameButtons.get(i).get(j).setNextButtonBool(true);
                }
                if ((gameButtons.get(i).get(j).gameButtonBool) && ((aliveCells == 2) || (aliveCells == 3))){
                    gameButtons.get(i).get(j).setNextButtonBool(true);
                }

                /*if (aliveCells != 0){

                }*/
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

        /*for (List<GameButtons> list :
                gameButtons) {
            for (GameButtons button :
                    list) {
                button.getGameButtonBool();
            }
        }*/

        for (List list : gameButtons) {
            for (GameButtons but : gameButtons.get(i)) {

                if (gameButtons.get(i).get(j).getNextButtonBool()) {
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

    //    refresh();
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

            clearGame();
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

        closerFurtherGame();

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