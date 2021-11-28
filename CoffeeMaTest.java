
package edu.ncsu.csc326.coffeemaker;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;


public class CoffeeMakerTest {
	
	
	private CoffeeMaker coffeeMaker;
	

	private Recipe re_1;
	private Recipe re_2;
	private Recipe re_3;
	private Recipe re_4;
	private Recipe re_5;
	private Recipe re_6;
	private Recipe re_7;

	
	@Before
	public void setUp() throws RecipeException {
		coffeeMaker = new CoffeeMaker();
		
		
		re_1 = new Recipe();
		re_1.setName("Coffee");
		re_1.setAmtChocolate("0");
		re_1.setAmtCoffee("3");
		re_1.setAmtMilk("1");
		re_1.setAmtSugar("1");
		re_1.setPrice("50");
		
		
		re_2 = new Recipe();
		re_2.setName("Mocha");
		re_2.setAmtChocolate("20");
		re_2.setAmtCoffee("3");
		re_2.setAmtMilk("1");
		re_2.setAmtSugar("1");
		re_2.setPrice("75");
		
		
		re_3 = new Recipe();
		re_3.setName("Latte");
		re_3.setAmtChocolate("0");
		re_3.setAmtCoffee("3");
		re_3.setAmtMilk("3");
		re_3.setAmtSugar("1");
		re_3.setPrice("100");
		
		
		re_4 = new Recipe();
		re_4.setName("Hot Chocolate");
		re_4.setAmtChocolate("4");
		re_4.setAmtCoffee("0");
		re_4.setAmtMilk("1");
		re_4.setAmtSugar("1");
		re_4.setPrice("65");

		
		re_5 = new Recipe();
		re_5.setName("Custom");
		re_5.setAmtChocolate("4");
		re_5.setAmtCoffee("0");
		re_5.setAmtMilk("1");
		re_5.setAmtSugar("30");
		re_5.setPrice("65");

		
		re_6 = new Recipe();
		re_6.setName("Custom");
		re_6.setAmtChocolate("4");
		re_6.setAmtCoffee("0");
		re_6.setAmtMilk("30");
		re_6.setAmtSugar("1");
		re_6.setPrice("65");

		re_7 = new Recipe();
		re_7.setName("Custom");
		re_7.setAmtChocolate("4");
		re_7.setAmtCoffee("30");
		re_7.setAmtMilk("0");
		re_7.setAmtSugar("1");
		re_7.setPrice("65");
	}

	@Test
	public void testAddInventory() throws InventoryException {
		coffeeMaker.addInventory("4","7","0","9");
	}
	
	
	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionCoffee() throws InventoryException {
		coffeeMaker.addInventory("-4", "1", "2", "3");
	}


	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionCoffeeAlp() throws InventoryException {
		coffeeMaker.addInventory("ll", "1", "2", "3");
	}

	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionMilk() throws InventoryException {
		coffeeMaker.addInventory("4", "-1", "2", "3");
	}

	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionMilkAlp() throws InventoryException {
		coffeeMaker.addInventory("4", "pop", "2", "3");
	}

	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionSugar() throws InventoryException {
		coffeeMaker.addInventory("4", "1", "-2", "3");
	}

	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionSugarAlp() throws InventoryException {
		coffeeMaker.addInventory("4", "1", "lp", "3");
	}


	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionChocolate() throws InventoryException {
		coffeeMaker.addInventory("4", "1", "2", "-3");
	}


	@Test(expected = InventoryException.class)
	public void testAddInventoryExceptionChocolateAlp() throws InventoryException {
		coffeeMaker.addInventory("4", "1", "2", "aa");
	}


	
	@Test
	public void testCheckInventory() {
		
		StringBuffer buf = new StringBuffer();
    	buf.append("Coffee: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Milk: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Sugar: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Chocolate: ");
    	buf.append(15);
    	buf.append("\n");
		
		
		assertEquals(buf.toString(), coffeeMaker.checkInventory());
	}


