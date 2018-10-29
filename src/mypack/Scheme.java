package mypack;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * @author Jakub Jaskulski
 * @version 1.0
 * @since 29.10.18
 *
 *        Class containing distribution scheme.
 *
 */

public class Scheme extends JFrame {

    public Scheme() {
        init();
    }

    public void init() {
        setSize(1000, 1000);
        setLayout(new GridLayout(3, 1));

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        System.out.println(dim.width);
        System.out.println(dim.height);

        this.setSize(dim.width/2, dim.height/2);

      //  this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height
      //          / 2 - this.getSize().height / 2);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

}

