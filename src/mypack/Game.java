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

    /*public boolean getStartBool(){
        return startBool;
    }

    public boolean getSlowBool(){
        return slowBool;
    }

    public boolean getNearBool(){
        return nearBool;
    }

    public boolean getClearBool(){
        return clearBool;
    }
*/
    public void changeBool (boolean Bool) {
        Bool ^= true;
    }

    public void changeStartBool () {
        startBool ^= true;
    }

    public void changeSlowBool () {
        slowBool ^= true;
    }

    public void changeNearBool () {
        nearBool ^= true;
    }

    public void changeClearBool () {
        clearBool ^= true;
    }

    public Game(Scheme scheme1) {
        this.newScheme = scheme1;
        init();
    }

    public void init() {

    //    this.setLayout(new FlowLayout());
        this.setBackground(Color.WHITE);

        int panelWidth = newScheme.getFrameWidth();
        int panelHeight = newScheme.getFrameHeight();
        panelHeight *= 0.7;

        this.setSize(panelWidth, panelHeight);

    }
}
