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
package game.items;

/**
 * this class represents weapons that Major Petrov can use
 * @author <a href=mailto:razdobreevvlad@yandex.ru> Vladimir Razdobreev </a>
 */
public abstract class Weapon implements Item {
    
    protected String name;
    protected int powerPoints;
    protected int ammo;
    
    /**
     * A weapon is represented by its power and its ammo
     * @param name the name of weapon
     * @param powerPoints destruction capacity
     * @param ammo times you can use it
     */
    public Weapon(String name, int powerPoints, int ammo) {
        this.name = name;
        this.powerPoints = powerPoints;
        this.ammo = ammo;
    }
    
    /**
     * give the weapon power
     * @return int as power points
     */
    public int getPower() {
        return this.powerPoints;
    }
    
    /**
     * give the remaining ammunition
     * @return int as number of ammunition
     */
    public int getAmmo() {
        return this.ammo;
    }
    
    /**
     * add a number of ammunition giver by parameter
     * @param number of ammunition
     */
    public void addAmmo(int number) {
        this.ammo += number;
    }
    
    /**
     * return the weapon's name
     * @return
     */
    @Override
    public String toString() {
        return this.name;
    }
}
