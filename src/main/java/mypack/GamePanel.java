package mypack;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jakub Jaskulski
 * @version 1.0
 * @since 29.10.18
 *
 *        Panel with Game itself.
 *
 */

public class GamePanel extends JPanel {

    private List<List<GameButtons>> gameButtons;
    private int size;

    private void initializeGameButtons (int size1){
        for (int i = 0; i<size1; i++){
            gameButtons.add(new ArrayList<GameButtons>());
            for (int j = 0; j<size1; j++) {
                gameButtons.get(i).add(new GameButtons());
            }
        }
    }

    public int getGameSize(){
        return size;
    }

    public GamePanel(List<List<GameButtons>> gameButtons1) {
        this.gameButtons = gameButtons1;
        init();
    }


    public void init() {

        size = 30;

        GridBagLayout layout1 = new GridBagLayout();
        this.setLayout(layout1);
        this.setBackground(Color.WHITE);

        initializeGameButtons(size);
    }
}
