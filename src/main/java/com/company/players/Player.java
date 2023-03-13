package com.company.players;

import com.company.weapon.Weapon;

public abstract class Player<T extends Weapon>{
    protected String name;
    protected int health;
    protected T weapon;
    protected int moves = 0;
    protected String creature;

    public Player(String name, int health) {
        this.name = name;
        this.health = health;
        setWeapon();
    }

    public String getName() {
        return this.name;
    }

    public void setMoves() {
        moves ++;
        System.out.println(moves);
    }

    public int getMoves() {
        return this.moves;
    }

    public int getHealth() {
        return this.health;
    }

    public T getWeapon() {
        return weapon;
    }

    public String getCreature() {
        return this.creature;
    }

    abstract public void setWeapon();

    abstract public void setHealth(int health);

    abstract public int getDamage(int damageFromHit);

    abstract public int amountOfMadeDamage();

}
