package com.gmail.klewzow;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Groups implements Voenkomat {

	private Student[] studentsInGroup;

	public Groups() {
		super();
	}

	public Groups(int valueStudent) {
		super();
		this.studentsInGroup = new Student[valueStudent];
	}

	public void addStudentInteractive() {

		String arr[] = { "name \"  String \"", "surename \"  String \" ", "Age \"  int  : 16 - 55\"",
				"gender true\\false or man \\ woman", "nacionality  \"  String \"", "iPn", "groupName  \" int \"",
				"course \" int \"" };
		Student student = new Student();
		Scanner sc = new Scanner(System.in);
		for (int i = 0;;) {
			try {
				if (i > 7) {
					break;
				}
				System.out.println(arr[i].equals("iPn") ? "Added " + arr[i] + " : " : "Input :  " + arr[i] + " : \n");
				checkData(i, sc, student);
				i++;
				continue;
			} catch (IncorrectInputString e) {
				continue;
			} catch (InputMismatchException e) {
				e.printStackTrace();
				System.out.println("Input correct " + arr[i]);
				continue;
			} catch (NumberFormatException e) {
				System.err.println("Incorect - " + arr[i]);
				continue;
			}
		}

	}

	private void checkData(int i, Scanner sc, Student student)
			throws IncorrectInputString, NumberFormatException, InputMismatchException {
		switch (i) {
		case 0:
			student.setName(correctTnputString(sc.nextLine()));
			break;
		case 1:
			student.setSurename(correctTnputString(sc.nextLine()));
			break;
		case 2:
			student.setAge(correctTnputInt(sc.nextLine(), 16, 55));
			break;
		case 3:
			student.setGender(correctInputBoolean(sc.nextLine()));
			break;
		case 4:
			student.setNacionality(correctTnputString(sc.nextLine()));
			break;
		case 5:
			student.setiPn(addedtLong());
			break;
		case 6:
			student.setGroupName(correctTnputInt(sc.nextLine(), 0, Integer.MAX_VALUE));
			break;
		case 7:
			student.setCourse(correctTnputInt(sc.nextLine(), 0, 5));
			this.addStudent(student);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + i);
		}
	}

	private String correctTnputString(String string) throws IncorrectInputString {

		if (string.matches("[a-zA-Z]+") == false) {
			throw new IncorrectInputString();
		}
		return string;
	}

	private int correctTnputInt(String string, int minAge, int maxAge) throws NumberFormatException {

		int res = Integer.parseInt(string);
		if (res < minAge || res > maxAge) {
			throw new NumberFormatException();
		} else {

		}
		return res;
	}

	private long addedtLong() {

		long res = ((long) ((Math.random()) * 1_000_000_000));
		System.out.println(res);
		for (int i = 0; i < this.studentsInGroup.length; i++) {

			try {

				if (this.studentsInGroup[i].getiPn() != res) {
					continue;
				} else {
					res++;
					i = 0;
				}

			} catch (NullPointerException e) {
				continue;
			}
		}

		return res;
	}

	private boolean correctInputBoolean(String string) throws NumberFormatException {

		if (string.equals("true") || string.equals("man") || string.equals("1")) {

			return true;

		} else if (string.equals("false") || string.equals("woman") || string.equals("0")) {
			return false;
		} else {
			throw new NumberFormatException();
		}

	}

	public void addStudent(Student student) {
		for (int i = 0;; i++) {
			try {
				if (i >= studentsInGroup.length) {
					throw new MyExeption();
				}
				if (studentsInGroup[i] == null) {
					addS(student, i);
					break;
				}

			} catch (MyExeption e) {
				break;
			}

		}

	}

	private void addS(Student student, int i) throws MyExeption {

		studentsInGroup[i] = student;

	}

	public void delStudent(Student student) {

		for (int i = 0; i < studentsInGroup.length; i++) {
			try {

				if ((this.studentsInGroup[i].getSurename()).equals(student.getSurename())) {
					studentsInGroup[i] = null;
					break;
				}
			} catch (NullPointerException e) {

				continue;
			}

		}

		mySortNull(this.getStudentsInGroup());

	}

	private void mySortNull(Student[] groups) {
		int srt = 0;
		final Student[] tmpStudent = new Student[this.studentsInGroup.length];

		for (int i = 0; i < this.studentsInGroup.length; i++) {
			try {
				if (this.studentsInGroup[i].getiPn() != 0) {
					tmpStudent[srt] = this.studentsInGroup[i];
					srt++;
				}
			} catch (NullPointerException e) {
				continue;
			}

		}

		this.studentsInGroup = tmpStudent;

	}

	public Student searchStodentToSurename(String surename) {

		for (int i = 0; i < studentsInGroup.length; i++) {
			try {

				if ((this.studentsInGroup[i].getSurename()).equals(surename)) {

					return this.studentsInGroup[i];
				}
			} catch (NullPointerException e) {

				continue;
			}
		}

		return null;
	}

	public Groups sortByAge(Groups g) {

		try {
			Arrays.sort(g.getStudentsInGroup());
		} catch (NullPointerException e) {

		}

		return g;
	}

	@Override
	public Groups searchrRecruits() {

		Groups toArmy = new Groups(this.getStudentsInGroup().length);
		for (Student student : this.getStudentsInGroup()) {

			try {
				if (student.isGender() == true && student.getAge() >= 18) {
					toArmy.addStudent(student);
				}
			} catch (NullPointerException e) {
				continue;
			}

		}

		return toArmy;
	}

	public Student[] getStudentsInGroup() {
		return this.studentsInGroup;
	}

	public Student getStudentsInGroup(int inc) {
		return this.studentsInGroup[inc];
	}

	public void setStudentsInGroup(Student[] studentsInGroup) {
		this.studentsInGroup = studentsInGroup;
	}

	@Override
	public String toString() {
		return "Groups [ studentsInGroup=" + Arrays.toString(studentsInGroup) + "]";
	}

}
