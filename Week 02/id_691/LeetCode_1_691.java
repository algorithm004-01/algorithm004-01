class solution {
	//暴力求解
	public class twoSum (int[] num, int target) {
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num.length; j++) {
				if (num[j] = target - num[i]) {
					return new int[] {i, j};
				}
					
			}
			
		}
		
		throw IllegalArgumentException("No such two sum solution");
	}
	
	//两层哈希
	public class twoSum (int[] num, int target) {
		
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < num.length; i++){
			map.put(num[i], i);
		}
		
		for (int i = 0; i < num.length; i++) {
			int completment = target - num[i];
			if (map.containsKey(completment) && map.get(completment) != i) {
				return new int[] {i, map.get(completment)};
			}
		}
		
		throw new IllegalArgumetException("No such two solution");
		
	}
	
	//一层哈希
	public class twoSum(int[] num, int target) {
			
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < num.length; i++) {
			int complement = target - num[i];
			if(map.containsKey(complement)){
				return new int[] {i, map.get(completment)};
			}
			map.put(num[i],i);
		}
		
		throw new IllegalArgumentException("No such two solution");
	
	}

} 