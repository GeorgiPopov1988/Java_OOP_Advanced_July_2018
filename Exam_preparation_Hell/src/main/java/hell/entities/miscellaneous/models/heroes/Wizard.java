package hell.entities.miscellaneous.models.heroes;

import hell.interfaces.Inventory;

public class Wizard extends BaseHero {

    public Wizard (String name, int strength, int agility, int intelligence, int hitPoints, int damage, Inventory inventory) {

        super(name, strength, agility, intelligence, hitPoints, damage, inventory);
    }
}
