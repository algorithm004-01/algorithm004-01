package id531

func removeDuplicates(nums []int) int {
	b:=0
	for a:=1;a<len(nums);a++ {
		if nums[b]!=nums[a] {
			nums[b+1]=nums[a]
			b++
		}
	}
	return b+1
}

func removeDuplicates2(nums []int) int {
	count:=0
	for i:=1;i<len(nums);i++ {
		if nums[i]==nums[i-1] {
			count++
		}else {
			nums[i-count]=nums[i]
		}
	}
	return len(nums)-count
}