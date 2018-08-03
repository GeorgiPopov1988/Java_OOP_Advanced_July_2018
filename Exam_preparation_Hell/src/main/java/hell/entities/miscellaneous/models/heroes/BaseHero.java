package hell.entities.miscellaneous.models.heroes;

import hell.annotations.ItemCollection;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public abstract class BaseHero implements Hero {

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;

    private Inventory inventory;

    protected BaseHero (String name, int strength, int agility, int intelligence, int hitPoints, int damage,
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

        return this.strength;
    }

    @Override
    public long getAgility () {

        return this.agility;
    }

    @Override
    public long getIntelligence () {

        return this.intelligence;
    }

    @Override
    public long getHitPoints () {

        return this.hitPoints;
    }

    @Override
    public long getDamage () {

        return this.damage;
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
        return new ArrayList<Item> (commonItems.values());
    }

    @Override
    public void addItem (Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe (Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }
}
