package com.gmail.klewzow;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Groups {

	private Student[] studentsInGroup ;

	public Groups() {
		super();
	}
	public Groups(int valueStudent) {
		super();
		this.studentsInGroup =   new Student[valueStudent];
	}

	public void addStudentInteractive() {

		Student student = new Student();

		String arr[] = { "name \"  String \"", "surename \"  String \" ", "Age \"  int  : 16 - 55\"",
				"gender true\\false or man \\ woman", "nacionality  \"  String \"", "iPn", "groupName  \" int \"",
				"course \" int \"" };

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		for (int i = 0;;) {

			try {

				System.out.println(arr[i].equals("iPn") ? "Added " + arr[i] + " : " : "Input :  " + arr[i] + " : \n");

				if (i == 0) {
					student.setName(correctTnputString(sc.nextLine()));
					i++;
					continue;
				}
				if (i == 1) {
					student.setSurename(correctTnputString(sc.nextLine()));
					i++;
					continue;
				}
				if (i == 2) {
					try {
						student.setAge(correctTnputInt(sc.nextLine(), 16, 55));
						i++;
						continue;
					} catch (NumberFormatException e) {
						System.err.println("Incorect - " + arr[i]);
						continue;
					}
				}
				if (i == 3) {
					try {
						student.setGender(correctInputBoolean(sc.nextLine()));
						i++;
						continue;
					} catch (NumberFormatException e) {
						System.err.println("Incorect - " + arr[i]);
						continue;
					}
				}
				if (i == 4) {
					student.setNacionality(correctTnputString(sc.nextLine()));
					i++;
					continue;
				}
				if (i == 5) {

					student.setiPn(addedtLong());
					i++;
					continue;

				}
				if (i == 6) {

					try {
						student.setGroupName(correctTnputInt(sc.nextLine(), 0, Integer.MAX_VALUE));
						i++;
						continue;
					} catch (NumberFormatException e) {
						System.err.println("Incorect - " + arr[i]);
						continue;
					}
				}
				if (i == 7) {

					try {
						student.setCourse(correctTnputInt(sc.nextLine(), 0, 5));
					} catch (NumberFormatException e) {
						System.err.println("Incorect - " + arr[i]);
						continue;
					}
				}

				break;

			} catch (IncorrectInputString e) {

				continue;
			} catch (InputMismatchException e) {
				e.printStackTrace();
				System.out.println("Input correct " + arr[i]);
				continue;
			}

		}

		addStudent(student);
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
		int srt = 0;
		final Student[] tmpStudent = new Student[this.studentsInGroup.length];
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

	public Student[] getStudentsInGroup() {
		return this.studentsInGroup;
	}
	public Student  getStudentsInGroup(int inc) {
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
