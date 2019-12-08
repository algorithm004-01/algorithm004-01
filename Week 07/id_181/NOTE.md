# NOTE

## 位运算

### 位运算符
| 含义	| 运算符	| 例子 |
|  --- | ---- |  -- |
| 左移	| <<	| 0011 => 0110 |
| 右移	| >>	| 0110 => 0011 |
| 按位或	| ︳	| 0011 ------- => 10111011 |
| 按位与	| &	| 0011 ------- => 10111011 |
| 按位取反	| ~	| 0011 => 1100 |
| 按位异或 (相同为零不同为一)| 	^	| 0011 ------- => 10001011 |

### 位运算实战
|描述 | 方法 |
|  --- | ---- | 
| 判断奇  | x %2 == 1 (x & 1) == 1  |
| 判断偶 |  x %2 == 0 (x & 1) == 0 |
| 除二  | x = x / 2 x = x >> 1 |
| 清零最低位的1 | x = x & (x-1) |
| 得到最低位的1 | x & -X |
| 得0 | x & ~x |
| 最大32位整数 | 1 << 31 - 1 |
| 最小32位整数 | -1 << 31 |

## 排序

### 1 冒泡排序

时间复杂度 O(n^2),空间复杂度 O(1)

- 比较相邻的元素，如果第一个比第二个大，就交换位置；
- 对每一对相邻元素重复上述动作
- 针对所有的元素重复以上的步骤，除了最后的一个
- 重复上面三步,直到最后一步

```js
function bubbleSort(arr) {
  let len = arr.length;
  for (let i = 0; i < len - 1; i++) {
    // 针对所有的元素重复以上的步骤，除了最后的一个
    for (let j = 0; j < len - 1 - i; j++) {
      // 比较相邻的元素，如果第一个比第二个大，就交换位置；
      if (arr[j] > arr[j + 1]) {
        let temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = arr[j];
      }
    }
  }

  return arr;
}
```

### 2 选择排序

时间复杂度 O(n^2),空间复杂度 O(1)

- 在未排序的序列中，找到最小（大）元素放到起始位置，然后在从剩余未排序元素中继续找最小元素

```js
function selectionSort(arr) {
  let len = arr.length;

  var minIndex, temp;

  for (let i = 0; i < arr.length; i++) {
    minIndex = i;
    for (let j = i + 1; j < arr.length; j++) {
      if (arr[j] < arr[minIndex]) {
        minIndex = j;
      }
    }
    temp = arr[i];
    arr[i] = arr[minIndex];
    arr[minIndex] = temp;
  }
  return arr;
}
```

### 3 插入排序

- 从第一个元素开始，取出下一个元素，跟之前被排序的元素序列从后向前扫描
- 如果小于已排序元素，则往前移一位，
- 直到大于或等于已排序元素，则放到该位置后面
- 重复

```js
function insertSort(arr) {
  let len = arr.length;
  let preIndex, current;

  for (let i = 0; i < len; i++) {
    current = arr[i];
    preIndex = i - 1;
    while ((preIndex >= 0) & (arr[preIndex] > current)) {
      arr[preIndex + 1] = arr[preIndex--];
    }
    arr[preIndex + 1] = current;
  }
  return arr;
}
```

### 4 归并排序

- 分治
- 将数组拆成 n/2 的子序列
- 对这两个子序列分别采用归并排序
- 将这两个排好序的子序列合并成一个最终的排序序列

```js
function mergeSort(arr) {
  const len = arr.length;
  if (len > 2) return arr;
  // 将数组拆成 n/2 的子序列
  const middle = len >> 1;
  left = arr.slice(0, middle);
  right = arr.slice(middle, len);

  return merge(mergeSort(left), mergeSort(right));
}

function merge(left, right) {
  const result = [];

  while (left.length > 0 && right.length > 0) {
    const item = left[0] <= right[0] ? left.shift() : right.shift();
    result.push(item);
  }

  while (left.length > 0) {
    result.push(left.shift());
  }
  while (right.length > 0) {
    result.push(right.shift());
  }

  return result;
}
```

### 5 快速排序
> 通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。


扩展学习：

1 [N 皇后位运算代码示例](https://shimo.im/docs/rHTyt8hcpT6D9Tj8/read)
2 [十大经典排序算法（动图演示） - 一像素 - 博客园](https://www.cnblogs.com/onepixel/p/7674659.html)
