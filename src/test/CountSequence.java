package test;

import java.util.ArrayList;
import java.util.List;

public class CountSequence {

	public static void main(String[] args) {

		System.out.println(getList(6));
	}

	public static List<Integer> getList(int row) {
		ArrayList<List<Integer>> dataset = new ArrayList<List<Integer>>();
		List<Integer> i0 = new ArrayList<Integer>();
		i0.add(1);
		dataset.add(i0);
		for (int i = 1; i < row; i++) {
			List<Integer> currentrow = new ArrayList<Integer>();
			List<Integer> ipre = dataset.get(i - 1);
			int count = 1;
			int currentint = ipre.get(0);
			if(ipre.size() == 1){
				currentrow.add(count);
				currentrow.add(currentint);
			}

			for (Integer integer : ipre) {
				if (currentint == integer) {
					count++;
				} else {
					currentrow.add(count);
					currentrow.add(currentint);
					currentint = integer;
				}
			}
			dataset.add(currentrow);

		}
		return dataset.get(row - 1);

	}

}
