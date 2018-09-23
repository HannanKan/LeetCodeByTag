import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Definition for an interval.
 */
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

class Solution13 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        //cornercase1
        //cornercase1
        ArrayList<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0){
            res.add(newInterval);
            return res;
        }
        Iterator<Interval> intervalIterator = intervals.listIterator();
        while (intervalIterator.hasNext()) {
            if (newInterval.end < intervals.get(0).start) {
                intervals.add(0, newInterval);
                res.addAll(res.size(), intervals);
                return res;
            } else if (newInterval.start <= intervals.get(0).start && newInterval.end <= intervals.get(0).end) {
                newInterval.end = intervals.get(0).end;
                intervals.remove(0);
            } else if (newInterval.start >= intervals.get(0).start && newInterval.end <= intervals.get(0).end) {
                res.addAll(res.size(), intervals);
                return res;
            } else if (newInterval.start <= intervals.get(0).end && newInterval.end >= intervals.get(0).end) {
                newInterval.start = intervals.get(0).start<newInterval.start?intervals.get(0).start:newInterval.start;
                intervals.remove(0);
            } else if (newInterval.start <= intervals.get(0).start && newInterval.end >= intervals.get(0).end) {
                intervals.remove(0);
            } else {
                res.add(res.size(),intervals.get(0));
                intervals.remove(0);
            }
        }
        res.add(res.size(),newInterval);
        return res;
    }
}
