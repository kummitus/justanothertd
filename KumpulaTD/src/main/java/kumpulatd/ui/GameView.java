/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import kumpulatd.logic.Ammunition;
import kumpulatd.logic.Enemy;
import kumpulatd.logic.Game;
import kumpulatd.logic.Tower;

/**
 *
 * @author antti
 */
public class GameView extends JPanel implements ActionListener {

    private Game game;
    private int frame;

    public GameView() {
        game = new Game();
        frame = 0;
        //gameLoop();

        Timer timer = new Timer(16, this);
        timer.start();


    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        drawBackGround(g2d);

        game.update(frame);

        List<Enemy> enemies = game.getEnemies();
        List<Tower> towers = game.getTowers();
        List<Ammunition> ammunition = game.getAmmunition();

        drawDrawables(enemies, towers, ammunition, g2d);

        drawFrameCounter(g2d);
    }

    public void drawBackGround(Graphics2D g2d) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src/main/resources/background.png"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Eggs are not supposed to be green.",
                    "No gamefield was found",
                    JOptionPane.ERROR_MESSAGE);
        }
        g2d.drawImage(img, null, 0, 0);
    }

    public void drawFrameCounter(Graphics2D g2d) {
        String frametostring = "" + frame;
        g2d.drawString(frametostring, 10, 10);
        frame++;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    private void drawDrawables(List<Enemy> enemies, List<Tower> towers, List<Ammunition> ammunition, Graphics2D g2d) {
        for (Enemy e : enemies) {
            for (Enemy ee : e.getMembers()) {
                g2d.drawImage(ee.getImg(), null, ee.getX(), ee.getY());
            }
        }

        for (Tower e : towers) {
            g2d.drawImage(e.getImg(), null, e.getX(), e.getY());
        }

        for (Ammunition e : ammunition) {
            g2d.drawImage(e.getImg(), null, e.getX(), e.getY());
        }

    }

}
