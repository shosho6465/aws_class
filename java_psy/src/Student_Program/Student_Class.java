package Student_Program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Student_Class {
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		StudentManager individual = new StudentSelf();
        individual.add(new Student_align(1, 1, 1, " 궁홍샭", 10));
        individual.add(new Student_align(2, 2, 2, " 뱕눙출", 20));
	 	individual.add(new Student_align(3, 3, 3, " 기꾸픂", 30));
		individual.add(new Student_align(4, 4, 4, " 궁홍샭", 40));
		
		individual.printAll();
		System.out.println();
		
		
		
		try {
			System.out.println("검색할 학생 정보 입력"); 
			System.out.print("학년 입력: "); 
			int num1 = scan.nextInt();
			System.out.print("반 입력: ");
			int num2 = scan.nextInt();
			System.out.print("번호 입력: ");
			int num3 = scan.nextInt();
			
			System.out.print(individual.find(num1, num2, num3));
			System.out.println();
			
			System.out.println("삭제할 학생 정보 입력");
			System.out.println("학년 입력: ");
			int num4 = scan.nextInt();
			System.out.println("반 입력: ");
			int num5 = scan.nextInt();
			System.out.println("번호 입력: ");
			int num6 = scan.nextInt();
			System.out.println("삭제완료");
			System.out.println();
			
			individual.remove(num4, num5, num6);
			
			individual.sortByScore();
			
			individual.printAll();
		}catch (InputMismatchException e) {
			System.err.println("예외 발생");
			scan.nextLine();//입력 버퍼에 남아있는 문자열과 엔터를 제거
		}
	}
	
	

}
interface StudentManager{
	boolean add(Student_align student_align);
	Student_align remove(int grade, int classNum, int num);
	Student_align find(int grade, int classNum, int num);
	void printAll();
	void sortByScore();
}

class StudentSelf implements StudentManager{
	
	private ArrayList<Student_align> list = new ArrayList<>();
	
	@Override
	public boolean add(Student_align student_align) {
		if(student_align == null) {
			return false;
		}
		
		if(!list.contains(student_align)) {
			return list.add(student_align);
		}
		
		
		int index = list.indexOf(student_align);
		list.set(index, student_align);
		
		return false;
	}

	@Override
	public Student_align remove(int grade, int classNum, int num) {
		
		
		int index = list.indexOf(new Student_align(grade, classNum, num, "", 0));
		return list.remove(index);
//	}
		
	}

	@Override
	public Student_align find(int grade, int classNum, int num) {
		int index = list.indexOf(new Student_align(grade, classNum, num, "", 0));
//		if(index < 0 ) {
//			return null;
//		}
		return list.get(index);
	}

	@Override
	public void printAll() {
		for(Student_align gr : list) {
			System.out.println(gr);
		}
	}

	@Override
	public void sortByScore() {
		Collections.sort(list);
		
	}
	
}


