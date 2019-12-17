import java.util.Scanner; 

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Course school = new Course(); 
		school.run();
		
		System.out.println("Do you want to find a roster number or get a students name? [Find/Get]");
		String answer = scan.next();
		if(answer.toLowerCase().equals("find")) {
			System.out.println("Whose Roster Number do you want to find?");
			String studName = scan.next(); 
			System.out.println(school.find(studName));
		} else {
			System.out.println("Which roster number are you searching with?");
			int studNum = scan.nextInt();
			System.out.println(school.get(studNum));
			
		}
	}
}

class Student {
	private String name; 
	
	public Student(String students) {
		name = students; 
	}
	
	public String toString() {
		return name; 
	}
	
	public void changeName(String newStudent) {
		name = newStudent; 
	}
	
	public String getName() {
		return name; 
	}
}

class Course {
	private int studentNum;
	private Student[] students; 
	private String courses; 
	private String teacher; 
	private String answer; 
	
	Scanner input = new Scanner(System.in);
	
	public Course() {
		courses = "Computer Science AP";
		teacher = "Johnny Appleseed";
		studentNum = 0;
		students = new Student[] {
				new Student("Anthony"), new Student("Barry"), new Student("Caid"), new Student("Denzel"),
				new Student("Eric"), new Student("Fangz"), new Student("Gary"), new Student("Harry"),
				new Student("Isaac"), new Student("Jack"), new Student("Kourosh"), new Student("Lucia")};
	}
	
	public void run() {
		System.out.println("Do you want to enroll students into your class? [Y/N]");
		answer = input.next(); 
		
		if(answer.toLowerCase().equals("y")) {
			enroll(); 
		} else {
			autonomous();
		}
		
		System.out.println("Run Complete");
	}
	
	public void enroll() {
		System.out.println("How many students are present?");
		studentNum = input.nextInt();
		
		System.out.println("Enrollment Process Executing");
		
		System.out.println("Who is teaching the class?");
		teacher = input.next();
		System.out.println("What class is being taught?");
		courses = input.next();
		Student[] newStudents = new Student[studentNum];
		for(int i = 0; i <= studentNum - 1; i++) {
			System.out.println("What is the name of Student " + (i + 1));
			String newStudent = input.next();
			newStudents[i].changeName(newStudent);
		}
		students = newStudents;
		toRet(); 
	}
	
	public void autonomous() {
		System.out.println("Auto-Enrollment Process Executing");
		
		studentNum = students.length;
		for(int i = 0; i < 16; i++) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("--");
		}
		
		System.out.println("\n");
		toRet();
	}
	
	public String find(String name) {
		for(int i = 0; i < students.length; i++) {
			if(students[i].getName().toLowerCase().equals(name.toLowerCase())) {
				return "Name: " + name + "\nRoster Number: " + (i+1);		
			}
		}
		return "Student Not Found" + "\nRoster Number: 0";
		
	}
	
	public String get(int x) {
		int y = x - 1; 
		
		if(studentNum >= 0 && x <= studentNum - 1) {
			return "Roster Number: " + x + "\nStudent: " + students[y];
		} else if(x > studentNum - 1) {
			return "Out of Range"; 
		}
		return "No Students enrolled"; 
	}
	
	public void toRet() { 
		System.out.println( "Teacher: " + teacher +"\nCourse: " + courses + "\n" + studentNum + " Enrolled"); 
		System.out.print("[");
		for(int i = 0; i < students.length - 1; i++) {
			System.out.print(students[i] + ", ");		
		}
		System.out.println(students[students.length - 1] + "]");
	}
}