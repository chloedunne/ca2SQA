import java.util.ArrayList;
import java.util.Collections;
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

	// Get a list of all Rubrics
	public ArrayList<Rubric> getAllRubrics() {
		return rubricList;
	}

	// Get a specific Rubric by name
	public Rubric getRubricByName(String name) {
		for (Rubric r : rubricList) {
			if (r.getName().equals(name)) {
				return r;
			}
		}
		return null;
	}

	// Get all grades in a Rubric
	public ArrayList<Integer> getAllGradesinRubric(Rubric rubric) {

		ArrayList<StudentGrade> studentGrades = rubric.getGrades();
		ArrayList<Integer> gradeScores = new ArrayList<Integer>();

		if (studentGrades != null) {
			for (StudentGrade studentGrade : studentGrades) {
				for (Integer i : studentGrade.getGrade().values()) {
					gradeScores.add(i);
				}
			}
		}

		if (gradeScores.isEmpty())
			return null;
		else
			return gradeScores;
	}

	// Get all grades in a Rubric criterion
	public ArrayList<Integer> getAllGradesinCriterion(Rubric rubric, String criterion) {

		ArrayList<StudentGrade> studentGrades = rubric.getGrades();
		ArrayList<Integer> gradeScores = new ArrayList<Integer>();

		if (studentGrades != null) {
			for (StudentGrade studentGrade : studentGrades) {
				gradeScores.add(studentGrade.getGrade().get(criterion));
			}
		}

		if (gradeScores.isEmpty())
			return null;
		else
			return gradeScores;
	}

	// Get average of Rubric
	public double getAverageOfRubric(Rubric rubric) {

		ArrayList<Integer> intList = getAllGradesinRubric(rubric);
		int total = 0;

		if (intList != null) {
			for (int i : intList) {
				total = total + i;
			}
			double average = (Double.valueOf(total)) / (Double.valueOf(intList.size()));
			return average;
		} else
			return 0;
	}

	// get average of a Criterion
	public double getAverageOfCriterion(Rubric rubric, String criterion) {

		ArrayList<Integer> intList = getAllGradesinCriterion(rubric, criterion);
		int total = 0;

		if (intList != null) {
			for (int i : intList) {
				total = total + i;
			}
			double average = (Double.valueOf(total)) / (Double.valueOf(intList.size()));
			return average;
		} else
			return 0;
	}

	// Find standard deviation
	public double calculateSD(ArrayList<Integer> intList) {
		double sum = 0.0, standardDeviation = 0.0;
		int length = intList.size();

		for (int num : intList) {
			sum += Double.valueOf(num);
		}

		double mean = sum / length;

		for (int num : intList) {
			standardDeviation += Math.pow(Double.valueOf(num) - mean, 2);
		}

		return Math.sqrt(standardDeviation / length);
	}

	// Get standard deviation of a Rubric
	public double calculateSDofRubric(Rubric rubric) {

		ArrayList<Integer> intList = getAllGradesinRubric(rubric);
		if (intList != null)
			return calculateSD(intList);
		else
			return 0;
	}

	// Get standard deviation of a criterion
	public double calculateSDofCriterion(Rubric rubric, String criterion) {

		ArrayList<Integer> intList = getAllGradesinCriterion(rubric, criterion);
		if (intList != null)
			return calculateSD(intList);
		else
			return 0;
	}

	// returns Min number in ArrayList
	public int getMin(ArrayList<Integer> intList) {

		Collections.sort(intList);

		return intList.get(0);
	}

	// returns Max number in ArrayList
	public int getMax(ArrayList<Integer> intList) {

		Collections.sort(intList, Collections.reverseOrder());

		return intList.get(0);
	}

	public int getMinOfRubric(Rubric r) {

		ArrayList<Integer> intList = getAllGradesinRubric(r);
		if (intList != null)
			return getMin(intList);
		else
			return -9999;

	}

	public int getMaxOfRubric(Rubric r) {

		ArrayList<Integer> intList = getAllGradesinRubric(r);
		if (intList != null)
			return getMax(intList);
		else
			return -9999;

	}

}
