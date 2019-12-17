# 第一周学习总结



## 总体

### 获得

- 如何自主学习算法
- 五毒神掌的运用实践
- 牢记空间换时间，升维
- 算法都是找最近重复性





### 缺失

- 没有做预习
- 许多解题都没有自己的思路
- 做题经常缺少最后一步 去国外网站查看discuss
- 没有把写代码前的思路先写出来 -> clean code -> 新闻稿





## 具体

1. 如何自主学习算法
   - 搜索引擎的运用
     - Queue java source ${version}
     - Queue java ${version}
     - java source code
   - 分析源码
     - 由于java鲁棒性强，所以可以查看java代码
     - 先看注释了解大致思路
     - 找到核心逻辑点
       - 看代码
       - 反复debug（不会的）逻辑点





2. 五毒神掌的使用
   - https://leetcode-cn.com/submissions/#/1 查看这个网址 去看 1天前做的什么题目 5天前做的什么题目 



3. 空间换时间
4. 最近重复性
   1. 栈 ：结合现实-> 洋葱 了解其结构   最近相关性 使用栈
   2. 队列： 结合现实 -> 排队 了解其结构 先来后到 使用队列







5. 没有做预习
   1. 这周开始做预习
6. 做题没有思路
   1. 花多一些时间 原本 5 -> 8分钟
   2. 把基础巩固扎实
7. 经常忘记查看discuss
   1. feedback的感觉不是很强烈 除了有一次看到比较逗比的算法除外

## 其他

1. 奇妙算法

   - 旋转数组 为什么可以通过 通过三次反转来将最后的结果获得？

2. 现实中运用栈这个数据结构，使用Deque。

3. 双指针

   1. 快慢指针
      1. 环状问题
      2. 重复值问题
   2. 夹壁定律？

4. review

   1. LeetCode_1_386

      1. 暴力法时间复杂度是O(n^2)

      2. 解法也是错误的其会反复利用同一个值

      3. 题目

         1. 他的解法

            ```java
            class SumOfTwoNumbers {
                public int[] twoSum(int[] nums, int target) {
                    int[] n = new int[2];
                    for (int i = 0; i < nums.length; i++) {
                        for (int j = 0; j < nums.length; j++) {
                            if (i != j && (nums[i] + nums[j] == target)) {
                                // System.out.println(i + ", " + j);
                                if (i < j) {
                                    n[0] = i;
                                    n[1] = j;   
                                } else {
                                    n[0] = j;
                                    n[1] = i;
                                }
                                return n;
                            }
                        }
                    }
                    return new int[0];
                }
            }
            ```

         2.  我修改后的解法

            ```java
            class Solution {
              public int[] twoSum(int[] nums, int target) {
                    int[] n = new int[2];
                    for (int i = 0; i < nums.length - 1; i++) {
                        for (int j =i + 1; j < nums.length; j++) {
                            if (i != j && (nums[i] + nums[j] == target)) {
                                n[0] = i;
                                n[1] = j;
                                return n;
                            }
                        }
                    }
                    return new int[0];
                }
            }
            ```

            

         3. 但时间复杂度过高 应该考虑 升维 通过使用 map来存储 每次遍历将元素存入，如果遇到以前存过的值和当前遍历值之和为目标直接返回有如下代码：

            ```java
            public int[] twoSum(int[] nums, int target) {
                  Map<Integer,Integer> map = new HashMap<>(nums.length);
                    for (int i = 0; i < nums.length; i++) {
                        Integer oldIndex = map.get(target - nums[i]);
                        if (oldIndex == null) {
                            map.put(nums[i],i);
                        }else {
                            return new int[] {oldIndex,i};
                        }
                    }
                    throw new RuntimeException("error not found");
                }
            ```

            

   2. [LeetCode_ 26_506](https://github.com/algorithm004-01/algorithm004-01/pull/140/files#diff-c35b3c96cd8bf526be962faaeb3931fd)

      1. 说明： 这个方法和官方题解思维逻辑上没有太大的区别。但存在边界值的问题. 然后发现自己写得代码传入空数组也是一样返回1，应加入前置判断

         ```java
          if (nums.length == 0) return 0;
         ```

   3. https://github.com/algorithm004-01/algorithm004-01/pull/163/files  这个自己有写测试类，移出重复值仍然跟上面一样存在问题。

   4. mark https://github.com/algorithm004-01/algorithm004-01/issues/160 别人的解题方式。比我的高级多了，可以学习一下

      > 每道题的第一次完解控制在1h
      > \1. 审题,理解题意
      > \2. 先问自己,这个问题属于哪类算法问题?
      > \1. 列出所有可能得算法,每种方法的时间复杂度
      > \2. 要将不熟悉的题转换成熟悉的题(比如:三数求和—>2数求和—>双指针)
      > \3. 再思考并写下所给条件中有哪些性质是可以利用的?
      > \1. 比如题中有序数组的有序就是一个可以利用的条件)
      > \2. 比如题中是否存在,就联想到哈希表的数据结构
      > \4. 这类算法问题通常的解题思路?
      > \1. “解决链表问题最好的办法是在脑中或者纸上把链表画出来”
      > \2. 数组—>双指针
      > \5. 以上4点需要在15min 内完成
      > \6. 先用伪代码写出逻辑，再补全小段代码
      > \7. 找重复性(重复单元)
      > \8. notion记录自己的解题过程(这一点很重要,可以发现自己的缺陷,方便日后对景对情),和最优解做对比
      > \9. 将**不同的解法**,制成anki 卡片记录
      > \1. 搜索优质解题方法和思路(博客,leetcode 国际站)
      > \2. 制作 gif 图片
      > \10. 五遍刷题法,重写所有的解法

      最后可以将所有的题目类似的 进行归类 反向归类

   5. https://github.com/algorithm004-01/algorithm004-01/issues/109 我也可以将自己梳理的发到自己的博客上。