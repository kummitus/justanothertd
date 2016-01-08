/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.kumpulatd.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Listens for user keyboard input
 * @author kummi
 */
class KeyListenerGame implements KeyListener{
    private GameView game;
    
    public KeyListenerGame(GameView game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        game.setNextCommand(e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
}
