class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int c = 0;
		int temp = 0;
		
		for (int i=0;i<arr2.length;i++){
			for (int j=0;j<arr1.length;j++){
				if (arr2[i] == arr1[j]){
					if (j==0) {
						c++;
						continue;
					}
					temp = arr1[c];
					arr1[c] = arr1[j];
					arr1[j] = temp;
					c++;
				}
			}
		}
		
		int minIndex = 0;
	    for (int i = c; i < arr1.length - 1; i++) {
	        minIndex = i;
	        for (int j = i + 1; j < arr1.length; j++) {
	            if (arr1[j] < arr1[minIndex]) {
	                minIndex = j;
	            }
	        }
	        temp = arr1[i];
	        arr1[i] = arr1[minIndex];
	        arr1[minIndex] = temp;
	    }
	    
        return arr1;
    }
}
