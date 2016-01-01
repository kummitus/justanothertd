/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kumpulatd.ui;

import java.awt.Color;
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
    private char nextCommand;
    private int currentTower;
    private Timer timer;

    public GameView() {
        game = new Game();
        frame = 0;
        currentTower = '1';
        nextCommand = ' ';
        timer = new Timer(16, this);
        timer.start();
    }
    
    public void stopTimer(){
        timer.stop();
        timer.removeActionListener(this);
        
    }

    public void setNextCommand(char command) {
        nextCommand = command;
    }

    public Game getGame() {
        return game;
    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        drawBackGround(g2d);

        game.update(frame, this);
        
        List<Enemy> enemies = game.getEnemies();
        List<Tower> towers = game.getTowers();
        List<Ammunition> ammunition = game.getAmmunition();
        
        drawDrawables(enemies, towers, ammunition, g2d);

        drawFrameCounter(g2d);

        infoDraw(g2d);

        drawGoal(g2d);
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
        g2d.setBackground(Color.white);
        g2d.setColor(Color.white);
        g2d.fillRect(1000, 0, 400, 800);
        g2d.setColor(Color.black);
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
            g2d.drawImage(e.getImg(), null, e.getLocation().getX(), e.getLocation().getY());
        }

        for (Ammunition e : ammunition) {
            g2d.drawImage(e.getImg(), null, e.getX(), e.getY());
        }
    }

    private void infoDraw(Graphics2D g2d) {
        int x = 1025;
        int y = 50;
        for (String row : game.getInfoString()) {
            g2d.drawString(row, x, y);
            y += 12;
        }
        g2d.drawString(currentTower + "asdasdas", x + 50, y + 50);
        try {
            currentTower = Integer.parseInt(nextCommand + "");
        } catch (Exception e) {

        }

        if (nextCommand != ' ') {
            if (currentTower == '1' || currentTower == '2' || currentTower == '3' || currentTower == '4') {
                drawSelectedTower(currentTower, g2d, x, y);
                nextCommand = ' ';
            } else if (nextCommand == 'b') {
                game.buyTower(currentTower, nextCommand);
                nextCommand = ' ';
            } else if (nextCommand == 's') {
                game.sellTower(currentTower, nextCommand);
                nextCommand = ' ';
            }
        }
    }

    private void drawSelectedTower(int currentTower, Graphics2D g2d, int x, int y) {
        y += 24;

        if (currentTower == 1 && !game.getTowers().isEmpty()) {
            g2d.drawImage(game.getTowers().get(0).getImg(), null, x, y);
            g2d.drawString(game.getTowers().get(0).getName(), x, y);
            y += 12;
            g2d.drawString(game.getTowers().get(0).damage() + "", x, y);
            y += 12;
            g2d.drawString(currentTower + " ", x, y);
        }

        if (currentTower == 2 && game.getTowers().size() >= 2) {
            g2d.drawImage(game.getTowers().get(0).getImg(), null, x, y);
            g2d.drawString(game.getTowers().get(1).getName(), x, y);
            y += 12;
            g2d.drawString(game.getTowers().get(1).damage() + "", x, y);
        }

        if (currentTower == 3 && game.getTowers().size() >= 3) {
            g2d.drawImage(game.getTowers().get(0).getImg(), null, x, y);
            g2d.drawString(game.getTowers().get(2).getName(), x, y);
            y += 12;
            g2d.drawString(game.getTowers().get(2).damage() + "", x, y);
        }

        if (currentTower == 4 && game.getTowers().size() >= 4) {
            g2d.drawImage(game.getTowers().get(0).getImg(), null, x, y);
            g2d.drawString(game.getTowers().get(3).getName(), x, y);
            y += 12;
            g2d.drawString(game.getTowers().get(3).damage() + "", x, y);
        }

    }

    private void drawGoal(Graphics2D g2d) {
        g2d.drawImage(game.getGoal().getImg(), null, game.getGoal().getX() - 40, game.getGoal().getY() - 40);
    }

}
