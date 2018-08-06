package hell.entities.miscellaneous.models.heroes;

import hell.annotations.ItemCollection;
import hell.entities.miscellaneous.HeroInventory;
import hell.factories.InventoryFactory;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public abstract class BaseHero implements Hero, Comparable<Hero> {

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;

    private Inventory inventory;

    protected BaseHero (String name, int strength, int agility, int intelligence, int hitPoints, int damage) {

        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = InventoryFactory.createHeroInventory();
    }

    @Override
    public String getName () {

        return this.name;
    }

    @Override
    public long getStrength () {

        return this.strength + inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility () {

        return this.agility + inventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence () {

        return this.intelligence + inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints () {

        return this.hitPoints + inventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage () {

        return this.damage + inventory.getTotalDamageBonus();
    }

    @Override
    public long getCompareOneSum () {

        return this.getStrength() + this.getAgility() + this.getIntelligence();
    }

    @Override
    public long getCompareTwoSym () {

        return this.getHitPoints() + this.getDamage();

    }

    @Override
    public Collection<Item> getItems () throws IllegalAccessException {

        Map<String, Item> commonItems = null;
        Class<? extends Inventory> aClass = this.inventory.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(ItemCollection.class)) {
                declaredField.setAccessible(true);
                commonItems = (Map<String, Item>) declaredField.get(this.inventory);
            }
        }
        return new ArrayList<Item>(commonItems.values());
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
    public int compareTo (Hero other) {
        int result = Integer.compare((int) this.getCompareOneSum(), (int) other.getCompareOneSum());

        if (result != 0) {
            return result;
        } else {
            result = Integer.compare((int) this.getCompareTwoSym(), (int)other.getCompareTwoSym());
            return result;
        }
    }

    @Override
    public String toString () {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%s: %s", this.getClass().getSimpleName(), this.getName()));
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(String.format("###HitPoints: %d", this.getHitPoints()));
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(String.format("###Damage: %d", this.getDamage()));
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(String.format("###Strength: %d", this.getStrength()));
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(String.format("###Agility: %d", this.getAgility()));
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(String.format("###Intelligence: %d", this.getIntelligence()));
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("###Items: ");

        //Collection<Item> items = this.getItems();
        try {
            if (! this.getItems().isEmpty()) {
                String prefix = "";
                for (Item heroItem : this.getItems()) {
                    stringBuilder.append(prefix);
                    stringBuilder.append(heroItem.getName());
                    prefix = ", ";
                }
                stringBuilder.append(System.lineSeparator());
            } else {
                stringBuilder.append("None");
                stringBuilder.append(System.lineSeparator());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

}


