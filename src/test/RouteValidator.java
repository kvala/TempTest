package test;

import java.util.ArrayList;
import java.util.HashMap;

public class RouteValidator {
	public static void main(String[] args) {
		ArrayList<String> routes = new ArrayList<String>();
		routes.add("p1");
		routes.add("d1");
		routes.add("d2");
		routes.add("p2");
		System.out.println(isValidRoute(routes));
	}

	public static Boolean isValidRoute(ArrayList<String> routes) {
		HashMap<String, Integer> counter = new HashMap<String, Integer>();
		for (String route : routes) {
			//System.out.println(route);
			Boolean isPickup = route.startsWith("p");
			String key = route.replace("p", "").replace("d", "");

			if (isPickup) {
				if (counter.containsKey(key)) {
					return false;
				} else {
					counter.put(key, 1);
				}
			} else {
				if (counter.containsKey(key)) {
					counter.put(key, counter.get(key) - 1);
				} else {
					return false;
				}
			}
		}
		for (String key : counter.keySet()) {
			if (counter.get(key) != 0) {
				return false;
			}
		}
		return true;
	}

}
