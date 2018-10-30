package mypack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestListener implements ActionListener {

    public TestListener() {
    }

    public void actionPerformed(ActionEvent arg0) {

        System.out.println("Nowy Action Listener");

    }

}
