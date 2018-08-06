package hell.controller;

import hell.factories.HeroFactory;
import hell.factories.ItemFactory;
import hell.factories.RecipeFactory;
import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.Manager;
import hell.interfaces.Recipe;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.*;

public class CommandManager implements Manager {

    private Map<String, Hero> heroes;

    CommandManager () {

        this.heroes = new LinkedHashMap<>();
    }

    @Override
    public void acceptData (String[] data) throws IllegalAccessException {

        String command = data[0];

        Hero hero = null;
        String heroName;
        String itemName;
        int itemStrength;
        int itemAgility;
        int itemIntelligence;
        int itemHitPoints;
        int itemDamage;

        switch (command) {
            case "Hero":
                hero = HeroFactory.createHero(data);
                if (hero != null) {
                    heroes.putIfAbsent(hero.getName(), hero);
                    System.out.printf("Created %s - %s%n", hero.getClass().getSimpleName(), hero.getName());
                }
                break;
            case "Item":
                // Item Knife Ivan 0 10 0 0 30

                itemName = data[1];
                heroName = data[2];
                itemStrength = Integer.parseInt(data[3]);
                itemAgility = Integer.parseInt(data[4]);
                itemIntelligence = Integer.parseInt(data[5]);
                itemHitPoints = Integer.parseInt(data[6]);
                itemDamage = Integer.parseInt(data[7]);

                hero = heroes.get(heroName);
                Item item = ItemFactory.create
                        (itemName, itemStrength, itemAgility, itemIntelligence, itemHitPoints, itemDamage);
                hero.addItem(item);
                System.out.printf("Added item - %s to Hero - %s%n", itemName, heroName);
                break;
            case "Recipe":
                itemName = data[1];
                heroName = data[2];
                itemStrength = Integer.parseInt(data[3]);
                itemAgility = Integer.parseInt(data[4]);
                itemIntelligence = Integer.parseInt(data[5]);
                itemHitPoints = Integer.parseInt(data[6]);
                itemDamage = Integer.parseInt(data[7]);

                List<String> requiredItems = getRequiredItems(data);

                Recipe recipe = RecipeFactory
                        .createRecipe(itemName, itemStrength, itemAgility, itemIntelligence, itemHitPoints, itemDamage,
                                requiredItems);

                hero = heroes.get(heroName);
                hero.addRecipe(recipe);
                System.out.printf("Added recipe - %s to Hero - %s%n", itemName, heroName);
                break;
            case "Inspect":
                //  Inspect Ivan
                heroName = data[1];
                hero = heroes.get(heroName);
                StringBuilder heroInspect = inspect(hero, heroName);
                System.out.print(heroInspect.toString());
                break;
            case "Quit":
                int index = 1;
                Map<String, Hero> sorted = new LinkedHashMap<>();

                heroes.entrySet().stream()
                        .sorted((h1, h2) -> h2.getValue().compareTo(h1.getValue()))
                        .forEachOrdered(x -> sorted.put(x.getKey(), x.getValue()));

                for (Entry<String, Hero> sortedMap : sorted.entrySet()) {
                    System.out.printf("%d. %s", index, sortedMap.getValue());
                    index++;
                }

                break;
        }
    }

    private List<String> getRequiredItems (String[] data) {

        List<String> requiredItems = new ArrayList<>();
        for (int i = 8; i < data.length; i++) {
            String requiredItem = data[i];
            requiredItems.add(requiredItem);
        }
        return requiredItems;
    }

    private StringBuilder inspect (Hero hero, String heroName) throws IllegalAccessException {

        StringBuilder heroInspect = new StringBuilder();
        heroInspect.append(String.format("Hero: %s, Class: %s", heroName, hero.getClass().getSimpleName()));
        heroInspect.append(System.lineSeparator());
        heroInspect.append(String.format("HitPoints: %d, Damage: %d", hero.getHitPoints(), hero.getDamage()));
        heroInspect.append(System.lineSeparator());
        heroInspect.append(String.format("Strength: %d", hero.getStrength()));
        heroInspect.append(System.lineSeparator());
        heroInspect.append(String.format("Agility: %d", hero.getAgility()));
        heroInspect.append(System.lineSeparator());
        heroInspect.append(String.format("Intelligence: %d", hero.getIntelligence()));
        heroInspect.append(System.lineSeparator());
        heroInspect.append("Items:");

        Collection<Item> heroItems = hero.getItems();
        if (heroItems.isEmpty()) {
            heroInspect.append(" None");
            heroInspect.append(System.lineSeparator());
        } else {
            for (Item heroItem : heroItems) {
                heroInspect.append(System.lineSeparator());
                heroInspect.append(String.format("###Item: %s", heroItem.getName()));
                heroInspect.append(System.lineSeparator());
                heroInspect.append(String.format("###+%d Strength", heroItem.getStrengthBonus()));
                heroInspect.append(System.lineSeparator());
                heroInspect.append(String.format("###+%d Agility", heroItem.getAgilityBonus()));
                heroInspect.append(System.lineSeparator());
                heroInspect.append(String.format("###+%d Intelligence", heroItem.getIntelligenceBonus()));
                heroInspect.append(System.lineSeparator());
                heroInspect.append(String.format("###+%d HitPoints", heroItem.getHitPointsBonus()));
                heroInspect.append(System.lineSeparator());
                heroInspect.append(String.format("###+%d Damage", heroItem.getDamageBonus()));
                heroInspect.append(System.lineSeparator());
            }
        }
        return heroInspect;
    }

}
