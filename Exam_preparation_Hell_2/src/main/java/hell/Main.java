package hell;

import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Wizard;
import hell.entities.items.CommonItem;
import hell.entities.items.RecipeItem;
import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.*;
import hell.io.ConsoleInputReader;
import hell.io.ConsoleOutputWriter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    private static Map<String, Hero> heroes = new LinkedHashMap<>();

    public static void main (String[] args) {

        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();

        while (true) {

            String[] tokens = reader.readLine().split("\\s+");
            String command = tokens[0];
            String[] arguments = Arrays.stream(tokens).skip(1).toArray(String[] ::new);

            String output = commandManager(command, arguments);

            writer.writeLine(output);

            if ("Quit".equals(command)) {
                break;
            }

        }

    }

    private static String commandManager (String command, String[] arguments) {

        Hero hero = null;

        switch (command) {
            case "Hero":
                //•	Hero {heroName} {heroType}
                String heroName = arguments[0];
                String heroType = arguments[1];
                hero = createHero(heroName, heroType);
                heroes.put(hero.getName(), hero);
                return String.format("Created %s - %s", hero.getClass().getSimpleName(),
                                     hero.getName());
            case "Item":
                //•	Item {name} {heroName} {strengthBonus} {agilityBonus} {intelligenceBonus} {hitpointsBonus} {damageBonus}
                String heroN = arguments[1];
                hero = heroes.get(arguments[1]);
                Item commonItem = createItem(arguments);
                hero.addItem(commonItem);

                return String.format("Added item - %s to Hero - %s",
                                     commonItem.getName(),
                                     hero.getName());
            case "Recipe":

                //•	Recipe {name} {heroName} {strengthBonus} {agilityBonus} {intelligenceBonus} {hitpointsBonus} {damageBonus} {requiredItem1} {requiredItem2}. . .
                hero = heroes.get(arguments[1]);
                Recipe recipeItem = createRecipe(arguments);
                hero.addRecipe(recipeItem);

                return String.format("Added recipe - %s to Hero - %s",
                                     recipeItem.getName(), hero.getName());
            case "Inspect":
                //•	Inspect {heroName}
                hero = heroes.get(arguments[0]);
               return hero.toString();

            case "Quit":
                return printHeroesInfo();
        }

        return null;
    }

    private static Comparator<? super Hero> getHeroesComparator() {
        return (hero1, hero2) -> {
            long firstComparatorSumHero1 = hero1.getStrength() + hero1.getAgility() + hero1.getIntelligence();
            long firstComparatorSumHero2 = hero2.getStrength() + hero2.getAgility() + hero2.getIntelligence();

            int comparatorByFirstSum = Long.compare(firstComparatorSumHero2, firstComparatorSumHero1);

            if (comparatorByFirstSum != 0) {
                return comparatorByFirstSum;
            }

            long secondComparatorSumHero1 = hero1.getHitPoints() + hero1.getDamage();
            long secondComparatorSumHero2 = hero2.getHitPoints() + hero2.getDamage();

            return Long.compare(secondComparatorSumHero2, secondComparatorSumHero1);
        };
    }

    private static String printHeroesInfo() {
        StringBuilder heroesInfo = new StringBuilder();

        final int[] index = {1};
        heroes.values()
                .stream()
                .sorted(getHeroesComparator())
                .forEach(hero -> {
                    String items = hero.getItems().size() == 0 ?
                            "None" :
                            hero.getItems()
                                    .stream()
                                    .map(Item::getName)
                                    .collect(Collectors.joining(", "));
                    heroesInfo
                            .append(String.format("%d. %s: %s",
                                                  index[0]++,
                                                  hero.getClass().getSimpleName(),
                                                  hero.getName()))
                            .append(System.lineSeparator())
                            .append(String.format("###HitPoints: %d", hero.getHitPoints()))
                            .append(System.lineSeparator())
                            .append(String.format("###Damage: %d", hero.getDamage()))
                            .append(System.lineSeparator())
                            .append(String.format("###Strength: %d", hero.getStrength()))
                            .append(System.lineSeparator())
                            .append(String.format("###Agility: %d", hero.getAgility()))
                            .append(System.lineSeparator())
                            .append(String.format("###Intelligence: %d", hero.getIntelligence()))
                            .append(System.lineSeparator())
                            .append(String.format("###Items: %s", items))
                            .append(System.lineSeparator());
                });

        return heroesInfo.toString().trim();
    }

    private static Recipe createRecipe (String[] arguments) {

        return new RecipeItem
                            (arguments[0],
                             Integer.parseInt(arguments[2]),
                             Integer.parseInt(arguments[3]),
                             Integer.parseInt(arguments[4]),
                             Integer.parseInt(arguments[5]),
                             Integer.parseInt(arguments[6]),
                             Arrays.stream(arguments).skip(7).collect(Collectors.toList()));
    }

    private static Item createItem (String[] arguments) {

        return new CommonItem
                (arguments[0],
                 Integer.parseInt(arguments[2]),
                 Integer.parseInt(arguments[3]),
                 Integer.parseInt(arguments[4]),
                 Integer.parseInt(arguments[5]),
                 Integer.parseInt(arguments[6]));
    }

    private static Hero createHero (String heroName, String heroType) {

        switch (heroType) {
            case "Barbarian":
                return new Barbarian(heroName, new HeroInventory());
            case "Assassin":
                return new Assassin(heroName, new HeroInventory());
            case "Wizard":
                return new Wizard(heroName, new HeroInventory());
        }
        return null;
    }
}