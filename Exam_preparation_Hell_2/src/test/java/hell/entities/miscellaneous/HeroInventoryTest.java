package hell.entities.miscellaneous;

import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HeroInventoryTest {



    private static final int VALUE = Integer.MAX_VALUE;
    private static final long EXPECTED_VALUE = VALUE * 3L;

    private static final String INCORRECT_STRENGTH_BONUS_VALUE = "Not correct Strength bonus value";
    private static final String INCORRECT_AGILITY_BONUS_VALUE = "Not correct Agility bonus value";
    private static final String INCORRECT_INTELLIGENCE_BONUS_VALUE = "Not correct Intelligence " +
            "bonus " +
            "value";
    private static final String INCORRECT_HIT_POINTS_BONUS_VALUE = "Not correct Hit points bonus " +
            "value";
    private static final String INCORRECT_DAMAGE_BONUS_VALUE = "Not correct Damage bonus value";

    private Inventory inventory;

    @Before
    public void setUp () throws Exception {

        this.inventory = new HeroInventory();
    }

    private Item createMockedCommonItem () {

        Item commonItem = Mockito.mock(Item.class);

        Mockito.when(commonItem.getStrengthBonus()).thenReturn(VALUE);
        Mockito.when(commonItem.getAgilityBonus()).thenReturn(VALUE);
        Mockito.when(commonItem.getIntelligenceBonus()).thenReturn(VALUE);
        Mockito.when(commonItem.getHitPointsBonus()).thenReturn(VALUE);
        Mockito.when(commonItem.getDamageBonus()).thenReturn(VALUE);

        return commonItem;
    }

    private void seedCommonItems () {

        Item commonItem1 = this.createMockedCommonItem();
        Mockito.when(commonItem1.getName()).thenReturn("CommonItem1");

        Item commonItem2 = this.createMockedCommonItem();
        Mockito.when(commonItem2.getName()).thenReturn("CommonItem2");

        Item commonItem3 = this.createMockedCommonItem();
        Mockito.when(commonItem3.getName()).thenReturn("CommonItem3");

        this.inventory.addCommonItem(commonItem1);
        this.inventory.addCommonItem(commonItem2);
        this.inventory.addCommonItem(commonItem3);
    }

    private void seedRecipeItem () {
        Recipe recipeMock = Mockito.mock(Recipe.class);
        List<String> requiredItems = new ArrayList<>();
        requiredItems.add("CommonItem1");
        requiredItems.add("CommonItem2");
        requiredItems.add("CommonItem4");
        Mockito.when(recipeMock.getRequiredItems()).thenReturn(requiredItems);
        this.inventory.addRecipeItem(recipeMock);
    }

    @Test
    public void getTotalStrengthBonus () {
        //  Arrange
        this.seedCommonItems();

        //  Act
        long actualTotalStrengthBonusValue = this.inventory.getTotalStrengthBonus();

        //  Assert
        Assert.assertEquals(INCORRECT_STRENGTH_BONUS_VALUE, EXPECTED_VALUE, actualTotalStrengthBonusValue);

    }

    @Test
    public void getTotalAgilityBonus () {
        //  Arrange
        this.seedCommonItems();

        //  Act
        long actualTotalAgilityBonusValue = this.inventory.getTotalAgilityBonus();

        //  Assert
        Assert.assertEquals(INCORRECT_AGILITY_BONUS_VALUE, EXPECTED_VALUE, actualTotalAgilityBonusValue);

    }

    @Test
    public void getTotalIntelligenceBonus () {
        //  Arrange
        this.seedCommonItems();

        //  Act
        long actualTotalIntelligenceBonusValue = this.inventory.getTotalIntelligenceBonus();

        //  Assert
        Assert.assertEquals(INCORRECT_INTELLIGENCE_BONUS_VALUE, EXPECTED_VALUE, actualTotalIntelligenceBonusValue);

    }

    @Test
    public void getTotalHitPointsBonus () {
        //  Arrange
        this.seedCommonItems();

        //  Act
        long actualTotalHitPointsBonusValue = this.inventory.getTotalHitPointsBonus();

        //  Assert
        Assert.assertEquals(INCORRECT_HIT_POINTS_BONUS_VALUE, EXPECTED_VALUE, actualTotalHitPointsBonusValue);

    }

    @Test
    public void getTotalDamageBonus () {
        //  Arrange
        this.seedCommonItems();

        //  Act
        long actualTotalDamageBonusValue = this.inventory.getTotalDamageBonus();

        //  Assert
        Assert.assertEquals(INCORRECT_DAMAGE_BONUS_VALUE, EXPECTED_VALUE, actualTotalDamageBonusValue);

    }

    @Test
    public void addCommonItem () {
        // Arrange
        this.seedCommonItems();
        this.seedRecipeItem();
        Item commonItemMock4 = Mockito.mock(Item.class);
        Mockito.when(commonItemMock4.getName()).thenReturn("CommonItem4");

        // Act
        this.inventory.addCommonItem(commonItemMock4);
        int actualCountOfCommonItems = 0;

        try {
            Field commonItemsField = this.inventory.getClass().getDeclaredField("commonItems");
            commonItemsField.setAccessible(true);
            Map<String, Item> commonItemsMap = (Map<String, Item>) commonItemsField.get(this.inventory);
            actualCountOfCommonItems = commonItemsMap.size();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        int expectedCountOfCommonItems = 2;

        // Assert
        Assert.assertEquals(expectedCountOfCommonItems, actualCountOfCommonItems);
    }

    @Test
    public void addRecipeItem () {

    }
}