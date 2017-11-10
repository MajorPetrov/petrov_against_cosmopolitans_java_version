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
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author <a href=mailto:razdobreevvlad@yandex.ru> Vladimir Razdobreev </a>
 */
public class Player {
    //movement booleans
    private boolean left = false, right = false, jumping = false, falling = false;
    
    //bounds
    private double x, y;
    private int width, height;
    
    //jump speed
    private double jumpSpeed = 5;
    private double currentJumpSpeed = jumpSpeed;
    
    //fall speed
    private double maxFallSpeed = 5;
    private double currentFallSpeed = 0.1;
    
    public Player(int width, int height) {
        this.x = GamePanel.WIDTH / 2;
        this.y = GamePanel.HEIGHT / 2;
        this.width = width;
        this.height = height;
    }
    
    public void tick() {
        if(this.right) {
            this.x++;
        }
        else if(this.left) {
            this.x--;
        }
        else if(this.jumping) {
            this.y -= this.currentJumpSpeed;
            this.currentJumpSpeed -= 0.1;
            
            //if the jump energy is over, we reset the jump speed
            if(this.currentJumpSpeed <= 0) {
                this.currentJumpSpeed = this.jumpSpeed;
                this.jumping = false;
                this.falling = true;
            }
        }
        else if(this.falling) {
            this.y += this.currentFallSpeed;
            
            if(this.currentFallSpeed < this.maxFallSpeed) {
                this.currentFallSpeed += 0.1;
            }
        }
        else if(!this.falling) {
            this.currentFallSpeed = 0.1;
        }
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect((int)x, (int)y, width, height);
    }
    
    public void keyPressed(int ke) {
        switch (ke) {
            case KeyEvent.VK_RIGHT:
                this.right = true;
                break;
            case KeyEvent.VK_LEFT:
                this.left = true;
                break;
            case KeyEvent.VK_SPACE:
                this.jumping = true;
                break;
            default:
                break;
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
