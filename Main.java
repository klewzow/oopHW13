package com.gmail.klewzow;

import java.util.Arrays;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Student[] student = new Student[10];
		student[0] = new Student("Alan", "Ivanov", 16, true, "Ukrainian", 25664877856l, 4, 7);
		student[1] = new Student("Vova", "Sidorov", 17, true, "Moldova", 46526566566l, 4, 7);
		student[2] = new Student("Kolia", "Nikolaev", 23, true, "Ukrainian", 4656549654978l, 4, 7);
		student[3] = new Student("Alga", "Kozlova", 18, false, "Ukrainian", 965464646446l, 4, 7);
		student[4] = new Student("Irina", "Mex", 23, false, "Ukrainian", 987946446466l, 4, 7);
		student[5] = new Student("Masha", "Masha", 20, false, "Moldova", 495979545662l, 4, 7);
		student[6] = new Student("Katerina", "Sorina", 29, false, "Ukrainian", 9795466266l, 4, 7);
		student[7] = new Student("Nina", "Klark", 19, false, "Deiche", 49592344234l, 4, 7);
		student[8] = new Student("Oleg", "Busina", 30, true, "Ukrainian", 9723234234236l, 4, 7);
		student[9] = new Student("Mirra", "Kuzina", 24, false, "Ukrainian", 9495994949994l, 4, 7);

		Groups grupA = new Groups(10);
		for (int i = 0; i < student.length; i++) {
			grupA.addStudent(student[i]);
		}

		grupA.addStudent(student[5]);
		grupA.addStudent(student[7]);
		grupA.delStudent(student[1]);
		grupA.delStudent(student[3]);
		grupA.delStudent(student[5]);
		grupA.delStudent(student[9]);

		grupA.addStudentInteractive();

		grupA.toString();
		System.out.println("Sort by Age :\n");
		grupA.sortByAge(grupA);

		for (Student st : grupA.getStudentsInGroup()) {
			System.out.println(st);
		}

		System.out.println("\n\n\n");

		ComparatorSortByName sortByName = new ComparatorSortByName();
		System.out.println("Sort by Name : \n");
		Arrays.sort(grupA.getStudentsInGroup(), sortByName);

		for (Student st : grupA.getStudentsInGroup()) {
			System.out.println(st);
		}
		System.out.println("\n\n\n");
		System.out.println("Sort by Surename :\n");
		ComparatorSortBySecondName sortBySurename = new ComparatorSortBySecondName();

		Arrays.sort(grupA.getStudentsInGroup(), sortBySurename);

		for (Student st : grupA.getStudentsInGroup()) {
			System.out.println(st);
		}

		System.out.println();
		System.out.println();

		System.out.println("Search Student -\n " + grupA.searchStodentToSurename("Ivanov"));
		System.out.println("Search Student - \n" + grupA.searchStodentToSurename("Klark"));
		System.out.println("\n\n ");
		System.out.println("From army :");

		Voenkomat vm = grupA.searchrRecruits();
		Groups recruts = vm.searchrRecruits();

		for (Student st : recruts.getStudentsInGroup()) {
			System.out.println(st);
		}

	}

}
