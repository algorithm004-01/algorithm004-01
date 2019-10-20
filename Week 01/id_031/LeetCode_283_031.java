package id_031;

/**
 * @author xuhaojie created on 2019-10-20
 */
public class LeetCode_283_031 {
  // 1. 暴力解法 两个循环
  // 2. 使用新数组
  // 3. 使用下标记录索引

  // 使用两个数组方式
  public void moveZeroes2(int[] nums) {

    //元素移动的起始位置
    int j = 0;
    //0的个数
    int zeroCount = 0;

    for (int index = 0; index < nums.length; index++) {
      //累计 0 的个数
      if (nums[index] == 0) {
        zeroCount++;
      }
      //将元素置换，并将位置往后移动一位
      else {
        nums[j] = nums[index];
        j++;
      }
    }

    //将尾部需要改为 0 的修改为 0
    for (; zeroCount > 0; zeroCount--) {
      nums[nums.length - zeroCount] = 0;
    }
  }


  //使用新数组解法
  public void moveZeroes(int[] nums) {
    int[] newNumbers = new int[nums.length];

    int j = 0;
    for (int index = 0; index < nums.length; index++) {
      if (nums[index] != 0) {
        newNumbers[j] = nums[index];
        j++;
      }
    }

    for (; j < nums.length - 1; j++) {
      newNumbers[j] = 0;
    }
    System.arraycopy(newNumbers, 0, nums, 0, nums.length);
  }


  //使用索引
  public void moveZeroes3(int[] nums) {
    int number0Index = 0;
    for (int index = 0; index < nums.length; index++) {
      if (nums[index] != 0) {
        nums[number0Index] = nums[index];
        if (index != number0Index) {
          nums[index] = 0;
        }
        number0Index++;
      }
    }

  }


  public static void main(String[] args) {
    new LeetCode_283_031().moveZeroes(new int[]{0, 1, 0, 3, 12});
    new LeetCode_283_031().moveZeroes2(new int[]{0, 1, 0, 3, 12});
    new LeetCode_283_031().moveZeroes3(new int[]{0, 1, 0, 3, 12});
  }

}
