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

import java.awt.Graphics;
import java.util.Stack;

/**
 *
 * @author <a href=mailto:razdobreevvlad@yandex.ru> Vladimir Razdobreev </a>
 */
public class GameStateManager {
    private Stack<GameState> states;
    
    public GameStateManager() {
        this.states = new Stack<GameState>();
        this.states.push(new MenuState(this));
    }
    
    public void tick() {
        this.states.peek().tick(); //look at the object at the top of this stack without removing it from the stack
    }
    
    public void draw(Graphics g) {
        this.states.peek().draw(g);
    }
    public void keyPressed(int ke) {
        this.states.peek().keyPressed(ke);
    }

    public void keyReleased(int ke) {
        this.states.peek().keyReleased(ke);
    }
}
