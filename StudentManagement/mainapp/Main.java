package mainapp;
import models.Student;
import models.Course;  
import services.EnrollmentManager;  


import java.util.Scanner;

public class Main{
	
	public static String searchStudentbyId(Student[] students,String Id,int count){
		 
		 int i=0;
		 boolean found=false;
		 Student result=null;
		 while(i<count){
			 
			 if(students[i].getId().equals(Id)){
				
				found=true;
				result= students[i];
				
				break; 
			 }
			 
			i++;
			
			
			
			
			
			
		 }
		 
		if(found){
			System.out.println("Student found: "+ result);
			
		}else{
			System.out.println("Student not found ");
			
		} 
		 
		return null;
	} 
	public static void sortStudentsByName(Student[] students, int count) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (students[j].getName().compareToIgnoreCase(students[j + 1].getName()) > 0) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }
	
	public static void main(String[] args){
		
		Scanner scanner= new Scanner(System.in);
		EnrollmentManager manager = new EnrollmentManager();
        Course[] courses=new Course[10];
		int courseCount=0;
		courses[courseCount++] = new Course("SE2012", "Java Programming");
		courses[courseCount++] = new Course("SE2013", "Database Systems");
		courses[courseCount++] = new Course("SE2014", "Software Design");
		
		Student[] students= new Student[10];
		int count=0;
		boolean run=true;
		while(run){
			System.out.println("1.Input student details: ");
			System.out.println("2.Enroll students: ");
			System.out.println("3.Search students by ID: ");
			System.out.println("4.Sort students by name: ");
			System.out.println("5.List enrolled students: ");
			System.out.println("6.exit: ");
			System.out.println("Enter the choice: ");
			int choice=scanner.nextInt();
			scanner.nextLine();
			switch(choice){
				case 1:
					if (courseCount == 0){
						System.out.println("No courses available. Please add a course first.(option 2)");
						break;
					}
					for(int i=0;i<3;i++){
						System.out.println("Enter the name of the student: ");
						String Name=scanner.nextLine();
						System.out.println("Enter the student ID of the student: ");
						String ID=scanner.nextLine();
						
						students[count]=new Student(ID,Name);
						System.out.print("\n");
						
						
						count++;
						
					}
					

					break;
				case 2:
				
					System.out.println("Enter the student ID to enroll: ");
					String enrollId = scanner.nextLine();
					
					
					Student studentToEnroll = null;
					for (int i = 0; i < count; i++) {
						if (students[i].getId().equals(enrollId)) {
							studentToEnroll = students[i];
							break;
						}
					}
					
					if (studentToEnroll == null) {
						System.out.println("Student not found.");
						break;
					}
					
					System.out.println("Available courses:");
					for (int k = 0; k < courseCount; k++) {
						System.out.println((k + 1) + ". " + courses[k]);
					}
					System.out.println("Choose a course number: ");
					int courseChoice = scanner.nextInt();
					scanner.nextLine();
					
					if (courseChoice < 1 || courseChoice > courseCount) {
						System.out.println("Invalid course number.");
						break;
					}
					
					manager.enroll(studentToEnroll, courses[courseChoice - 1]);
    
					
					break;
					
				case 3:
				
					System.out.println("Enter student id: ");
					String searchId=scanner.nextLine();
					searchStudentbyId(students,searchId,count);
					break;
				
				
				
				
				case 4:
				
					sortStudentsByName(students,count);
					System.out.println("Students sorted by name. ");
					break;
				
				case 5:
					manager.listEnrollments();
                    break;
					
				
				case 6:
					run = false;
					System.out.println("Goodbye!");
					break;
					
					
				default:
					System.out.println("Invalid option. Please choose 1-4.");
				
			}
			
			
		}
	
	
		
		
		
		
		
	}
	
	
	
}





