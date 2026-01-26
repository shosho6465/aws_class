package Student_Program;

import java.util.Objects;

public class Student_align implements Comparable<Student_align> {
	private int grade;
	private int homeroom;
	private int number;
	private String name;
	private int score;
	
	@Override
	public int compareTo(Student_align o) {
		return o.getscore() - score;
	}
	
	public int getgrade() {
		return grade;
	}
	public void setgrade(int grade) {
		this.grade = grade;
	}
	public int gethomeroom() {
		return homeroom;
	}
	public void sethomeroom(int homeroom) {
		this.homeroom = homeroom;
	}
	public int getnumber() {
		return number;
	}
	public void setnumber(int number) {
		this.number = number;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public int getscore() {
		return score;
	}
	public void setscore(int score) {
		this.score = score;
	}
	
	
	
	public Student_align(int grade, int homeroom, int number, String name, int score) {
		this.grade = grade;
		this.homeroom = homeroom;
		this.number = number;
		this.name = name;
		this.score = score;
		
	}
	@Override
	public String toString() {
		return grade + "학년 " + homeroom + "반 " + number + "번 " + name + "-" + "점수: " +score;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(grade, homeroom, number);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student_align other = (Student_align) obj;
		return grade == other.grade && homeroom == other.homeroom && number == other.number;
	}
	
}
