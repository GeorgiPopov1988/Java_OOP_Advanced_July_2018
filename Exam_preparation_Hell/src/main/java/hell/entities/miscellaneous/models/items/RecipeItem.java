package hell.entities.miscellaneous.models.items;

import hell.interfaces.Recipe;

import java.util.Arrays;
import java.util.List;

public class RecipeItem extends BaseItem implements Recipe {

    private List<String> requiredItems;

    public RecipeItem (String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus,
                          int damageBonus, String...item) {

        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.requiredItems = Arrays.asList(item);
    }

    @Override
    public List<String> getRequiredItems () {

        return this.requiredItems;
    }
}
