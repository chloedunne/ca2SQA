import java.util.ArrayList;
import java.util.HashMap;

public class Controller {

	private ArrayList<Rubric> rubricList = new ArrayList<Rubric>();

	// Create Rubric
	public Rubric createRubric(String name, ArrayList<String> criterion, ArrayList<StudentGrade> studentGrades) {

		if (criterion != null) {
			if (criterion.size() > 10) {
				System.out.println("More than 10 criterion");
				return null;
			}
		}

		if (studentGrades != null) {
			for (StudentGrade studentGrade : studentGrades) {
				if (!checkGrades(studentGrade.getGrade())) {
					return null;
				}
			}
		}

		Rubric rubric = new Rubric(name, criterion, studentGrades);
		rubricList.add(rubric);
		return rubric;
	}

	// Check if grades are between 1-5
	public boolean checkGrades(HashMap<String, Integer> grades) {

		for (Integer i : grades.values()) {
			if (i > 5 || i < 1) {
				System.out.println("Grade is not between 1 - 5");
				return false;
			}
		}
		return true;
	}

	// Create StudentGrade
	public StudentGrade createStudentGrade(String name, HashMap<String, Integer> grades) {

		if (!checkGrades(grades)) {
			return null;
		}

		StudentGrade studentGrade = new StudentGrade(name, grades);

		return studentGrade;
	}

	// add a Criterion to a Rubric
	public ArrayList<String> addCriterionToRubric(String criterion, Rubric rubric) {

		ArrayList<String> criterionList = rubric.getCriterion();

		if (criterionList.size() < 10) {
			criterionList.add(criterion);
		}

		return criterionList;
	}

}