	@Test
	public void testCheckInventoryMilk() throws InventoryException {
		
		coffeeMaker.addInventory("0", "5", "0", "0");

		StringBuffer buf = new StringBuffer();
    	buf.append("Coffee: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Milk: ");
    	buf.append(15+5);
    	buf.append("\n");
    	buf.append("Sugar: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Chocolate: ");
    	buf.append(15);
    	buf.append("\n");
		
		
		assertEquals(buf.toString(), coffeeMaker.checkInventory());
	}

	
	@Test
	public void testCheckInventorySugar() throws InventoryException {
		
		coffeeMaker.addInventory("0", "0", "5", "0");

		StringBuffer buf = new StringBuffer();
    	buf.append("Coffee: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Milk: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Sugar: ");
    	buf.append(15+5);
    	buf.append("\n");
    	buf.append("Chocolate: ");
    	buf.append(15);
    	buf.append("\n");
		
		
		assertEquals(buf.toString(), coffeeMaker.checkInventory());
	}

	
	@Test
	public void testCheckInventoryChoco() throws InventoryException {
		
		coffeeMaker.addInventory("0", "0", "0", "5");

		StringBuffer buf = new StringBuffer();
    	buf.append("Coffee: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Milk: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Sugar: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Chocolate: ");
    	buf.append(15+5);
    	buf.append("\n");
		
		
		assertEquals(buf.toString(), coffeeMaker.checkInventory());
	}

	
	@Test
	public void testCheckInventoryCoffee() throws InventoryException {
		
		coffeeMaker.addInventory("5", "0", "0", "0");

		StringBuffer buf = new StringBuffer();
    	buf.append("Coffee: ");
    	buf.append(15+5);
    	buf.append("\n");
    	buf.append("Milk: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Sugar: ");
    	buf.append(15);
    	buf.append("\n");
    	buf.append("Chocolate: ");
    	buf.append(15);
    	buf.append("\n");
		
		
		assertEquals(buf.toString(), coffeeMaker.checkInventory());
	}





	@Test
	public void testMakeCoffee() {
		coffeeMaker.addRecipe(re_1);
		assertEquals(25, coffeeMaker.makeCoffee(0, 75));
	}

	
	@Test
	public void testMakeCoffeeMultipleTrue() {
		coffeeMaker.addRecipe(re_1);
		coffeeMaker.addRecipe(re_2);
		coffeeMaker.addRecipe(re_3);
		assertEquals(75, coffeeMaker.makeCoffee(2, 175));
	}

	
	@Test
	public void testMakeCoffeeMultipleFalse() {
		coffeeMaker.addRecipe(re_1);
		coffeeMaker.addRecipe(re_4);
		coffeeMaker.addRecipe(re_3);
		assertEquals(5, coffeeMaker.makeCoffee(1, 5));
	}

	
	@Test
	public void testMakeCoffeeMultiple() {
		coffeeMaker.addRecipe(re_1);
		coffeeMaker.addRecipe(re_2);
		coffeeMaker.addRecipe(re_3);
		assertEquals(0, coffeeMaker.makeCoffee(0, 50));
	}


	
	@Test
	public void testMakeCoffeeInventoryFalse() {
		coffeeMaker.addRecipe(re_1);
		coffeeMaker.addRecipe(re_2);
		coffeeMaker.addRecipe(re_3);
		assertEquals(100, coffeeMaker.makeCoffee(1, 100));
	}

	
	@Test
	public void testMakeCoffeeInventoryFalse6() {
		coffeeMaker.addRecipe(re_6);
		assertEquals(100, coffeeMaker.makeCoffee(0, 100));
	}

	
	@Test
	public void testMakeCoffeeInventoryFalse7() {
		coffeeMaker.addRecipe(re_7);
		assertEquals(100, coffeeMaker.makeCoffee(0, 100));
	}


	@Test
	public void testMakeCoffeeInventoryFalse2() {
		coffeeMaker.addRecipe(re_5);
		assertEquals(100, coffeeMaker.makeCoffee(0, 100));
	}


	@Test
	public void testMakeCoffeeInventoryTrue() throws InventoryException {
		coffeeMaker.addInventory("0", "0", "0", "20");
		coffeeMaker.addRecipe(re_1);
		coffeeMaker.addRecipe(re_2);
		coffeeMaker.addRecipe(re_3);
		assertEquals(25, coffeeMaker.makeCoffee(1, 100));
	}

	
	@Test
	public void testMakeCoffeeInventoryFalse3() {
		assertEquals(100, coffeeMaker.makeCoffee(0, 100));
	}

	
	@Test
	public void testMakeCoffeeInventoryFalse4() {
		coffeeMaker.addRecipe(re_5);
		assertEquals(100, coffeeMaker.makeCoffee(-1, 100));
	}

	
	@Test
	public void testMakeCoffeeInventoryFalse5() {
		coffeeMaker.addRecipe(re_5);
		assertEquals(100, coffeeMaker.makeCoffee(10, 100));
	}




	@Test
	public void testMakeCoffeeAddRecipe1() {
		coffeeMaker.addRecipe(re_1);
		assertNotEquals(null, coffeeMaker.getRecipes()[0]);
	}

	
	@Test
	public void testMakeCoffeeAddRecipe2() {
		coffeeMaker.addRecipe(re_1);
		coffeeMaker.addRecipe(re_2);
		coffeeMaker.addRecipe(re_3);
		assertNotEquals(null, coffeeMaker.getRecipes()[0]);
		assertNotEquals(null, coffeeMaker.getRecipes()[1]);
		assertNotEquals(null, coffeeMaker.getRecipes()[2]);
	}


