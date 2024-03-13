import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


@RunWith(Parameterized.class)
public class TestBurgerParametrized {

    @Mock
    Bun mockBun;
    Burger burger;

    String bunName;
    float bunPrice;

    @Mock
    public Ingredient mockIngredient;
    private String ingredientName;
    private float ingredientPrice;
    private IngredientType ingredientType;
    @Mock
    public Ingredient mockIngredient1;

    private String ingredient1Name = "jastName";
    private float ingredient1Price = 700f;
    private IngredientType ingredient1Type = IngredientType.FILLING;

    public TestBurgerParametrized(String bunName, float bunPrice, IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters
    public static Object[][] testBurgerData() {
        return new Object[][]{
                {"black Bun", 100f, IngredientType.FILLING, "cutlet", 100f},
                {"white Bun", 200f, IngredientType.SAUCE, "chili sauce", 300f},
                {"red bun", 300f, IngredientType.FILLING, "dinosaur", 200f}
        };
    }


    @Before
    public void GettingReadyToWorkWithBurgerClass() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
        Mockito.when(mockBun.getName()).thenReturn(bunName);
        Mockito.when(mockBun.getPrice()).thenReturn(bunPrice);

        Mockito.when(mockIngredient.getType()).thenReturn(ingredientType);
        Mockito.when(mockIngredient.getName()).thenReturn(ingredientName);
        Mockito.when(mockIngredient.getPrice()).thenReturn(ingredientPrice);

        Mockito.when(mockIngredient1.getType()).thenReturn(ingredient1Type);
        Mockito.when(mockIngredient1.getName()).thenReturn(ingredient1Name);
        Mockito.when(mockIngredient1.getPrice()).thenReturn(ingredient1Price);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(mockBun);
        assertEquals(bunName, burger.bun.getName());
    }


    @Test
    public void testAddIngredient() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);
        assertEquals(burger.ingredients.isEmpty(), false);

    }

    @Test
    public void testRemoveIngredient() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);
        burger.removeIngredient(0);
        assertEquals(burger.ingredients.isEmpty(), true);
    }

    @Test
    public void testMoveIngredient() {

        String expectedBurgerRecipe;
        String actualdBurgerRecipe;

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bunName));
        receipt.append(String.format("= %s %s =%n", ingredientType.toString().toLowerCase(),
                ingredientName));
        receipt.append(String.format("= %s %s =%n", ingredient1Type.toString().toLowerCase(),
                ingredient1Name));
        receipt.append(String.format("(==== %s ====)%n", bunName));
        receipt.append(String.format("%nPrice: %f%n", bunPrice * 2 + ingredientPrice + ingredient1Price));
        expectedBurgerRecipe = receipt.toString();


        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient);
        actualdBurgerRecipe = burger.getReceipt();

        assertNotEquals(expectedBurgerRecipe, actualdBurgerRecipe);

        burger.moveIngredient(1, 0);
        actualdBurgerRecipe = burger.getReceipt();

        assertEquals(expectedBurgerRecipe, actualdBurgerRecipe);
    }

    @Test
    public void testGetPrice() {
        float expectedPrice;
        float actualPrice;
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient);

        expectedPrice = bunPrice * 2 + ingredientPrice * 2 + ingredient1Price;
        actualPrice = burger.getPrice();

        assertEquals(expectedPrice, actualPrice, 0.005f);
    }

    @Test
    public void testGetReciept() {
        String expectedBurgerRecipe;
        String actualdBurgerRecipe;

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bunName));
        receipt.append(String.format("= %s %s =%n", ingredientType.toString().toLowerCase(),
                ingredientName));
        receipt.append(String.format("= %s %s =%n", ingredient1Type.toString().toLowerCase(),
                ingredient1Name));
        receipt.append(String.format("(==== %s ====)%n", bunName));
        receipt.append(String.format("%nPrice: %f%n", bunPrice * 2 + ingredientPrice + ingredient1Price));

        expectedBurgerRecipe = receipt.toString();

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);
        burger.addIngredient(mockIngredient1);

        actualdBurgerRecipe = burger.getReceipt();

        assertEquals(expectedBurgerRecipe, actualdBurgerRecipe);

    }

}