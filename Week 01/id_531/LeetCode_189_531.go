package id531

func rotate(nums []int, k int)  {
	var pre int
	for i:=0;i <k;i++ {
		pre =nums[len(nums)-1]
		for j:=0;j <len(nums);j++ {
			pre,nums[j]=nums[j],pre
		}
	}
}

func rotate2(nums []int, k int)  {
	k%=len(nums)
	reverse(nums,0,len(nums)-1)
	reverse(nums,0,k-1)
	reverse(nums,k,len(nums)-1)
}

func reverse(nums []int,start,end int) {
	for start<end {
		nums[start],nums[end] =nums[end],nums[start]
		start++
		end--
	}
}