import java.util.HashMap;

public class StudentGrade {

	private String name;
	private HashMap<String, Integer> grade;
	
	public StudentGrade() {}
	
	
	public StudentGrade(String name, HashMap<String, Integer> grade) {
		super();
		this.name = name;
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<String, Integer> getGrade() {
		return grade;
	}
	public void setGrade(HashMap<String, Integer> grade) {
		this.grade = grade;
	}
	
}
