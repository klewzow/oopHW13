package com.gmail.klewzow;

public class Voenkomat {
	public Voenkomat() {
		super();
	}

	public Groups returnGroup(Groups group) {
		int valueArrayLength = countPiople(group);

		Groups returnGroup = new Groups(valueArrayLength);

		for (int i = 0; i < valueArrayLength; i++) {

			if (group.getStudentsInGroup(i).isGender() == true && group.getStudentsInGroup(i).getAge() >= 18
					&& group.getStudentsInGroup(i) != null) {

				returnGroup.addStudent(group.getStudentsInGroup(i));

			}

		}
		valueArrayLength = countPiople(returnGroup);

		Groups returnFormatedGroup = new Groups(valueArrayLength);
		for (int i = 0; i < valueArrayLength; i++) {
			returnFormatedGroup.addStudent(returnGroup.getStudentsInGroup(i));
		}

		return returnFormatedGroup;
	}

	private int countPiople(Groups group) {
		int tmp = 0;
		for (Student el : group.getStudentsInGroup()) {
			if (el != null) {
				tmp++;
			} else {
				continue;
			}
		}
		return tmp;
	}

}
