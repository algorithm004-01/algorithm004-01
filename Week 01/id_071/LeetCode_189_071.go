package week01/id_071

func rotatees(nums []int, k int)  {

	var n int = len(nums)
	var new []int
	for i := 0; i < n; i++ {
		a[(i+k) % n] = nums[i]
	}
	for j := o; j < n; j++ {
		nums[i] = a[i]
	}
}

func rotate(nums []int, k int){
	k = k % len(nums)
	reverse(nums,0,len(nums)-1)
	reverse(nums,0,k - 1)
	reverse(nums,k,len(nums)-1)
}

func reverse(nums []int ,start int, end int){

	for start < end {
		nums[start],nums[end] = nums[end],nums[start]
		start++
		end--
	}
}