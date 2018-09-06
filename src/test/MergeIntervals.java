package test;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {

		Collections.sort(intervals, new IntervalComparator());
		LinkedList<Interval> result = new LinkedList<Interval>();

		if (intervals == null || intervals.size() == 0) {
			return result;
		}

		for (Interval i : intervals) {
			if (result.isEmpty() || result.getLast().end < i.start) {
				result.add(i);
			} else {
				result.getLast().end = Math.max(result.getLast().end, i.end);
			}
		}

		return result;
	}
}

class IntervalComparator implements Comparator<Interval> {
	@Override
	public int compare(Interval a, Interval b) {
		return a.start - b.start;
	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}
