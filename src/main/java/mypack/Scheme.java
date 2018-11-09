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
import java.util.stream.Stream;

/**
 * @author Jakub Jaskulski
 * @version 1.0
 * @since 29.10.18
 *
 *        Contains frame's scheme. Creates customFont.
 *
 */

public class Scheme extends JFrame  {

    private TitlePanel titlePanel;
    private ButtonsPanel buttonsPanel;
    private GamePanel gamePanel;

    private Font customFont;
    private int frameWidth;
    private int frameHeight;

    List<List<GameButtons>> gameButtons;
    List<ControlButtons> controlButtons;
    GameEngine gameEngine;

    boolean runGameBool;

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

    public void initializeControlButtons (List<String> names1){
        for (int i = 0; i<names1.size(); i++){
            controlButtons.add(new ControlButtons(names1.get(i)));
        }
    }

    public void initializeGameButtons (int size1){
        for (int i = 0; i<size1; i++){
            gameButtons.add(new ArrayList<GameButtons>());
            for (int j = 0; j<size1; j++) {
                gameButtons.get(i).add(new GameButtons());
            }
        }
    }

    public Scheme() {
        init();
    }

    public void init() {

        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);

        int size = 30;

        String[] namesString = {"STOP", "SLOW", "NEAR", "CLEAR", "EXIT"};
        List<String> names = new ArrayList<>();
        names.addAll(Arrays.asList(namesString));

        /*int k = 0;
        for (ControlButtons cbut : controlButtons){
            if (!(k >= controlButtons.size()) && !(k >= gameButtons.size())) {
                controlButtons.add(new ControlButtons(names.get(k)));
            }
            k++;
        }*/

        controlButtons = new ArrayList<>(names.size());
        initializeControlButtons(names);

        /*for (int i = 0; i<names.size(); i++){
            controlButtons.add(new ControlButtons(names.get(i)));
        }*/

        /*int sizeI;
        int i = 0;

        for (List list : gameButtons) {
            for (GameButtons but : gameButtons.get(i)) {
                sizeI = list.size();
                if (i < sizeI){
                    but = new GameButtons();
                //    gameButtons.get(i).add(new GameButtons());
                }
                i++;
            }
            i = 0;
        }*/

        gameButtons = new ArrayList<>();
        initializeGameButtons(size);

        /*for (int i = 0; i<size; i++){
            gameButtons.add(new ArrayList<GameButtons>());
                for (int j = 0; j<size; j++) {
                    gameButtons.get(i).add(new GameButtons());
                }
        }*/

        titlePanel = new TitlePanel(this);
        titlePanel.setPreferredSize(new Dimension(frameWidth, frameHeight / 12));

        gamePanel = new GamePanel();
        gamePanel.setPreferredSize(new Dimension(frameWidth, frameHeight * 7 / 12));

        buttonsPanel = new ButtonsPanel(this, controlButtons);
        buttonsPanel.setPreferredSize(new Dimension(frameWidth, frameHeight * 2 / 12));

        customFont = getCustomFont();

        Dimension frameDim = new Dimension(frameWidth, frameHeight);
        this.setSize(frameDim);
        //    this.setMinimumSize(frameDim);

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
        this.add(buttonsPanel, GBC);

        Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        titlePanel.setBorder(raisedetched);
        gamePanel.setBorder(raisedetched);
        buttonsPanel.setBorder(raisedetched);

        titlePanel.setVisible(true);
        gamePanel.setVisible(true);
        buttonsPanel.setVisible(true);

        this.setVisible(true);

        runGameBool = true;

        gameEngine = new GameEngine(size, controlButtons, gameButtons, gamePanel, runGameBool);
        gameEngine.initialize(gameButtons);
        gameEngine.runGame(gamePanel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

