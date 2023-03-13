package com.company.players;

import org.junit.Ignore;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class AlienTest {
    Alien alien = new Alien("Tom");

    @Test
    public void testSetHealth() {
        assertEquals(alien.health, 110);
    }

    @Test
    public void testCheckWeapon() {
        alien.setWeapon();
        assertEquals(alien.weapon.name, "Knife" );
    }

    @Ignore
    public void testMagicHealing() {
        //
    }
}
