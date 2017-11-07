/*
 * Copyright (C) 2017 Vladimir Razdobreev <a href=mailto:razdobreevvlad@yandex.ru> Vladimir Razdobreev </a>
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
package game.characters;
import game.items.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <a href=mailto:razdobreevvlad@yandex.ru> Vladimir Razdobreev </a>
 */
public class Petrov extends Character {
    
    private int numberVictims;
    private List<Weapon> weapons;
    
    public Petrov() {
        super(5, 1, "Major Petrov");
        this.numberVictims = 0;
        this.weapons = new ArrayList();
    }
    
    int getNumberVictims() {
        return this.numberVictims;
    }
    
    /**
     * give all weapons transported by Petrov
     * @return List<Weapon> Petrov's weapons
     */
    List<Weapon> getWeapons() {
        return this.weapons;
    }
    
    /**
     * add a victim to Petrov's counter
     */
    void increaseVictims() {
        this.numberVictims++;
    }
    
    /**
     * add a weapon to Petrov's arsenal
     * @param weapon the gu  to add
     */
    void addWeapon(Weapon weapon) {
        this.weapons.add(weapon);
    }
    
    /**
     * the major picks up ammo for weapon given by parameter
     * @param weapon the weapon to reload
     * @param quantity of ammo to add
     */
    void addAmmo(Weapon weapon, int quantity) {
        int index = this.weapons.indexOf(weapon);
        this.weapons.get(index).addAmmo(quantity);
    }
    
    void use(Weapon weapon, Character character) {
        int index = this.weapons.indexOf(weapon);
        if(this.weapons.get(index).getPower() < character.getLife()) {
            character.decreaseLife(this.weapons.get(index).getPower());
        }
        else {
            character.decreaseLife(character.getLife());
        }
    }
}
