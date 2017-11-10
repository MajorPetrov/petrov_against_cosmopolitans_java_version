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

import game.entities.Player;
import java.awt.Graphics;

/**
 *
 * @author <a href=mailto:razdobreevvlad@yandex.ru> Vladimir Razdobreev </a>
 */
public class Level1State extends GameState {
    
    private Player player;
    
    public Level1State(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        this.player = new Player(30, 30);
    }

    @Override
    public void tick() {
        this.player.tick();
    }

    @Override
    public void draw(Graphics g) {
        this.player.draw(g);
    }

    @Override
    public void keyPressed(int ke) {
        this.player.keyPressed(ke);
    }

    @Override
    public void keyReleased(int ke) {
        this.player.keyReleased(ke);
    }
}
