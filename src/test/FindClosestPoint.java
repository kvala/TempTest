package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindClosestPoint implements PointsOnAPlane {

	List<Point> points = new ArrayList<Point>();
	//To avoid duplicates
	// Set<Point> points = new HashSet<Point>();

	@Override
	public void addPoint(Point point) {
		points.add(point);

	}

	@Override
	public Collection<Point> findNearest(Point center, int p) {
		final PriorityQueue<Point> closestpoints = new PriorityQueue<Point>(p, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				return Double.compare(distance(p2, center), distance(p1, center));
			}
		});

		for (Point pt : points) {
			
			/*
			 * Do we really need this?
			if (center == pt) {
		        continue;
		      }
			*/
			
			if (closestpoints.size() < p) {
				closestpoints.add(pt);
			} else if (distance(pt, center) < distance(closestpoints.peek(), center)) {
				closestpoints.remove();
				closestpoints.add(pt);
			}
		}

		return closestpoints;
	}

	private double distance(Point peek, Point center) {
		return Math.hypot(peek.x - center.x, peek.y - center.y);
		//return Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2);
	}

	public static void main(String args[]) throws Exception {
		Point p1 = new Point(1, 1);
		Point p2 = new Point(0, 3);
		Point p3 = new Point(0, 4);
		Point p4 = new Point(0, 5);
		Point p5 = new Point(0, 6);
		Point p6 = new Point(0, 7);

		FindClosestPoint findp = new FindClosestPoint();
		findp.addPoint(p1);
		findp.addPoint(p2);
		findp.addPoint(p3);
		findp.addPoint(p4);
		findp.addPoint(p5);
		findp.addPoint(p6);

		Collection<Point> output = findp.findNearest(new Point(0, 0), 3);
		for (Point pt : output) {
			System.out.println(pt);
		}
	}

}
