package com.company.weapon;


import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlasterTest {
    Blaster blaster = new Blaster();

    @Test
    public void testName(){
        assertEquals(blaster.name, "Blaster");
    }

    @Test
    public void testDamage(){
        assertEquals(blaster.damage, 30);
    }

    @Test
    public void testMakeDamage(){
        assertEquals(blaster.makeDamage(), 30);
    }
}
