package mypack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Jakub Jaskulski
 * @version 1.0
 * @since 29.10.18
 *
 *        Panel with buttons.
 *
 */

public class Buttons extends JPanel {

    private Scheme newScheme;

    boolean startBool;
    boolean slowBool;
    boolean nearBool;
    boolean clearBool;

    JButton startButton;
    JButton slowButton;
    JButton nearButton;
    JButton clearButton;

    private Game gamePanel;

    private TestListener testListener;

    ButtonListener startListener;
    ButtonListener slowListener;
    ButtonListener nearListener;
    ButtonListener clearListener;

    public void addButton (JButton but, String name, Font customFont, int panelHeight, ButtonListener buttonLis, boolean Bool1) {
        but = new JButton(name);
        but.setBorderPainted(false);
        but.setFocusPainted(false);
        but.setBackground(Color.WHITE);
        but.setForeground(Color.BLACK);
        but.setPreferredSize(new Dimension(panelHeight, panelHeight));
        but.setFont(customFont);
        buttonLis = new ButtonListener(gamePanel, Bool1);
        but.addActionListener(buttonLis);
        this.add(but);
    }

//    public Buttons(Scheme scheme1, ButtonListener startListener, ButtonListener slowButton, ButtonListener nearButton, ButtonListener clearButton, Game game1) {
    public Buttons(Scheme scheme1, Game game1) {
        this.newScheme = scheme1;
        this.gamePanel = game1;

        /*     this.startListener = startListener;
         this.slowButton = slowButton;
         this.nearButton = nearButton;
         this.clearButton = clearButton;*/

    /*    this.startBool = game1.startBool;
        this.slowBool = game1.startBool;
        this.nearBool = game1.startBool;
        this.clearBool = game1.startBool;*/

         init();
        }

    public void init() {

        Font customFont = newScheme.getCustomFont();
        customFont = customFont.deriveFont(34f);

        this.setLayout(new FlowLayout());
        this.setBackground(Color.BLACK);

        int panelWidth = newScheme.getFrameWidth();
        int panelHeight = newScheme.getFrameHeight();
        panelHeight *= 0.2;

        this.setSize(panelWidth, panelHeight);

        /*JButton startButton = new JButton();
        JButton slowButton = new JButton();
        JButton nearButton = new JButton();
        JButton clearButton = new JButton();*/

        startButton = new JButton();
        slowButton = new JButton();
        nearButton = new JButton();
        clearButton = new JButton();

        addButton(startButton, "START", customFont, panelHeight, startListener, startBool);
        addButton(slowButton, "SLOW", customFont, panelHeight, slowListener, slowBool);
        addButton(nearButton, "NEAR", customFont, panelHeight, nearListener, nearBool);
        addButton(clearButton, "CLEAR", customFont, panelHeight, clearListener, clearBool);

        ButtonListener startListener = new ButtonListener(gamePanel, startBool);
        ButtonListener slowListener = new ButtonListener(gamePanel, slowBool);
        ButtonListener nearListener = new ButtonListener(gamePanel, nearBool);
        ButtonListener clearListener = new ButtonListener(gamePanel, clearBool);

     /*   startListener = new ButtonListener(gamePanel, 1);
        slowListener = new ButtonListener(gamePanel, 2);
        nearListener = new ButtonListener(gamePanel, 3);
        clearListener = new ButtonListener(gamePanel, 4);
*/
        startButton.addActionListener(startListener);
        slowButton.addActionListener(slowListener);
        nearButton.addActionListener(nearListener);
        clearButton.addActionListener(clearListener);


        testListener = new TestListener();
        JButton test = new JButton("test");
        test.addActionListener(testListener);
        this.add(test);
        System.out.println("Jestem w Buttons");

        clearButton.addActionListener(testListener);

        JButton showDialogButton = new JButton("Text Button");
        showDialogButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("nowy AL");
            }
        });
        this.add(showDialogButton);
    }
}
