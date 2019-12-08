public class Solution
{
    public int Search(int[] nums, int target)
    {
        int index = -1;
        int left = 0;
        int right = nums.Length - 1;
        while (left <= right)
        {
            int mid = left + ((right - left) / 2);
            if (nums[mid] == target)
            {
                index = mid;
                break;
            }
            if (nums[left] <= nums[mid])
            {
                if (target >= nums[left] && target <= nums[mid])
                {
                    right = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }
            else
            {
                if (target > nums[mid] && target <= nums[right])
                {
                    left = mid + 1;
                }
                else
                {
                    right = mid - 1;
                }
            }
        }
        return index;
    }
}