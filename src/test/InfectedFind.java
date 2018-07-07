package test;

import java.util.ArrayList;
import java.util.HashMap;

public class InfectedFind {

	public static void main(String[] args) {
		Student a = new Student("a");
		Student b = new Student("b");
		Student c = new Student("c");

		Student d = new Student("d");
		Student e = new Student("e");
		Student f = new Student("f");

		Student g = new Student("g");
		Student h = new Student("h");
		Student i = new Student("i");

		ArrayList<Student> l1 = new ArrayList<>();
		l1.add(g);
		l1.add(h);
		l1.add(i);

		c.setInfected(l1);

		ArrayList<Student> l2 = new ArrayList<>();
		l2.add(d);
		l2.add(e);
		l2.add(f);

		b.setInfected(l2);

		ArrayList<Student> l3 = new ArrayList<>();
		l3.add(b);
		l3.add(c);

		a.setInfected(l3);

		ArrayList<Student> input = new ArrayList<>();

		input.add(b);
		input.add(c);
		input.add(a);
		String inf = findInfected(input);

		System.out.println(inf);

	}

	public static String findInfected(ArrayList<Student> students) {

		if (students == null) {
			return "";
		}
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (Student s : students) {
			if (!map.containsKey(s.getId())) {
				map.put(s.getId(), 1);
			}

			for (Student c : s.getInfected()) {
				map.put(c.getId(), 0);
			}

		}

		for (String s : map.keySet()) {
			if (map.get(s) == 1) {
				return s;
			}
		}

		return "";
	}

}

class Student {
	private String id;
	private ArrayList<Student> infected;

	public Student(String id) {
		this.setId(id);
		this.setInfected(new ArrayList<>());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Student> getInfected() {
		return infected;
	}

	public void setInfected(ArrayList<Student> infected) {
		this.infected = infected;
	}

}
