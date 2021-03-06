/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Point {
    int time;
    int flag;
    
    Point(int t, int s) {
        time = t;
        flag = s;
    }
    public static Comparator<Point> pointComparator = new Comparator<Point>() {
        public int compare(Point p1, Point p2) {
            if (p1.time == p2.time) {
                return p1.flag - p2.flag;
            } else {
                return p1.time - p2.time;
            }
        }
    };
}
class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        List<Point> list = new ArrayList<Point>();
        for (Interval i : airplanes) {
            list.add(new Point(i.start, 1));
            list.add(new Point(i.end, 0));
        }
        
        Collections.sort(list, Point.pointComparator);
        int count = 0, max = 0;
        for (Point p : list) {
            if (p.flag == 1) count++;
            else count--;
            max  = Math.max(max, count);
        }
        return max;
    }
}