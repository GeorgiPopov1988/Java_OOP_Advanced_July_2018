package hell.factories;

import hell.entities.miscellaneous.models.items.RecipeItem;

import java.util.List;

public final class RecipeFactory {

    private RecipeFactory () {

    }

    public static RecipeItem createRecipe
            (String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus,
             int damageBonus, List<String> neededItems) {

        return new RecipeItem(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus,
                neededItems);

    }
}
