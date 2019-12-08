public class Solution
{
    public int RemoveDuplicates(int[] nums)
    {
        if (nums is null || nums.Length == 0)
        {
            return 0;
        }
        else
        {
            int id = 0;
            for (int i = 1; i < nums.Length; i++)
            {
                if (nums[i] != nums[id])
                {
                    nums[id + 1] = nums[i];
                    id += 1;
                }
            }
            return id + 1;
        }
    }
}