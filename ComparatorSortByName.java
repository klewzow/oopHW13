package com.gmail.klewzow;

import java.util.Comparator;

public class  ComparatorSortByName implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		
		if (o1 == null && o2 == null) {
			return 0;
		} else if (o1 == null) {
			return 1;
		} else if (o2 == null) {
			return -1;
		}
		
		Student first = (Student)o1;
		Student next = (Student)o2;
		return first.getName().compareTo(next.getName());
	}
 
} 
