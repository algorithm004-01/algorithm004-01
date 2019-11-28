class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        List<int[]> result = new ArrayList<>();
        List<int[]> nextList = new ArrayList<>();
        int[] temp = intervals[0];
        boolean doCombine = false;
        for (int i = 1; i < intervals.length; i++) {
            if(temp[1] < intervals[i][1]) {
                if(temp[1] >= intervals[i][0] && temp[1] <= intervals[i][1]) {
                    temp[0] = Math.min(temp[0], intervals[i][0]);
                    temp[1] = Math.max(temp[1], intervals[i][1]);
                    doCombine = true;
                } else {
                    nextList.add(intervals[i]);
                }
            } else {
                if(intervals[i][1] >= temp[0] && intervals[i][1] <= temp[1]) {
                    temp[0] = Math.min(temp[0], intervals[i][0]);
                    temp[1] = Math.max(temp[1], intervals[i][1]);
                    doCombine = true;
                } else {
                    nextList.add(intervals[i]);
                }
            }
        }

        if(doCombine) {
            nextList.add(temp);
        } else {
            result.add(temp);
        }

        if(nextList.size() > 0) {
            int[][] nextResult = merge(nextList.toArray(new int[nextList.size()][]));
            result.addAll(Arrays.asList(nextResult));
        }

        return result.toArray(new int[result.size()][]);
    }
}
