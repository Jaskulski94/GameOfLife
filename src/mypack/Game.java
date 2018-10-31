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

    boolean startBool = false;
    boolean slowBool = false;
    boolean nearBool = false;
    boolean clearBool = false;

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

    public void addGameSquare(JButton but, GridBagConstraints GBC){
        but = new JButton();
        but.setBorderPainted(true);
        but.setFocusPainted(false);
        but.setBackground(Color.BLACK);
        but.setContentAreaFilled(true);
        this.add(but, GBC);
    }

    public void initialize(JButton[][] nearGameSquares){

        int widthSize = nearGameSquares[0].length;
        int HeightSize = nearGameSquares[1].length;
        GridBagConstraints GBC = new GridBagConstraints();
        GBC.weightx = 1;
        GBC.weighty = 1;
        GBC.fill = GridBagConstraints.BOTH;

        for (int i=0; i<widthSize; i++){
            for(int j=0; j<HeightSize; j++){
               GBC.gridx = i;
               GBC.gridy = j;
               addGameSquare(nearGameSquares[i][j], GBC);
            }
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

        JButton[][] nearGameSquares = new JButton[20][20];
        initialize(nearGameSquares);

        /*ButtonModel[][] gameSquares = new ButtonModel[20][20];
        initialize(gameSquares);*/

    }
}
