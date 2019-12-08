class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        List<Integer> left = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();  
        for (int num : arr2) {
            map.put(num, 0);
        }     
        for (int num : arr1) {
            if (map.containsKey(num)) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {
                left.add(num);
            }
        }
            int index = 0, i = 0;
            while (i < result.length && index < arr2.length) {
                int count = map.get(arr2[index]);
                while (count > 0) {
                    result[i++] = arr2[index];
                    count--;
                }
                index++;
            }
            if (left.size() > 0) {
                Collections.sort(left);
                for (int j = 0; j < left.size(); ++j) {
                    result[i++] = left.get(j);
                }
            }
        return result;
    }
}
