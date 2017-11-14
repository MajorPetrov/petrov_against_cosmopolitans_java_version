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
package game.resources;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 *
 * @author <a href=mailto:razdobreevvlad@yandex.ru> Vladimir Razdobreev </a>
 */
public class Images {
	
	public static BufferedImage[] background;
	public static BufferedImage[] blocks;
	
	public Images() {
		background = new BufferedImage[1];
		blocks = new BufferedImage[3];
		
		try {
			background[0] = ImageIO.read(this.getClass().getResourceAsStream("/images/BG/BG.png"));
			blocks[0] = ImageIO.read(this.getClass().getResourceAsStream("/images/Tiles/1.png"));
			blocks[1] = ImageIO.read(this.getClass().getResourceAsStream("/images/Tiles/2.png"));
			blocks[2] = ImageIO.read(this.getClass().getResourceAsStream("/images/Tiles/3.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
