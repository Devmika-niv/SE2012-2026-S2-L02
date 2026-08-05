package services;

import models.Student;
import models.Course;

public class EnrollmentManager {

    private Student[] enrolledStudents = new Student[10];
    private Course[] enrolledCourses = new Course[10];
    private int enrollmentCount = 0;

    public void enroll(Student student, Course course) {
        enrolledStudents[enrollmentCount] = student;
        enrolledCourses[enrollmentCount] = course;
        enrollmentCount++;

        System.out.println(student.getName() + " has been enrolled in " + course.getTitle());
    }

    public void listEnrollments() {
        for (int i = 0; i < enrollmentCount; i++) {
            System.out.println(enrolledStudents[i].getName() + " -> " + enrolledCourses[i].getTitle());
        }
    }
}