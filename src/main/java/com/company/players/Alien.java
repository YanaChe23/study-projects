package com.company.players;

import com.company.armours.Armour;
import com.company.weapon.Knife;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Alien extends Player {

    private List<Armour> armour = new ArrayList<>();

    public Alien(String name) {
        super(name, 110);
        this.creature = "Alien";
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void setWeapon() {
        this.weapon = new Knife();
    }

    @Override
    public void makeAMove() {
        System.out.println("Move");
    }

    @Override
    public int getDamage(int damageFromHit) {
        this.health -= damageFromHit;
        return damageFromHit;
    }

    @Override
    public int amountOfMadeDamage(){
        return this.weapon.damage;
    }

    public void magicHealing() {
        if (this.health < 110) {
            int random = new Random().nextInt();
            if (random  % 2 != 0) {
                // TODO увеличить на бросок кубика
                this.health += 6;
            }
        }
    }
}
