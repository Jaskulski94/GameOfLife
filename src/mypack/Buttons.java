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

    private boolean startBool;
    private boolean slowBool;
    private boolean nearBool;
    private boolean clearBool;

    JButton startButton;
    JButton slowButton;
    JButton nearButton;
    JButton clearButton;

    private Game gamePanel;

    private ButtonListener startListener;
    private ButtonListener slowListener;
    private ButtonListener nearListener;
    private ButtonListener clearListener;

    public void addButton (JButton but, String name, Font customFont, int panelHeight, ButtonListener buttonLis, boolean bool1) {
        but = new JButton(name);
        but.setBorderPainted(false);
        but.setFocusPainted(false);
        but.setBackground(Color.WHITE);
        but.setForeground(Color.BLACK);
        but.setPreferredSize(new Dimension(panelHeight, panelHeight));
        but.setFont(customFont);
        buttonLis = new ButtonListener(gamePanel, bool1, but);
        but.addActionListener(buttonLis);
        this.add(but);
    }

    public Buttons(Scheme scheme1, Game game1) {
        this.newScheme = scheme1;
        this.gamePanel = game1;

         init();
        }

    public void init() {

        Font customFont = newScheme.getCustomFont();
        customFont = customFont.deriveFont(34f);

        this.setLayout(new FlowLayout());
        this.setBackground(Color.BLACK);

    //    int panelWidth = newScheme.getFrameWidth();
        int panelHeight = newScheme.getFrameHeight();
        panelHeight *= 0.2;

        startButton = new JButton();
        slowButton = new JButton();
        nearButton = new JButton();
        clearButton = new JButton();

        addButton(startButton, "START", customFont, panelHeight, startListener, startBool);
        addButton(slowButton, "SLOW", customFont, panelHeight, slowListener, slowBool);
        addButton(nearButton, "NEAR", customFont, panelHeight, nearListener, nearBool);
        addButton(clearButton, "CLEAR", customFont, panelHeight, clearListener, clearBool);

        ButtonListener startListener = new ButtonListener(gamePanel, startBool, startButton);
        ButtonListener slowListener = new ButtonListener(gamePanel, slowBool, slowButton);
        ButtonListener nearListener = new ButtonListener(gamePanel, nearBool, nearButton);
        ButtonListener clearListener = new ButtonListener(gamePanel, clearBool, clearButton);

        startButton.addActionListener(startListener);
        slowButton.addActionListener(slowListener);
        nearButton.addActionListener(nearListener);
        clearButton.addActionListener(clearListener);

    }
}
