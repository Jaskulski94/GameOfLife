package mypack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*public class ButtonListener implements ActionListener {

    Game gamePanel;
    Boolean chosenBool;

    public ButtonListener(Game game1, boolean Bool1) {
        this.gamePanel = game1;
        this.chosenBool = Bool1;
    }

    public void actionPerformed(ActionEvent arg0) {
        gamePanel.changeBool(chosenBool);

        System.out.println("Listener działa");
       // chosenBool ^= true;

    }

}*/

public class ButtonListener implements ActionListener {

    Game gamePanel;
    boolean Bool1;
//    int choice;

/*    public ButtonListener(Game game1, int choice) {
        this.gamePanel = game1;
        this.choice = choice;
    }*/

    public ButtonListener(Game game1, boolean Bool1) {
        this.gamePanel = game1;
        this.Bool1 = Bool1;
    }

    public void actionPerformed(ActionEvent arg0) {
        System.out.println("Listener coś widzi");

//        gamePanel.changeBool(Bool1);
/*
        switch (choice) {
            case 1:
                gamePanel.changeStartBool();
                System.out.println("Listener 1 działa");
                break;
            case 2:
                gamePanel.changeSlowBool();
                System.out.println("Listener 2 działa");
                break;
            case 3:
                gamePanel.changeNearBool();
                System.out.println("Listener 3 działa");
                break;
            case 4:
                gamePanel.changeClearBool();
                System.out.println("Listener 4 działa");
                break;
            default:
                System.out.println("Error");
                break;
        }*/

    }

}
