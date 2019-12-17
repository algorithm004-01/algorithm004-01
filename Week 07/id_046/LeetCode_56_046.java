class Solution {
    private static class Interval {
        int start;
        int end;
        Interval(int[] interval) {
            this.start = interval[0];
            this.end = interval[1];
        }

        int[] toArray() {
            return new int[]{this.start, this.end};
        }
    }

    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    private List<Interval> arraytoList(int[][] intervals){
        List<Interval> listRes = new ArrayList<>();
        for(int i = 0; i< intervals.length; i ++){
            listRes.add(new Interval(intervals[i]));
        }
        return listRes;
    } 

    public int[][] merge(int[][] intervals) {
        List<Interval> srcList = arraytoList(intervals);
        Collections.sort(srcList,new IntervalComparator());
        
        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : srcList) {
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }
        int[][] res = new int[merged.size()][2];
        for(int i = 0;i < merged.size(); i++){
            res[i] = merged.get(i).toArray();
        }

        return res;

    }
}


