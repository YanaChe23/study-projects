package com.company.players;

import org.junit.Test;

import static org.junit.Assert.*;

public class HumanTest {

    Human solder = new Human("Bob");

    @Test
    public void testSetHealth() {
        assertEquals(solder.health, 100);
    }

    @Test
    public void testCheckWeapon() {
        solder.setWeapon();
        assertEquals(solder.weapon.name, "Knife" );
    }

//    @Test
//    public void makeAMove() {
//
//    }


    @Test
    public void testProtection() {
        solder.setProtection();
        assertEquals(solder.getProtection(), 0);
    }
}