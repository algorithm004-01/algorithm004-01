public class Solution
{
    public int MajorityElement(int[] nums)
    {
        Array.Sort(nums);
        return nums[nums.Length / 2];
    }
}