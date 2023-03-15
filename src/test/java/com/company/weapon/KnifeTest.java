package com.company.weapon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnifeTest {

     Knife knife = new Knife();

     @Test
     public void testName(){
         assertEquals(knife.name, "Knife");
     }

     @Test
     public void testDamage() {
         assertEquals(knife.damage, 10);
     }

     @Test
     public void testMakeDamage(){
        assertEquals(knife.makeDamage(), 10);
    }

}
