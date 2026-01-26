package GroupWork.hw10;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Subject {

	//학년(grade), 학기(semester), 과목명(name)을 필드로 선언하세요.
	private int grade, semester;
	private String name;
	//grade, semester, name의 getter와 setter를 추가
	
	//toString을 오버라이딩해서 1학년 1학기 국어 형태의 문자열이 반환되도록 작성하세요.
	@Override
	public String toString() {
		grade = 1;
		semester = 1;
		name = "국어";
		return grade + "학년 " semester + "학기 " + name;
	}
	public Subject(int grade, int semester, String name) {
		super();
		this.grade = grade;
		this.semester = semester;
		this.name = name;
	}
	
}
