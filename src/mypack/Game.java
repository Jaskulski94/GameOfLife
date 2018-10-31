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

public class Game extends JPanel {

    private Scheme newScheme;

    JButton[][] squareButton1;
    boolean[][] squareBool1;

    boolean startBool = false;
    boolean slowBool = false;
    boolean nearBool = false;
    boolean clearBool = false;

    int size;

    public void changeBool(boolean bool1){
        bool1 ^= true;
    }

    /*public void changeStartBool(){
        startBool ^= true;
    }*/

    public void setStartBool(boolean bool1){
        startBool = bool1;
    }

    public void setSlowBool(boolean bool1){
        slowBool = bool1;
    }

    public void setNearBool(boolean bool1){
        nearBool = bool1;
    }

    public void setClearBool(boolean bool1){
        clearBool = bool1;
    }

 //   int panelWidth;
 //   int panelHeight;

   /* public class ButtonModel {
        JButton but;
        boolean butBool = false;

        public boolean getBool(){
            return butBool;
        }

        public void setBool(boolean bool1){
            this.butBool = bool1;
        }

        public void changeBool(){
            this.butBool ^= true;
        }

        public JButton getButton (){
            return but;
        }
    }*/

    public void addGameSquare(JButton but1, boolean bool1, GridBagConstraints GBC){
        but1 = new JButton();
        but1.setBorderPainted(true);
        but1.setFocusPainted(false);
        but1.setBackground(Color.BLACK);
        but1.setContentAreaFilled(true);
        SquareListener squareLis = new SquareListener(bool1, but1);
        but1.addActionListener(squareLis);
        this.add(but1, GBC);
    }

    public void initialize(int size){
        int gameSize = size;

        JButton[][] squareButton1 = new JButton[gameSize][gameSize];
        boolean[][] squareBool1 = new boolean[gameSize+2][gameSize+2];

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
               addGameSquare(squareButton1[i][j], squareBool1[i+1][j+1], GBC);
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
        System.out.println("funkcja nearFarGame "+String.valueOf(nearBool));
    }

    public void clearGame(){
        initialize(size);
        System.out.println("funkcja clearGame "+String.valueOf(clearBool));
        clearBool = false;
    //    startBool = false;
    }

    public void nextStep() {
        System.out.println("funkcja nextStep " + String.valueOf(startBool));
        int aliveCells = 0;
        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                for (int x = -1; x <= 2; x++) {
                    for (int y = -1; y <= 2; y++) {
                        if (!((x == 0) && (y == 0))) {
                            if (squareBool1[i + x][j + y]) {
                                aliveCells++;
                            }
                        }
                    }
                }
                System.out.println(aliveCells);
                aliveCells = 0;
            }
        }
    }

    public void playGame(){
        if (slowBool == true){
            tempoFast();
    //        System.out.println("tempoFastBool weszlo");
        } else {
            tempoSlow();
   //         System.out.println("tempoSlowBool weszlo");
        }

        if (nearBool == true){
            nearFarGame();
    //        System.out.println("nearBool weszlo");
        }

        if (clearBool == true){
            System.out.println("funkcja clear "+String.valueOf(clearBool));
         //   startBool = false;
            clearGame();
            clearBool = false;
         //   startBool = false;
   //         System.out.println("clearBool cos robi");
        }

        if (startBool == true){
            nextStep();
  //          System.out.println("nextStepBool cos robi");
        }
    //    System.out.println(String.valueOf(startBool)+" startbool");

    }

    public void runGame(){

        System.out.println("runGame cos robi");
        boolean gameRunBool = true;
        while(gameRunBool){
            playGame();
        }
    }

    /*public void initialize(ButtonModel[][] squaresModel1){

        int widthSize = squaresModel1[0].length;
        int heightSize = squaresModel1[1].length;
        GridBagConstraints GBC = new GridBagConstraints();
        GBC.weightx = 1;
        GBC.weighty = 1;
        GBC.fill = GridBagConstraints.BOTH;

        for (int i=0; i<widthSize; i++){
            for(int j=0; j<heightSize; j++){
                GBC.gridx = i;
                GBC.gridy = j;

                squaresModel1[i][j].setBool(true);

                squaresModel1[i][j].changeBool();

                boolean testBool;
                testBool = squaresModel1[i][j].getBool();
                String testString;
                testString = String.valueOf(testBool);
                System.out.println(testString);
           //     JButton buttoner = new JButton();
           //     buttoner = squaresModel1[i][j].getButton();
           //     addGameSquare(buttoner, GBC);

              //  addGameSquare(gameSquares1[i][j].but, GBC);
            }
        }
    }*/

    public Game(Scheme scheme1) {
        this.newScheme = scheme1;
        init();
    }

    public void init() {

        GridBagLayout layout1 = new GridBagLayout();
        this.setLayout(layout1);

        this.setBackground(Color.WHITE);

        GameEngine myGame = new GameEngine();

        size = 20;
        initialize(size);

    }
}
