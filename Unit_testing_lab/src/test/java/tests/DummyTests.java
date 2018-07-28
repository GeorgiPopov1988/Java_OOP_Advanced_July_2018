package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class DummyTests {

    private static final int ONE = 1;

    private static final int TEN = 10;

    private static final int ELEVEN = 11;

    private Axe axe;

    @Before
    public void createAxe ( ) {

        this.axe = new Axe(TEN, TEN);
    }

    @Test
    public void targetLoseHealthAfterAttack ( ) {

        Dummy dummy = new Dummy(ELEVEN, TEN);

        this.axe.attack(dummy);

        Assert.assertEquals("Target no lose health after attack.", 1, dummy.getHealth( ));
    }

    @Test (expected = IllegalStateException.class)
    public void deadDummyThrowException ( ) {

        Dummy dummy = new Dummy(TEN, TEN);

        this.axe.attack(dummy);
        this.axe.attack(dummy);

    }

    @Test
    public void deadTargetCanGiveXP ( ) {

        Dummy dummy = new Dummy(TEN, TEN);

        this.axe.attack(dummy);

        Assert.assertEquals("Dead target no give XP.", 10, dummy.giveExperience( ));
    }

    @Test (expected = IllegalStateException.class)
    public void aliveTargetCantGiveXP ( ) {

        Dummy dummy = new Dummy(ELEVEN, TEN);

        this.axe.attack(dummy);
        dummy.giveExperience( );
    }


}
