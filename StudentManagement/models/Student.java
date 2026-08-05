package models;

public class Student{

	private String id;
	private String name;
	
	public Student(String id,String name){
		
		this.id=id;
		this.name=name;
		
	}
	public String getName(){
		
		return name;
		
	}
	public String getId(){
		
		
		return id;
		
	}
	public String toString() {
        return "Student ID: " + id + ", Student Name: " + name;
    }
} 

