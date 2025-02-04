import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product p1,p2,p3,p4;

    @BeforeEach
    void setUp() {
        p1 = new Product("00000A", "Health Potion", "Restores HP", 12.99);
        Product.setIDSeed(0);
        p2 = new Product("Mana Potion", "Restores MP", 10.99);
        //System.out.println("p2 - IDSeed is: " + Product.getIDSeed());
        p3 = new Product("Stamina Potion", "Restores Stamina", 8.99);
        //System.out.println("p3 - IDSeed is: " + Product.getIDSeed());
        p4 = new Product("Strength Potion", "Increases Strength", 15.99);
        //System.out.println("p4 - IDSeed is: " + Product.getIDSeed());

    }

    @Test
    /** tests the seed generator after 4 calls, should be 4*/
    void getIDSeed() {
        assertEquals(3, Product.getIDSeed());
    }

    @Test
    void getIDNum() {
        assertEquals("00000A",p1.getIDNum());
    }

    @Test
    void getName() {
        assertEquals("Health Potion",p1.getName());
    }

    @Test
    void getDesc() {
        assertEquals("Restores HP",p1.getDesc());
    }

    @Test
    void getCost() {
        assertEquals(12.99,p1.getCost());
    }

    @Test
    void setName() {
        p1.setName("Mana Potion");
        assertEquals("Mana Potion",p1.getName());
    }

    @Test
    void setDesc() {
        p1.setDesc("Stamina Potion");
        assertEquals("Stamina Potion",p1.getDesc());
    }

    @Test
    void setCost() {
        p1.setCost(22.99);
        assertEquals(22.99,p1.getCost());
    }

    public static void main(String[] args) {

    }
}