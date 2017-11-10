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
package game.entities;

import game.main.GamePanel;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 *
 * @author <a href=mailto:razdobreevvlad@yandex.ru> Vladimir Razdobreev </a>
 */
public class Player extends Rectangle {
    private boolean left, right;
    
    public Player(int width, int height) {
        this.setBounds(GamePanel.WIDTH / 2, GamePanel.HEIGHT /2, width, height);
        this.left = false;
        this.right = false;
    }
    
    public void tick() {
        if(this.right) {
            this.x++;
        }
        else if(this.left) {
            this.x--;
        }
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, width, height);
    }
    
    public void keyPressed(int ke) {
        if(ke == KeyEvent.VK_RIGHT) {
            this.right = true;
        }
        else if(ke == KeyEvent.VK_LEFT) {
            this.left = true;
        }
    }
    
    public void keyReleased(int ke) {
        if(ke == KeyEvent.VK_RIGHT) {
            this.right = false;
        }
        else if(ke == KeyEvent.VK_LEFT) {
            this.left = false;
        }
    }
}
