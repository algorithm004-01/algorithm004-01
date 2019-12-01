package week07


//3.1 https://leetcode-cn.com/problems/relative-sort-array/
func relativeSortArray(arr1 []int, arr2 []int) []int {

	count := make([]int,1001)
    result := make([]int, 0, len(arr1))

    for _,num:=range arr1{
        count[num]++
    }
    
    for _,num:=range arr2{
        for j:=0; j<count[num]; j++{
            result=append(result,num)
        }
        count[num]=0
    }
    
    for i := 0; i < len(count); i++ {
        for j:=0; j<count[i]; j++{
            result=append(result,i)
        }
	}

    return result
}