	@Test
	public void testMakeCoffeeAddRecipe3() {
		coffeeMaker.addRecipe(re_3);
		Recipe recipe= new Recipe();
		recipe.setName(re_3.getName());
		assertEquals(false, coffeeMaker.addRecipe(recipe));
	}


	
	@Test
	public void testMakeCoffeeDeleteRecipe1() {
		coffeeMaker.addRecipe(re_1);
		coffeeMaker.deleteRecipe(0);
		assertEquals(null, coffeeMaker.getRecipes()[0]);
	}

	
	@Test
	public void testMakeCoffeeDeleteRecipe2() {
		assertEquals(null, coffeeMaker.deleteRecipe(0));
	}

	
	@Test
	public void testMakeCoffeeDeleteRecipe3() {
		assertEquals(null, coffeeMaker.deleteRecipe(-1));
	}


	@Test
	public void testMakeCoffeeEditRecipe1() {
		coffeeMaker.addRecipe(re_1);
		coffeeMaker.editRecipe(0, re_2);
		assertEquals(re_2.getPrice(), coffeeMaker.getRecipes()[0].getPrice());
	}


	@Test
	public void testMakeCoffeeEditRecipe2() {
		assertEquals(null, coffeeMaker.editRecipe(0, re_2));
	}

	@Test
	public void testMakeCoffeeEditRecipe3() {
		assertEquals(null, coffeeMaker.editRecipe(-1, re_2));
	}

	

	@Test(expected = RecipeException.class)
	public void testCreateRecipe1() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Coffee");
		recipe.setAmtChocolate("0");
		recipe.setAmtCoffee("3");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("1");
		recipe.setPrice("-50");
	}

	
	@Test(expected = RecipeException.class)
	public void testCreateRecipe2() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Coffee");
		recipe.setAmtChocolate("0");
		recipe.setAmtCoffee("3");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("-1");
		recipe.setPrice("50");
	}

	
	@Test(expected = RecipeException.class)
	public void testCreateRecipe3() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Coffee");
		recipe.setAmtChocolate("0");
		recipe.setAmtCoffee("3");
		recipe.setAmtMilk("-1");
		recipe.setAmtSugar("1");
		recipe.setPrice("50");
	}


	@Test(expected = RecipeException.class)
	public void testCreateRecipe4() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Coffee");
		recipe.setAmtChocolate("0");
		recipe.setAmtCoffee("-3");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("1");
		recipe.setPrice("50");
	}

	
	@Test(expected = RecipeException.class)
	public void testCreateRecipe5() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Coffee");
		recipe.setAmtChocolate("-10");
		recipe.setAmtCoffee("3");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("1");
		recipe.setPrice("50");
	}


	@Test(expected = RecipeException.class)
	public void testCreateRecipe6() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Coffee");
		recipe.setAmtChocolate("0");
		recipe.setAmtCoffee("3");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("1");
		recipe.setPrice("abc");
	}

	
	@Test(expected = RecipeException.class)
	public void testCreateRecipe7() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Coffee");
		recipe.setAmtChocolate("aa");
		recipe.setAmtCoffee("3");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("1");
		recipe.setPrice("50");
	}

	
	@Test(expected = RecipeException.class)
	public void testCreateRecipe8() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Coffee");
		recipe.setAmtChocolate("0");
		recipe.setAmtCoffee("bb");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("1");
		recipe.setPrice("50");
	}

	
	@Test(expected = RecipeException.class)
	public void testCreateRecipe9() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Coffee");
		recipe.setAmtChocolate("0");
		recipe.setAmtCoffee("3");
		recipe.setAmtMilk("bb");
		recipe.setAmtSugar("1");
		recipe.setPrice("50");
	}

	
	@Test(expected = RecipeException.class)
	public void testCreateRecipe10() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Coffee");
		recipe.setAmtChocolate("0");
		recipe.setAmtCoffee("3");
		recipe.setAmtMilk("1");
		recipe.setAmtSugar("bb");
		recipe.setPrice("50");
	}

	
	@Test
	public void testCreateRecipe11() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Coffee");

		assertEquals(true, re_1.equals(recipe));
	}

	
	@Test
	public void testCreateRecipe12() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Mocha");

		assertEquals(false, re_1.equals(recipe));
	}
	

	
	@Test
	public void testCreateRecipe13() throws RecipeException {
		Recipe recipe = new Recipe();

		assertEquals(false, re_1.equals(recipe));
	}

	
	@Test
	public void testCreateRecipe14() throws RecipeException {
		Recipe recipe = new Recipe();

		assertEquals(false, recipe.equals(re_1));
	}


	@Test
	public void testCreateRecipe15() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setName("Mocha");

		assertEquals("Mocha", recipe.toString());
	}

}