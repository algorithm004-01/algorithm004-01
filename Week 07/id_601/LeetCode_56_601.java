class Solution {
    public int[][] merge(int[][] intervals) {
        // 排除特例
	    if (intervals.length <= 1) { return intervals; }

	    // 对二维数组的第1个元素排序
	    Arrays.sort(intervals, new Comparator<int[]>() {
	        @Override
	        public int compare(int[] o1, int[] o2) {
	            return o1[0] - o2[0];
	        }
	    });

	    // 开一个辅助结构存放结果
	    List<int[]> list = new ArrayList<>();
	    
	    // 这里从1开始遍历
	    for (int i = 1; i < intervals.length; i++) {
	        // 每次取出2个数组进行比较
	        int[] one = intervals[i-1];
	        int[] two = intervals[i];

	        // 如果头尾无重合，说明前一个数组与后面的数组不会产生任何重合（排序保证）
	        if (two[0] > one[1]) {
	                list.add(one);
	        } 
	        // 如果存在重合，第二个数组吸收第一个数组
	        else if (two[0] <= one[1]) {
	            two[0] = one[0];
	            two[1] = Math.max(one[1], two[1]);
	        }
	        // 别忘记最后一个数组
	        if (i == intervals.length - 1) {
	            list.add(two);
	        }
	    }

	    return list.toArray(new int[0][]);
    }
}
