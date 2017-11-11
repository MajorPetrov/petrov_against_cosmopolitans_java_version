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

import game.gamestate.GameState;
import game.main.GamePanel;
import game.objects.Block;
import game.physics.Collision;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
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
    
    //move speed
    private double moveSpeed = 2.5;
    
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
    
    public void tick(Block[] b) {
    	int iX = (int) this.x;
    	int iY = (int) this.y;
    	
    	for(int i = 0; i < b.length; i++) {
    		//top-right or bottom-right corner of the player
    		if(Collision.playerBlock(new Point(iX + this.width, iY), b[i]) ||
    				Collision.playerBlock(new Point(iX + this.width, iY + height), b[i])) {
    			this.right = false;
    		}
    	}
        
    	if(this.right) {
            GameState.xOffset += this.moveSpeed;
        }
        
    	if(this.left) {
            GameState.xOffset -= this.moveSpeed;
        }
        
    	if(this.jumping) {
            GameState.yOffset -= this.currentJumpSpeed;
            this.currentJumpSpeed -= 0.1;
            
            //if the jump energy is over, we reset the jump speed
            if(this.currentJumpSpeed <= 0) {
                this.currentJumpSpeed = this.jumpSpeed;
                this.jumping = false;
                this.falling = true;
            }
        }
        
    	if(this.falling) {
        	GameState.yOffset += this.currentFallSpeed;
            
            if(this.currentFallSpeed < this.maxFallSpeed) {
                this.currentFallSpeed += 0.1;
            }
        }
        
    	if(!this.falling) {
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
