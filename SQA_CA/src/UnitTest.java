import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class UnitTest {

	private Controller controller;

	@Test
	public void testCreateRubric() {

		controller = new Controller();

		ArrayList<String> criterion = new ArrayList<>();

		criterion.add(new String("Design"));
		criterion.add(new String("Implementation"));
		criterion.add(new String("Testing"));

		Rubric rubric = controller.createRubric("Rubric", criterion, null);

		assertEquals("Rubric", rubric.getName());
		assertEquals(criterion, rubric.getCriterion());
		assertEquals(null, rubric.getGrades());

		//Testing rubric with more than 10 criteria will return null
		ArrayList<String> criterion1 = new ArrayList<>();

		criterion1.add(new String("Test1"));
		criterion1.add(new String("Test2"));
		criterion1.add(new String("Test3"));
		criterion1.add(new String("Test4"));
		criterion1.add(new String("Test5"));
		criterion1.add(new String("Test6"));
		criterion1.add(new String("Test7"));
		criterion1.add(new String("Test8"));
		criterion1.add(new String("Test9"));
		criterion1.add(new String("Test10"));
		criterion1.add(new String("Test11"));

		Rubric rubric1 = controller.createRubric("Test Rubric", criterion1, null);

		assertEquals(null, rubric1);

	}

}
