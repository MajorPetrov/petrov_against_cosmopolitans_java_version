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
package game.objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.gamestate.GameState;

/**
 * 
 * @author <a href=mailto:razdobreevvlad@yandex.ru> Vladimir Razdobreev </a>
 */
public class Block extends Rectangle {
	private static final long serialVersionUID = 1L;
	public static final int blockSize = 64;
	
	public Block(int x, int y) {
		this.setBounds(x, y, blockSize, blockSize);
	}
	
	public void tick() {
		//TODO
	}
	
	public void draw(Graphics g) {
		g.fillRect(x - (int)GameState.xOffset, y - (int)GameState.yOffset, this.width, this.height);
	}
}
