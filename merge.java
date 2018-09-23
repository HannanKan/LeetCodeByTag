import java.util.*;

/**
 * Definition for an interval.
 */
/*class Interval {
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
}*/

public class Solution12 {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals==null||intervals.size()==0) return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;

            }
        });
        Interval current = null;
        List<Interval> res = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            if (current == null) {
                current = intervals.get(i);
            } else if (current.end >= intervals.get(i).start) {
                current.end = (intervals.get(i).end<current.end)?current.end:intervals.get(i).end;
                continue;
            } else {
                res.add(current);
                current = intervals.get(i);
            }
        }
        res.add(current);
        return res;
    }
}
