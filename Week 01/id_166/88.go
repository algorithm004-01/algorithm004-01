func merge(nums1 []int, m int, nums2 []int, n int)  {
    k := n+m-1
    i := m-1
    j:= n-1

    if i < 0 && j < 0 {
        return
    }
    for j >= 0&&i>=0 {
        if nums1[i]>=nums2[j] {
            nums1[k] = nums1[i]
            k--
            i--
        }else {
            nums1[k] = nums2[j]
            j--
            k--
        }
    }
    for j>=0 {
        nums1[k] = nums2[j]
        k--
        j--
    }
}
