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
package game.mapping;

import java.awt.Graphics;

import game.objects.Block;

/**
 *
 * @author <a href=mailto:razdobreevvlad@yandex.ru> Vladimir Razdobreev </a>
 */
public class Map {
	
	private String path;
	private int width, height;
	private Block[][] blocks;
	
	public Map(String loadPath, int width, int height) {
		this.path = loadPath;
		this.width = width;
		this.height = height;
		this.blocks = new Block[height][width];
		
		for(int i = 0; i < this.blocks.length; i++) {
			for(int j = 0; j < this.blocks[0].length; j++) {
				this.blocks[i][j] = new Block(j * Block.blockSize, i * Block.blockSize);
			}
		}
	}
	
	public void draw(Graphics g) {
		for(int i = 0; i < this.blocks.length; i++) {
			for(int j = 0; j < this.blocks[0].length; j++) {
				this.blocks[i][j].draw(g);
			}
		}
	}
	
	public Block[][] getBlocks() {
		return this.blocks;
	}
}
