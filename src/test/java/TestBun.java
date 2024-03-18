import praktikum.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// Данный класс содержит тесты для класса Bun для приложения Stellar Burger
public class TestBun {

    Bun bun;
    String bunName = "Kosmo";
    float bunPrice = 123.45F;


    @Before
    public void createBun() {
        bun = new Bun(bunName, bunPrice);
    }

    @Test
    public void testCanGetBunName() {
        String actualBunName = bun.getName();
        assertEquals(bunName, actualBunName);
    }

    @Test
    public void testCanGetBunPrice() {
        float actualBunPrice = bun.getPrice();
        assertEquals(bunPrice, actualBunPrice, 0.0f);
    }

}
