package mypack;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

/**
 * @author Jakub Jaskulski
 * @version 1.0
 * @since 29.10.18
 *
 *        Contains frame's scheme. Creates customFont.
 *
 */

public class Scheme extends JFrame {

    private Title titlePanel;
    private Buttons buttonsPanel;
    private Game gamePanel;

    private Font customFont;
    private int frameWidth;
    private int frameHeight;

    public Font getCustomFont() {
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("font/visitor1.ttf")).deriveFont(44f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("font/visitor1.ttf")));
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

        titlePanel = new Title(this);
        titlePanel.setPreferredSize(new Dimension(frameWidth, frameHeight/12));

        gamePanel = new Game(this);
        gamePanel.setPreferredSize(new Dimension(frameWidth, frameHeight*7/12));


        buttonsPanel = new Buttons(this, gamePanel);
        buttonsPanel.setPreferredSize(new Dimension(frameWidth, frameHeight*2/12));

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

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

}

