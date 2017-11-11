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
package game.physics;

import java.awt.Point;

import game.objects.Block;

/**
 *
 * @author <a href=mailto:razdobreevvlad@yandex.ru> Vladimir Razdobreev </a>
 */
public class Collision {
	public static boolean playerBlock(Point p, Block b) {
		return b.contains(p); //if this point (which will be on the player) is inside the block, it returns true
	}
}
