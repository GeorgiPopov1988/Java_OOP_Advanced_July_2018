package tests;

import org.junit.*;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {

    private static final int TEN = 10;

    private static final int ONE = 1;

    private Dummy dummy;
    private Axe axe;

    @Before
    public void createDummy ( ) {

        this.axe = new Axe(TEN, TEN);
        this.dummy = new Dummy(TEN, TEN);
    }


    @Test
    public void weaponAttackLosesDurability ( ) {
        // Arrange
        //Axe axe = new Axe(TEN, TEN);

        // Act
        this.axe.attack(this.dummy);

        // Assert
        Assert.assertEquals("After attack weapon no lose durability", 9, axe.getDurabilityPoints( ));
    }

    @Test (expected = IllegalStateException.class)
    public void brokenWeaponCantAttack ( ) {

        Axe axe = new Axe(TEN, ONE);

        axe.attack(this.dummy);
        axe.attack(this.dummy);
    }


}