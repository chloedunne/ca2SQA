import java.util.ArrayList;

public class Rubric {
	
	private String name;
	private ArrayList<String> criterion;
	private ArrayList<StudentGrade> grades;
	
	public Rubric() {}
	
	
	public Rubric(String name) {
		super();
		this.name = name;
	}


	public Rubric(String name, ArrayList<String> criterion, ArrayList<StudentGrade> grades) {
		super();
		this.name = name;
		this.criterion = criterion;
		this.grades = grades;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getCriterion() {
		return criterion;
	}
	public void setCriterion(ArrayList<String> criterion) {
		this.criterion = criterion;
	}
	public ArrayList<StudentGrade> getGrades() {
		return grades;
	}
	public void setGrades(ArrayList<StudentGrade> grades) {
		this.grades = grades;
	}
	

}
