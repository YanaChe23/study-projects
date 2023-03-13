package com.company.weapon;

public  class Weapon {
    public String name;
    public int damage;

    public  Weapon(String name, int damage) {
        this.name =  name;
        this.damage = damage;
    }

    public int makeDamage(){
        return this.damage;
    }

}
