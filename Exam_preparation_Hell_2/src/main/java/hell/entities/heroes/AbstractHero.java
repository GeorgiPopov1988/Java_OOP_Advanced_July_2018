package hell.entities.heroes;

import hell.annotations.ItemCollection;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractHero implements Hero {

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;

    private Inventory inventory;

    AbstractHero (String name, int strength, int agility, int intelligence, int hitPoints,
                  int damage,
                  Inventory inventory) {

        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = inventory;
    }

    @Override
    public String getName () {

        return this.name;
    }

    @Override
    public long getStrength () {

        return this.strength + this.inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility () {

        return this.agility + this.inventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence () {

        return this.intelligence + this.inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints () {

        return this.hitPoints + this.inventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage () {

        return this.damage + this.inventory.getTotalDamageBonus();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Item> getItems () {
        // TODO with reflection
        Collection<Item> items = null;

        Class<?> aClass = this.inventory.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();

        for (Field declaredField : declaredFields) {

            if (declaredField.isAnnotationPresent(ItemCollection.class)) {
                declaredField.setAccessible(true);

                Map<String, Item> map = null;
                try {
                    map = (Map<String, Item>) declaredField.get(this.inventory);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                items = map.values();
            }
        }
        return items;
    }

    @Override
    public void addItem (Item item) {

        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe (Recipe recipe) {

        this.inventory.addRecipeItem(recipe);
    }

    @Override
    public String toString () {
        StringBuilder heroPrint = new StringBuilder();

        String items = this.getItems().size() == 0 ?
                " None" :
                System.lineSeparator() + this.getItems()
                        .stream()
                        .map(Item::toString)
                        .collect(Collectors.joining(System.lineSeparator()));

        //Hero: {heroName}, Class: {heroType}
        heroPrint.append(String.format("Hero: %s, Class: %s", this.getName(), this.getClass()
                .getSimpleName()));
        heroPrint.append(System.lineSeparator());

        //HitPoints: {hitpoints}, Damage: {damage}
        heroPrint.append(String.format("HitPoints: %d, Damage: %d", this.getHitPoints(), this
                .getDamage()));
        heroPrint.append(System.lineSeparator());

        //Strength: {strength}
        heroPrint.append(String.format("Strength: %d", this.getStrength()));
        heroPrint.append(System.lineSeparator());

        //Agility: {agility}
        heroPrint.append(String.format("Agility: %d", this.getAgility()));
        heroPrint.append(System.lineSeparator());

        //Intelligence: {intelligence}
        heroPrint.append(String.format("Intelligence: %d", this.getIntelligence()));
        heroPrint.append(System.lineSeparator());

        //Items:
        heroPrint.append(String.format("Items:%s", items));
        //###Item: {item1Name}
        //###+{strengthBonus} Strength
        //###+{agilityBonus} Agility
        //###+{intelligenceBonus} Intelligence
        //###+{hitpointsBonus} HitPoints
        //###+{damageBonus} Damage
        //###Item: {item2Name}

        return heroPrint.toString();
    }
}
