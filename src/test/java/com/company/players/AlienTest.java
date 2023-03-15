package com.company.players;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
