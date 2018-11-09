package mypack;

import javax.swing.*;
import java.awt.*;
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

    public GamePanel() {
        init();
    }

    public void init() {

        GridBagLayout layout1 = new GridBagLayout();
        this.setLayout(layout1);
        this.setBackground(Color.WHITE);
    }
}
