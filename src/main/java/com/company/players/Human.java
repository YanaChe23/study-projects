package com.company.players;

import com.company.armours.Armour;
import com.company.weapon.Knife;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Human extends Player {

    private List<Armour> armour = new ArrayList<>();
    private int protection;


    public Human(String name) {
        super(name, 100);
        this.creature = "Human";
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
    public int getDamage(int damageFromHit) {
        this.health -= damageFromHit;
        return damageFromHit;
    }

    @Override
    public int amountOfMadeDamage(){
      return this.weapon.damage;
    }

    public void setArmour() {

        Armour helmet = new Armour("Helmet", 10, 100);
        Armour  cuffs = new Armour("Cuffs", 5, 100);

        List<Armour> availableArmour = new ArrayList<>();
        availableArmour.add(helmet);
        availableArmour.add(cuffs);

        if (this.armour.size() < availableArmour.size()) {
            Random random = new Random();
            if (random.nextInt()  % 2 == 0) {
                int index = random.nextInt(availableArmour.size());
                Armour foundArmour = availableArmour.get(index);
                if (this.armour.indexOf(foundArmour) < 0) {
                    this.armour.add(foundArmour);
                }
            }
        }
    }

    public  void setProtection() {
        int protection = 0;
        for (Armour piece:this.armour) {
            protection += piece.protection;
        }
        this.protection = protection;
    }

    public int getProtection(){
        return this.protection;
    }

    public void getArmourInfo(){
        if (this.armour.size() != 0) {
            System.out.println("Available armour:");
            this.armour.forEach(
                    (arm) -> System.out.println(arm.protection  + ": protection level - "  + arm.protection
                            + ", armour damage level: " + arm.levelOfDamage +  ".")
            );ªª
        }

    }
}
