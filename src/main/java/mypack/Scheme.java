package mypack;

import java.awt.*;

import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jakub Jaskulski
 * @version 1.0
 * @since 29.10.18
 *
 *        Contains frame's scheme. Creates customFont.
 *
 */

public class Scheme extends JFrame  {

    /*private TitlePanel titlePanel;
    private ControlPanel controlPanel;
    private GamePanel gamePanel;*/

    private Font customFont;
    private int frameWidth;
    private int frameHeight;

    private List<List<GameButtons>> gameButtons;
    private List<ControlButtons> controlButtons;
    private GameEngine gameEngine;

    private boolean runGameBool;

    private ControlButtonsEnum controlButtonsEnum;

    public Font getCustomFont() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
	        File file = new File(classLoader.getResource("font/visitor1.ttf").getFile());

            customFont = Font.createFont(Font.TRUETYPE_FONT, file);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, file));
        } catch (IOException e) {
            e.printStackTrace();
        } catch(FontFormatException e) {
            e.printStackTrace();
        }
        return customFont;
    }

    public int getFrameWidth() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frameWidth = dim.width/2;
        return frameWidth;
    }

    public int getFrameHeight() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frameHeight = dim.height*2/3;
        return frameHeight;
    }

    public Scheme() {
        init();
    }

    public void init() {

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    System.exit(0);
            }
        });

        controlButtons = new ArrayList<>();
        gameButtons = new ArrayList<>();


        TitlePanel titlePanel = new TitlePanel(this);
        titlePanel.setPreferredSize(new Dimension(frameWidth, frameHeight / 12));

        GamePanel gamePanel = new GamePanel(gameButtons);
        gamePanel.setPreferredSize(new Dimension(frameWidth, frameHeight * 7 / 12));

        ControlPanel controlPanel = new ControlPanel(this, controlButtons);
        controlPanel.setPreferredSize(new Dimension(frameWidth, frameHeight * 2 / 12));

        customFont = getCustomFont();

        Dimension frameDim = new Dimension(frameWidth, frameHeight);
        this.setSize(frameDim);

        GridBagLayout layout1 = new GridBagLayout();
        this.setLayout(layout1);

        GridBagConstraints GBC = new GridBagConstraints();

        GBC.gridx = 0;
        GBC.gridy = 0;
        GBC.weightx = 1;
        GBC.weighty = 1;
        GBC.fill = GridBagConstraints.BOTH;
        this.add(titlePanel, GBC);

        GBC.gridx = 0;
        GBC.gridy = 1;
        this.add(gamePanel, GBC);

        GBC.gridx = 0;
        GBC.gridy = 2;
        this.add(controlPanel, GBC);

        Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        titlePanel.setBorder(raisedetched);
        gamePanel.setBorder(raisedetched);
        controlPanel.setBorder(raisedetched);

        titlePanel.setVisible(true);
        gamePanel.setVisible(true);
        controlPanel.setVisible(true);

        this.setVisible(true);

        runGameBool = true;

        gameEngine = new GameEngine(gamePanel.getGameSize(), controlButtons, gameButtons, gamePanel, runGameBool);
        gameEngine.initialize(gameButtons);
        gameEngine.runGame(gamePanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

