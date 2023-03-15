package com.company.players;

import com.company.weapon.Weapon;

public abstract class Player<T extends Weapon>{
    protected String name;
    protected int health;
    protected T weapon;
    protected int moves;
    protected String creatureType;

    public Player(String name, int health) {
        this.name = name;
        this.health = health;
        this.moves = 0;
        setWeapon();
    }

    public String getName() {
        return this.name;
    }

    public void setMoves() {
        moves ++;
    }

    public int getMoves() {
        return this.moves;
    }

    public int getHealth() {
        return this.health;
    }

    public String getCreatureType() {
        return this.creatureType;
    }

    abstract public void setWeapon();

    abstract public int getDamage(int damageFromHit);

    abstract public int amountOfMadeDamage();

}
