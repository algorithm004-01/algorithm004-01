public class Solution
{
    public void MoveZeroes(int[] nums)
    {
        int id = 0;
        for (int i = 0; i < nums.Length; i++)
        {
            if (nums[i] != 0)
            {
                int temp = nums[id];
                nums[id] = nums[i];
                nums[i] = temp;
                id += 1;
            }
        }
    }
}