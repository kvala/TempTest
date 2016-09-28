package test;

import java.util.Hashtable;

public class Temptest {

	public static void main(String[] args) {
		Hashtable<Integer, Integer> te = new Hashtable<Integer,Integer>();
		
		te.put(21,55);
		
		System.out.println(te.get(21));
		
		te.put(21, 75);
		te.put(22, 75);

		System.out.println(te.get(21));
		
		for(int t : te.keySet()){
			System.out.println("key: " + t + " Value: " + te.get(t));
		}
	}

}
