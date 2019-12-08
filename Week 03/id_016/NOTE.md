# NOTE

二分查找特征:
1. 目标函数是单调的(单调递增,或者递减)
2. 存在上下界(bounded)
3. 能够通过索引访问(index accessible)

# 二分法 - 代码模版
```javascript
function main(arr, target) {
  // 1.定义左右边界
  let left = 0,
    right = arr.length - 1;
  let res = null;
  // 2.循环,当左小于右的时候
  while (left < right) {
    // 3.获取中间值下边
    let mid = Math.floor((left + right) / 2);
    // 4.中间值和目标值进行比较
    if (target === arr[mid]) {
      res = mid;
      break;
      // 目标值大于中间值,说明目标值在mid右侧
    } else if (target > arr[mid]) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }
  return res;
}
```

