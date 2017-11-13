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
package game.gamestate;

import game.main.GamePanel;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 *
 * @author <a href=mailto:razdobreevvlad@yandex.ru> Vladimir Razdobreev </a>
 */
public class MenuState extends GameState {
    private String[] options = {"Start", "Help", "Quit"};
    private int currentSelection;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        this.currentSelection = 0;
    }

    @Override
    public void init() {
    	//TODO
    }

    @Override
    public void tick() {
    	//TODO
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
        
        for(int i = 0; i < this.options.length; i++) {
            if(i == this.currentSelection) {
                g.setColor(Color.GREEN);
            }
            else {
                g.setColor(Color.BLACK);
            }
            //g.drawLine(GamePanel.WIDTH / 2, 0, GamePanel.WIDTH / 2, GamePanel.HEIGHT);
            g.setFont(new Font("Arial", Font.PLAIN, 72));
            g.drawString(this.options[i], GamePanel.WIDTH / 2 - 75, 150 + i * 150);
        }
    }

    @Override
    public void keyPressed(int ke) {
        if(ke == KeyEvent.VK_DOWN) {
            this.currentSelection++;
            
            if(this.currentSelection == this.options.length) {
                this.currentSelection = 0;
            }
        }
        else if(ke == KeyEvent.VK_UP) {
            this.currentSelection--;
            
            if(this.currentSelection < 0) {
                this.currentSelection = this.options.length - 1;
            }
        }
        else if(ke == KeyEvent.VK_ENTER) {
            switch (this.currentSelection) {
                case 0:
                    this.gsm.getStates().push(new Level1State(gsm));
                    break;
                case 1:
                    break;
                case 2:
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    @Override
    public void keyReleased(int ke) {
    	//TODO
    }
    
}
