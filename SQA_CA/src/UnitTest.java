import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

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

		// Testing rubric with more than 10 criteria will return null
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

	@Test
	public void testCreateStudentGrade() {

		controller = new Controller();

		HashMap<String, Integer> grades = new HashMap<String, Integer>();

		grades.put("Design", 5);
		grades.put("Implementation", 3);

		StudentGrade studentGrade = controller.createStudentGrade("Chloe Dunne", grades);

		assertEquals("Chloe Dunne", studentGrade.getName());
		assertEquals(grades, studentGrade.getGrade());

		// Testing grades with a score more than 5 will return null
		HashMap<String, Integer> grades1 = new HashMap<String, Integer>();

		grades1.put("Design", 8);

		StudentGrade studentGrade1 = controller.createStudentGrade("Mary Dunne", grades1);

		assertEquals(null, studentGrade1);

	}

	@Test
	public void testAddCriterionToRubric() {

		controller = new Controller();

		ArrayList<String> criterion = new ArrayList<>();

		criterion.add(new String("Design"));
		criterion.add(new String("Implementation"));
		criterion.add(new String("Testing"));

		Rubric rubric = controller.createRubric("Testing Rubric", criterion, null);

		ArrayList<String> criterionList = controller.addCriterionToRubric("Documentation", rubric);

		assertEquals("Documentation", criterionList.get(criterionList.size() - 1));

		//If there are 10 criterion already in rubric, no more criterion will be added
		ArrayList<String> criterion1 = new ArrayList<>();

		criterion1.add("Test1");
		criterion1.add("Test2");
		criterion1.add("Test3");
		criterion1.add("Test4");
		criterion1.add("Test5");
		criterion1.add("Test6");
		criterion1.add("Test7");
		criterion1.add("Test8");
		criterion1.add("Test9");
		criterion1.add("Test10");

		Rubric rubric1 = controller.createRubric("Test Rubric1", criterion1, null);

		ArrayList<String> criterionList1 = controller.addCriterionToRubric("Test11", rubric1);

		assertEquals("Test10", criterionList1.get(criterionList1.size() - 1));

	}
	
	@Test
	public void testGetAllRubrics() {
		controller = new Controller();

		ArrayList<String> criterion1 = new ArrayList<>();
		ArrayList<String> criterion2 = new ArrayList<>();
		ArrayList<String> criterion3 = new ArrayList<>();

		criterion1.add(new String("Design"));
		criterion1.add(new String("Implementation"));
		criterion1.add(new String("Testing"));

		criterion2.add(new String("Maths"));
		criterion2.add(new String("English"));
		criterion2.add(new String("History"));

		criterion3.add(new String("Presentation"));
		criterion3.add(new String("Taste"));
		criterion3.add(new String("Use of Ingredients"));

		HashMap<String, Integer> grades1 = new HashMap<String, Integer>();
		HashMap<String, Integer> grades1a = new HashMap<String, Integer>();

		HashMap<String, Integer> grades2 = new HashMap<String, Integer>();

		grades1.put("Design", 5);
		grades1.put("Implementation", 3);
		grades1a.put("Design", 3);

		grades2.put("Maths", 2);
		grades2.put("English", 4);
		grades2.put("History", 3);

		StudentGrade studentGrade1 = controller.createStudentGrade("Chloe", grades1);
		StudentGrade studentGrade1a = controller.createStudentGrade("Mary", grades1a);

		StudentGrade studentGrade2 = controller.createStudentGrade("Sarah", grades2);

		ArrayList<StudentGrade> gradeList1 = new ArrayList<StudentGrade>();
		ArrayList<StudentGrade> gradeList2 = new ArrayList<StudentGrade>();

		gradeList1.add(studentGrade1);
		gradeList1.add(studentGrade1a);

		gradeList2.add(studentGrade2);

		Rubric rubric1 = controller.createRubric("Testing Rubric", criterion1, gradeList1);
		Rubric rubric2 = controller.createRubric("School Rubric", criterion2, gradeList2);
		Rubric rubric3 = controller.createRubric("Baking Rubric", criterion3, null);

		ArrayList<Rubric> testRubricList = new ArrayList<Rubric>();
		testRubricList.add(rubric1);
		testRubricList.add(rubric2);
		testRubricList.add(rubric3);

		ArrayList<Rubric> rubricList = controller.getAllRubrics();

		assertEquals(testRubricList, rubricList);
	}


}
