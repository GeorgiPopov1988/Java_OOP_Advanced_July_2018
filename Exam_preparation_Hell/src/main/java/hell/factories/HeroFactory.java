package hell.factories;

import hell.entities.miscellaneous.models.heroes.Assassin;
import hell.entities.miscellaneous.models.heroes.Barbarian;
import hell.entities.miscellaneous.models.heroes.Wizard;
import hell.interfaces.Hero;

public final class HeroFactory {

    private HeroFactory(){}

    public static Hero createHero (String[] data) {

        Hero hero = null;
        String heroName = data[1];
        String heroType = data[2];

        switch (heroType) {

            case "Barbarian":
                hero = new Barbarian(heroName);
                break;
            case "Assassin":
                hero = new Assassin(heroName);
                break;
            case "Wizard":
                hero = new Wizard(heroName);
                break;
                default:
                    return null;
        }

        return hero;
    }
}
