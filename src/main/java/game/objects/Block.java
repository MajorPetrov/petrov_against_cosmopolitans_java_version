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
import game.resources.Images;

/**
 * 
 * @author <a href=mailto:razdobreevvlad@yandex.ru> Vladimir Razdobreev </a>
 */
public class Block extends Rectangle {
	
	private static final long serialVersionUID = 1L;
	public static final int blockSize = 60;
	private int id;
	
	public Block(int x, int y, int id) {
		this.setBounds(x, y, blockSize, blockSize);
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void tick() {
		//TODO
	}
	
	public void draw(Graphics g) {
		if(this.id != 0) {
			g.drawImage(Images.blocks[id - 1], x - (int)GameState.xOffset, y - (int)GameState.yOffset,
					this.width, this.height, null);
		}
	}
}
