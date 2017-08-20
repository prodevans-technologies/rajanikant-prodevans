package com.prodevans.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<StudentComparable> list = new ArrayList<StudentComparable>();
		list.add(new StudentComparable(1, "ram", 10));
		list.add(new StudentComparable(2, "shyam", 10));
		list.add(new StudentComparable(3, "kavi", 10));
		list.add(new StudentComparable(1, "ravi", 9));
		list.add(new StudentComparable(2, "avi", 9));
		list.add(new StudentComparable(5, "rk", 9));
		list.add(new StudentComparable(3, "kama", 8));
		list.add(new StudentComparable(1, "rama", 8));
		list.add(new StudentComparable(2, "vip", 8));
		list.add(new StudentComparable(4, "vivek", 8));
		list.add(new StudentComparable(7, "anand", 8));
		list.add(new StudentComparable(8, "uj", 8));
		
		Collections.sort(list, Collections.reverseOrder());
		
		for(StudentComparable st : list) {
			System.out.println(st.toString());
		}
		
	}

}
