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
package game.characters;

/**
 * modeling a character which will move in the game
 * @author <a href=mailto:razdobreevvlad@yandex.ru> Vladimir Razdobreev </a>
 */
public abstract class Character {
    
    protected int lifePoints;
    protected int powerPoints;
    protected String name;
    
    /**
     * constructor for Character class. A character has always these attributes:
     * @param lifePoints character's life
     * @param powerPoints character's power
     * @param name character's name
     */
    public Character(int lifePoints, int powerPoints, String name) {
        this.lifePoints = lifePoints;
        this.powerPoints = powerPoints;
        this.name = name;
    }
    
    /**
     * allows to know life quantity of the character
     * @return int as life points
     */
    int getLife() {
        return this.lifePoints;
    }
    
    /**
     * allows to know power quantity of the character
     * @return int as power points
     */
    int getPower() {
        return this.powerPoints;
    }
    
    /**
     * allows to know the name of the character
     * @return String as name
     */
    String getName() {
        return this.name;
    }
    
    /**
     * removes a number of points passed by parameter
     * @param points 
     */
    void decreaseLife(int points) {
        this.lifePoints -= points;
    }
    
    /**
     * the character attack an other character, and decrease his life points
     * @param character the character to attack
     */
    void attack(Character character) {
        if(this.getPower() < character.getLife()) {
            character.decreaseLife(this.getPower());
        }
        else {
            character.decreaseLife(character.getLife());
        }
    }
}
