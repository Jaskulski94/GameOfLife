package mypack;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameEngine {

    private List<ControlButtons> controlButtons;
    private List<List<GameButtons>> gameButtons;
    private JPanel panel;
    private int size;
    private boolean runGameBool;
    private boolean closerFurtherBool = true;
    private ControlButtonsEnum controlButtonsEnum;

    private int sizeI = 0;
    private int sizeJ = 0;
    private int aliveCells = 0;
    private int i = 0;
    private int j = 0;
    private int x, y;
    private int ix;
    private int jy;

    public GameEngine(int size1, List<ControlButtons> controlButtons1, List<List<GameButtons>> gameButtons1, JPanel thisPanel1, boolean runGameBool1) {
        this.size = size1;

        this.controlButtons = controlButtons1;
        this.gameButtons = gameButtons1;
        this.panel = thisPanel1;

        this.runGameBool = runGameBool1;
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
        if (controlButtons.get(getEnumValue("SLOWER")).buttonBool){
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
        for (List<GameButtons> list : gameButtons) {
            for (GameButtons button : list) {
                button.gameButton.setVisible(true);
            }
        }
        closerFurtherBool = true;
    }

    public void closerFurtherGame(){
        if (controlButtons.get(getEnumValue("FURTHER")).buttonBool && closerFurtherBool) {
            closer();
            closerFurtherBool = false;
        }

        if (!controlButtons.get(getEnumValue("FURTHER")).buttonBool && !closerFurtherBool) {
            further();
            closerFurtherBool = true;
        }
    }

    public void clearGame(){
        controlButtons.get(getEnumValue("STOP")).setButtonBool(false);
        controlButtons.get(getEnumValue("STOP")).setControlButtonText("START");

        try
        {
            Thread.sleep(400);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        Component[] componentList = panel.getComponents();
        for(Component c : componentList){
            panel.remove(c);
        }

        initialize(gameButtons);
        closerFurtherBool = false;
        controlButtons.get(2).setButtonBool(false);
        controlButtons.get(2).controlBut.setText(controlButtons.get(2).getFalseText());
        closerFurtherGame();

        controlButtons.get(3).buttonBool = false;

        refresh();

        controlButtons.get(getEnumValue("CLEAR")).setButtonBool(false);

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

        for (List<GameButtons> list : gameButtons) {
            for (GameButtons button : list) {
                if (button.getNextButtonBool()){
                    button.setGameButtonBool(true);
                } else {
                    button.setGameButtonBool(false);
                }

                button.changeButtonBackground();
                button.setNextButtonBool(false);
            }
        }
    }

    public void exitGame(){
        runGameBool = false;
        System.exit(0);
    }

    private int getEnumValue(String name1){
        ControlButtonsEnum enum1 = ControlButtonsEnum.valueOf(name1);
        return enum1.getValue();
    }

    public void runGame(JPanel thisPanel1){
        while(runGameBool){

            if (controlButtons.get(getEnumValue("CLEAR")).buttonBool){
                clearGame();
            }

            if (controlButtons.get(getEnumValue("STOP")).buttonBool){
                nextStep();
            }

            if (controlButtons.get(getEnumValue("EXIT")).buttonBool){
                exitGame();
            }

            closerFurtherGame();

            changeTempo();
        }
    }
}