package main

import "fmt"

// Solution 1: Brute-Force
// Use two loops to search the right pair.
// Time Complexity : O(n^2)
// Space Complexity: O(1)

// Solution 2: Sort and Search
// Sort the copied nums[O(NlogN)], and use two pointers start/end to search the pair[O(N)].
// And search the indices in the original array.
// Time Complexity : O(NlogN)
// Space Complexity: O(N)

// Solution 3: Hash Record
// Use hash map to record number and index in iterating the nums to finding the pair.
// Time Complexity : O(N)
// Space Complexity: O(N)
func twoSum(nums []int, target int) []int {
	//	      num index
	m := make(map[int]int)

	for i, num := range nums {
		j, exists := m[target-num]

		if exists {
			return []int{i, j}
		}

		m[num] = i
	}

	return nil
}

func main() {
	fmt.Println(twoSum([]int{2, 7, 11, 15}, 9))
}
