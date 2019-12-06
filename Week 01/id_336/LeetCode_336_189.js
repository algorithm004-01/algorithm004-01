// 解法一：
    // 暴力枚举
    // 时间复杂度 O(n * k) 如果k == n  && n很大 后果严重
    // 空间复杂度 O(1)
    var rotate = function(nums, k) {
        var n = nums.length;
        var tmpEnd = 0;
        var tmpPrev = 0;
        for(var i = 0;i<k;i++){
            tmpEnd = nums[n-1];
            for(var r = 0;r<n;r++){
                tmpPrev = nums[r];
                nums[r] = tmpEnd;
                tmpEnd = tmpPrev;
            }
        }
    };

// 解法二：
    // 绝地反转
    // 示例： [1,2,3,4,5,6,7] k = 4  => [4,5,6,7] + [1,2,3] == [4,5,6,7,1,2,3]
    //       [1,2,3,4,5,6,7] k = 11 => [4,5,6,7] + [1,2,3] == [4,5,6,7,1,2,3]  
    //       [1,2,3,4,5,6,7] k = 5  => [3,4,5,6,7]  +[1,2] == [3,4,5,6,7,1,2]
    // 由示例可以归纳出 k%n == 后面面 n - k%n 个元素 和 前面 k%n 个元素中间交界处 重新组合成一个新的数组的分界点，此点处整体调换两部分的数组即为所求
    var rotate = function(nums, k) {
        var n = nums.length;
        var reversePoint = n - k%n;
        reversePoint != 0 &&  (nums = nums.slice(reversePoint).concat(nums.slice(0,reversePoint)))
    }

// 解法三：
    // 原地反转
    // 时间复杂度 O(n) 反转了3次n个元素
    // 空间复杂度 O(1) 没使用额外的空间
    var rotate = function(nums, k) {
        var n = nums.length;
        k %= n;
        if(n == 1){
            return;
        }
        var tmp = 0;
        myReverse(0,n-1);
        myReverse(0,k-1);
        myReverse(k,n-1);
        function myReverse(start,end) {
            while (start < end) {
                tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                start++;
                end--;
            }
        }
    }