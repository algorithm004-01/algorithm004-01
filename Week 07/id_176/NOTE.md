## NOTE

### 指定位置的位运算

1. 将 x 最右边的 n 位清零:x & (~0 << n) 
2. 获取 x 的第 n 位值(0 或者 1): (x >> n) & 1 
3. 获取 x 的第 n 位的幂值:x & (1 << (n -1)) 
4. 仅将第 n 位置为 1:x | (1 << n) 
5. 仅将第 n 位置为 0:x & (~ (1 << n)) 
6. 将 x 最高位至第 n 位(含)清零:x & ((1 << n) - 1) 
7. 将第 n 位至第 0 位(含)清零:x & (~ ((1 << (n + 1)) - 1)) 

###实战位运算要点

判断奇偶:
 x % 2 == 1 —> (x & 1) == 1 x % 2 == 0 —> (x & 1) == 0 

x >> 1 —> x / 2
 即: x = x / 2; —> x = x >> 1; 

mid = (left + right) / 2; —> X = X & (X-1) 清零最低位的 1
 X & -X => 得到最低位的 1
 X & ~X => 0 

###N皇后位运算解法

```python
def totalNQueens(self, n): 
  if n < 1: return [] 
  self.count = 0 
  self.DFS(n, 0, 0, 0, 0) 
  return self.count

def DFS(self, n, row, cols, pie, na): 
  # recursion terminator
	if row >= n:
		self.count += 1 
    return
  
  bits=(~(cols|pie|na))&((1<<n)—1) # 得到当前所有的空位 
  
  while bits:
    p = bits & —bits # 取到最低位的1
    bits = bits & (bits — 1) # 表示在p位置上放入皇后
    self.DFS(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1)
    # 不需要revert cols, pie, na 的状态
```



### 布隆过滤器（Bloom Filter）

一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检索 一个元素是否在一个集合中。 

优点是空间效率和查询时间都远远超过一般的算法， 缺点是有一定的误识别率和删除困难。 

```python
from bitarray import bitarray
import mmh3
class BloomFilter:
  def __init__(self, size, hash_num):
    self.size = size
    self.hash_num = hash_num 
    self.bit_array = bitarray(size) 		 
    self.bit_array.setall(0)
  
  def add(self, s):
    for seed in range(self.hash_num):
      result = mmh3.hash(s, seed) % self.size 
      self.bit_array[result] = 1
      
  def lookup(self, s):
    for seed in range(self.hash_num):
      result = mmh3.hash(s, seed) % self.size 
      if self.bit_array[result] == 0:
      	return "Nope" 
  	return "Probably"
  
bf = BloomFilter(500000, 7) 
bf.add("dantezhao")
print (bf.lookup("dantezhao")) 
print (bf.lookup("yyj"))
```



###快速排序(Quick Sort) 

数组取标杆 pivot，将小元素放 pivot左边，大元素放右侧，然后依次 对右边和右边的子数组继续快排;以达到整个序列有序。 

```java
public static void quickSort(int[] array, int begin, int end) {
  if (end <= begin) return;
  int pivot = partition(array, begin, end);
  quickSort(array, begin, pivot - 1);
  quickSort(array, pivot + 1, end);
}

static int partition(int[] a, int begin, int end) { 
  
  // pivot: 标杆位置，counter: 小于pivot的元素的个数
	int pivot = end, counter = begin; 
  
  for (int i = begin; i < end; i++) {
		if (a[i] < a[pivot]) {
			int temp = a[counter]; a[counter] = a[i]; a[i] = temp; 
      counter++;
		}
  }
	int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
  return counter;
}
```



###归并排序(Merge Sort) — 分治 

1. 把长度为n的输入序列分成两个长度为n/2的子序列; 
2.  对这两个子序列分别采用归并排序;
3. 将两个排序好的子序列合并成一个最终的排序序列。 

```java
public static void mergeSort(int[] array, int left, int right) { 
  if (right <= left) return;
	int mid = (left + right) >> 1; // (left + right) / 2
  
  mergeSort(array, left, mid);
  mergeSort(array, mid + 1, right);
  merge(array, left, mid, right);
}

public static void merge(int[] arr, int left, int mid, int right) { 
  int[] temp = new int[right - left + 1]; // 中间数组
	int i = left, j = mid + 1, k = 0;
  
  while (i <= mid && j <= right) {
  	temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
  }
  
  while (i <= mid) temp[k++] = arr[i++];
  while (j <= right) temp[k++] = arr[j++];
  
  for (int p = 0; p < temp.length; p++) { 
    arr[left + p] = temp[p];
  }
  // 也可以用 System.arraycopy(a, start1, b, start2, length)
}
```

