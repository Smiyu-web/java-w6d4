package ca.java.collection.practice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Driver {
	
	public static Scanner input = new Scanner(System.in);
	
	
	public static void printMenu() {
		System.out.println("----Menu----"
			          	+ "\n1 - add a student"
			        	+ "\n2 - display all students"
			        	+ "\n3 - remove a student"
			        	+ "\n4 - quit");
	}
	
	public static Student addStudent() {
		System.out.print("Enter student id : ");
		int addId = input.nextInt();
		System.out.print("Enter email address : ");
		String addEmail = input.next();
		System.out.print("Enter full name : ");
		String addFullName = input.next();
		
		return new Student(addId, addEmail, addFullName);
	}
	
	public static void printList(LinkedList<Student> students) {
		Iterator iterator = students.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	public static int removeStudent(LinkedList<Student> students) {
		
		boolean isFound = false;
		
		while (!isFound) {
			System.out.print("Enter id you'd like to remove : ");
			int removeId = input.nextInt();
			
			for (int i = 0; i < students.size(); i++) {
				if (students.get(i).getId() == removeId) {
					System.out.println(students.get(i).getFullName() + " is removed.");
					isFound = true;
					return i;
				}
			}
			
			if (!isFound) {
				System.out.println("Couldn't find the id.");
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		LinkedList<Student> students = new LinkedList<>();
		students.add(new Student(123, "sarah@email.com", "Sarah Apple"));
		students.add(new Student(125, "john@email.com", "John Smith"));

		printMenu();
		boolean quit = false;
		
		while (!quit) {
			System.out.print("\nChoose what you want to do : ");
			int option = input.nextInt();
			
			
			switch (option) {
			case 1:
				students.add(addStudent());
				printList(students);
				break;
			case 2:
				printList(students);
				break;
			case 3:
				int removeId = removeStudent(students);
				students.remove(removeId);
				printList(students);
				break;
			case 4:
				quit = true;
				System.out.println("bye");
				break;
			}
		}
	}
}
