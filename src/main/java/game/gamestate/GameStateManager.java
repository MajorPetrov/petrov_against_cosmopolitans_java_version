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
import java.awt.Graphics2D;
import java.util.*;

/**
 *
 * @author <a href=mailto:razdobreevvlad@yandex.ru> Vladimir Razdobreev </a>
 */
public class GameStateManager {
    private List<GameState> gameStates;
    private int currentState;
    
    public static final int MENUSTATE = 0;
    public static final int LEVEL1STATE = 1;
    
    public GameStateManager() {
        this.gameStates = new ArrayList<GameStates>();
        this.currentState = MENUSTATE;
        this.gameStates.add(new MenuState(this));
    }
    
    public void setState(int state) {
        this.currentState = state;
        this.gameStates.get(currentState);
    }
    
    public void update() {
        this.gameStates.get(currentState).update();
    }
    
    public void draw(Graphics2D g) {
        this.gameStates.get(currentState).draw(g);
    }
    
    public void keyPressed(int k) {
        this.gameStates.get(currentState).keyPressed(k);
    }
    
    public void keyReleased(int k) {
        this.gameStates.get(currentState).keyReleased(k);
    }
}
