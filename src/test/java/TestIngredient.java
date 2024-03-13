import praktikum.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


// В данном классе содержатся тесты для класса Ingredient
public class TestIngredient {
    public IngredientType ingredientType = IngredientType.FILLING;
    public String ingredientName = "baseIngredient";
    public float ingredientPrice = 321.98f;
    Ingredient ingredient;

    @Before
    public void createIngredient() {
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }

    @Test
    public void testCanGetIngredientType() {
        IngredientType actualIngredientType = ingredient.getType();
        assertEquals(ingredientType, actualIngredientType);
    }

    @Test
    public void testCanGetIngredientName() {
        String actualIngredientName = ingredient.getName();
        assertEquals(ingredientName, actualIngredientName);
    }

    @Test
    public void testCanGetIngredientPrice(){
        float actualIngredientPrice = ingredient.getPrice();
        assertEquals(ingredientPrice, actualIngredientPrice, 0.0f);
    }
}
