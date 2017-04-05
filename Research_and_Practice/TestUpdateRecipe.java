import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * tests the updateRecipe member function of the KitchenHelper Application
 * @author   Forrest Short
 * @version  April 05, 2017
 */
 public class TestKitchenHelper
 {
	 /**
	  * tests to ensure that when a user attempts to update a recipe,
	  *   that update occurs successfully.
	  * @throws IOException
	  */
	 @Test
	 public void testUpdateRecipe throws IOException {
		try {
			RecipeDatabase rb = new RecipeDatabase();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		/* Use the name of a recipe to retrive a Recipe object using searchRecipe(String) */
		Recipe testRecipe = rb.searchRecipe("King Ranch Chicken");
		
		/* updateRecipe returns true if the update was successful, false otherwise */
		assertTrue("The update of the recipe did not succeed", rb.updateRecipe(testRecipe));
	 }
 }