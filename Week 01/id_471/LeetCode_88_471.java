//每个数组从尾到头遍历，然后从大到小将数字插入到nums1中
//时间复杂度为 O(n+m)
//空间复杂度为 O(1)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        
        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }
        
        while(j >= 0){
            nums1[k--] = nums2[j--];
        }
    }
}

//方法2，使用一个中间数组，将 nums1 和 nums2 中的数组放入中间数组中，然后再把中间数组赋值给nums1
//时间复杂度为：O(m+n)
//空间复杂度为：O(m+n)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[nums1.length];
        int i = 0, j = 0, count = 0;
        
        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                temp[count++] = nums1[i++];
            }else{
                temp[count++] = nums2[j++];
            }
        }
        
        while(i < m){
            temp[count++] = nums1[i++];
        }
        while(j < n){
            temp[count++] = nums2[j++];
        }
        
        
        for(i = 0; i < temp.length; i++){
            nums1[i] = temp[i];
        }
    }
}

//将nums2中的数据放入nums1，然后排序
//时间复杂度为: O(nlogn)
//空间复杂度为：O(1)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        for(int i = m; i < m + n; i++){
            nums1[i] = nums2[i-m];
        }
        
        Arrays.sort(nums1);
    }
}