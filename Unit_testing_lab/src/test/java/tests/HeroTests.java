package tests;

import interfaces.Target;
import interfaces.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Hero;

public class HeroTests {

    public static final int ATTACK_POINT = 10;

    public static final int WEAPON_DURABILITY = 10;

    public static final int TARGET_HEALTH = 10;

    public static final int TARGET_XP = 10;

    public static final String HERO_NAME = "Hero";


    private Weapon weapon;

    private Target target;

    @Before
    public void createWeaponAndTarget ( ) {

        this.weapon = new Weapon( ) {

            public void attack (Target target) {

                target.giveExperience( );
            }

            public int getAttackPoints ( ) {

                return ATTACK_POINT;
            }

            public int getDurabilityPoints ( ) {

                return WEAPON_DURABILITY;
            }
        };

        this.target = new Target( ) {

            public void takeAttack (int attackPoints) {

            }

            public int getHealth ( ) {

                return TARGET_HEALTH;
            }

            public int giveExperience ( ) {

                return TARGET_XP;
            }

            public boolean isDead ( ) {

                return true;
            }
        };
    }

    @Test
    public void heroGainstXP ( ) {

        Hero hero = new Hero(HERO_NAME, this.weapon);
        hero.attack(this.target);

        Assert.assertEquals(hero.getExperience( ), TARGET_XP);
    }

    @Test
    public void attackGainsExpirienceIfTargetIsDead ( ) {

        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);

        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_XP);

        Hero hero = new Hero(HERO_NAME, weaponMock);

        hero.attack(targetMock);

        Assert.assertEquals("Wrong expirience", TARGET_XP, hero.getExperience());

    }
}