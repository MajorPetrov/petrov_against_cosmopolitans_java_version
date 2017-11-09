/*
 * Copyright (C) 2017 <a href=mailto:razdobreevvlad@yandex.ru> Vladimir Razdobreev </a>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;

/**
 *
 * @author <a href=mailto:razdobreevvlad@yandex.ru> Vladimir Razdobreev </a>
 */
public class GamePanel extends JPanel implements Runnable, KeyListener {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 550;
    private static final int FPS = 60;
    private static final long targetTime = 1000 / FPS;
    
    private Thread thread;
    private boolean isRunning;
    
    public GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.start();
    }
    
    private void start() {
        this.isRunning = true;
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {
        long start, elapsed, wait;
        
        while(this.isRunning) {
            start = System.nanoTime();
            
            tick();
            repaint();
            
            elapsed = System.nanoTime() - start;
            wait = targetTime - elapsed / 1000000;
            
            //if if down to 60fps, we need to sleep the thread
            if(wait <= 0) {
                wait = 5;
            }
            
            try {
                thread.sleep(wait); //if it's static -> Thread
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * updating all game logic
     */
    public void tick() {
        System.out.println("running");
    }
    
    /**
     * to draw graphics
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawRect(10, 10, 10, 10);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
